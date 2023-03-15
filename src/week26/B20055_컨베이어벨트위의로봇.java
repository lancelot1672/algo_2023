package week26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20055_컨베이어벨트위의로봇 {
    /**
     *
     * 한번 돌 때마다 배열 돌리기
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] convey = new int[N * 2];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++){
            convey[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robotLocArray = new boolean[N];
        int totalCnt = 0;
        int answer = 1;

        while(true){
            // 1.1 벨트 회전
            int tmp = convey[N * 2 -1];
            for(int i = N * 2 - 1; i > 0; i--){
                convey[i] = convey[i-1];
            }
            convey[0] = tmp;

            // 1.2 로봇 회전
            for(int i=N-1; i>0; i--) {
                if (robotLocArray[i - 1]) {
                    robotLocArray[i] = robotLocArray[i - 1];
                    robotLocArray[i - 1] = false;
                }
            }
            // 로봇 위치가 N-1 이라면 내린다.
            if(robotLocArray[N-1]){
                robotLocArray[N-1] = false;
            }

            // 2. 벨트가 회전하는 방향으로 한칸 이동
            for(int i=N-1; i>0; i--){
                if(!robotLocArray[i-1]) continue;
                if(!robotLocArray[i] && convey[i] != 0){
                    // 로봇 한칸 이동
                    robotLocArray[i] = robotLocArray[i-1];
                    robotLocArray[i-1] = false;

                    //내구도 감소
                    convey[i]--;
                    if(convey[i] == 0) totalCnt++;
                }
            }

            if(robotLocArray[N-1]){
                robotLocArray[N-1] = false;
            }

            // 3. 올리는 위치에 있는 칸이 내구도가 0이 아니라면 로봇 올리기
            if(convey[0] != 0){
                robotLocArray[0] = true;
                //내구도 감소
                convey[0]--;
                if(convey[0] == 0) totalCnt++;
            }
            // 4. 내구도가 0인 칸의 갯수가 K개 이상이라면 종료
            if(totalCnt >= K) break;
            answer++;
        }
        System.out.println(answer);
    }
}
