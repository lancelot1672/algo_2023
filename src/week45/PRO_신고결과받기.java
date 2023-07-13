package week45;
import java.util.*;
public class PRO_신고결과받기 {
    //16:10 ~ 16:33
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        boolean[][] visited = new boolean[id_list.length][id_list.length];
        Map<String, User> userMap = new HashMap<>();
        Map<String, Integer> reportMap = new HashMap<>();
        Set<String> benList = new HashSet<>();

        // id를 만들어주자
        int idx = 0;
        for(String userId : id_list){
            userMap.put(userId, new User(idx++));
            reportMap.put(userId, 0);
        }

        for(String r : report){
            StringTokenizer st = new StringTokenizer(r);    // 공백 분리

            // a가 b를 신고
            String a = st.nextToken();
            String b = st.nextToken();

            int a_id = userMap.get(a).id;
            int b_id = userMap.get(b).id;
            if(visited[a_id][b_id]) continue;   // 이미 a는 b를 신고했어

            // a 입장에서 내가 신고한 리스트에 넣어야함
            User user = userMap.get(a);
            user.list.add(b);
            visited[a_id][b_id] = true; //한번만 신고 가능

            // b 입장에서 신고당한 횟수 + 1
            int reportCnt = reportMap.get(b);
            reportMap.put(b, reportCnt + 1);

            // k번 이상 신고 당하면 너 벤
            if(reportCnt + 1 >= k) benList.add(b);
        }

        idx = 0;
        for(String userId : id_list){
            User user = userMap.get(userId);
            ArrayList<String> list = user.list;

            int cnt = 0;
            //내가 신고한 유저가 벤당한 갯수
            for(String id : list){
                if(benList.contains(id)) cnt++;
            }


            answer[idx++] = cnt;
        }
        //id 순서대로 출력해주어야 함.
        return answer;
    }
}
class User {
    int id;
    ArrayList<String> list;
    public User(int id){
        this.id = id;
        list = new ArrayList<>();
    }
}