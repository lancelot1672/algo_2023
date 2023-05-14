package week34;
import java.util.*;
import java.io.*;

/**
 * 25m
 */
public class B20006_랭킹전대기열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Room> roomList = new ArrayList<>();

        // user into Map
        HashMap<String, Integer> userInfo = new HashMap<>();

        // 플레이어 수만큼 반복
        for(int p = 0; p<P; p++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            userInfo.put(nickname, level);

            int check = 0;
            for(Room room : roomList){
                //정원이 다 차있다면 패스
                if(room.userList.size() == M){
                    check++;
                    continue;
                }

                //-10 ~ +10 벗어나면
                if(Math.abs(level - room.level) > 10){
                    check++;
                    continue;
                }
                //입장
                room.userList.add(nickname);
                break;
            }
            //새로운 방이 없다면
            if(check == roomList.size()){
                Room r = new Room(roomList.size()+1, level);
                r.userList.add(nickname);
                roomList.add(r);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Room room : roomList){
            ArrayList<String> userList = room.userList;
            Collections.sort(userList);    // 사전순 정렬

            sb.append( userList.size() == M ? "Started!\n" : "Waiting!\n");
            for(String nickname : userList){
                sb.append(userInfo.get(nickname) + " ");
                sb.append(nickname + "\n");
            }
        }
        System.out.println(sb.toString());
    }
    static class Room {
        int roomId;
        int level;
        ArrayList<String> userList;

        public Room(int roomId, int level){
            this.roomId = roomId;
            this.level = level;
            this.userList = new ArrayList<String>();
        }
    }
}