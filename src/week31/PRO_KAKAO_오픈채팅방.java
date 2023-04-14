package week31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PRO_KAKAO_오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, User> cache = new HashMap<>();

        int i = 0;
        for(String s : record){
            //Tokenizer
            StringTokenizer st = new StringTokenizer(s);

            String order = st.nextToken();
            String userId = st.nextToken();
            String nickName = "";
            if(!order.equals("Leave"))
                nickName = st.nextToken();

            User user = null;
            if(cache.get(userId) != null){  // 메세지 cache가 존재?
                user = cache.get(userId);
            }else{
                // 새로운 유저
                user = new User(nickName);
            }
            //Enter 명령어
            if(order.equals("Enter")){
                user.nickName = nickName;
                user.msg.add(new String[]{"" + i++, "님이 들어왔습니다."});
            }else if(order.equals("Leave")){
                user.msg.add(new String[]{"" + i++, "님이 나갔습니다."});
            }else{  // change
                user.nickName = nickName;
            }

            //cache에 추가
            cache.put(userId, user);
        }
        answer = new String[i];

        //HashMap 돌기
        for(String key : cache.keySet()){
            User user = cache.get(key);
            for(String[] msg : user.msg){
                int index = Integer.parseInt(msg[0]);
                String text = msg[1];

                answer[index] = user.nickName + text;
            }
        }
        return answer;
    }
    class User {
        String nickName;
        ArrayList<String[]> msg = new ArrayList<>();

        public User(String nickName){
            this.nickName = nickName;
        }
    }
}
