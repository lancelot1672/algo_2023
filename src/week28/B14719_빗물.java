package week28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719_빗물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] tank = new int[N][M];
        st = new StringTokenizer(br.readLine());

        int maxIndex = 0;
        int max = 0;

        for(int j=0; j<M; j++){
            int num = Integer.parseInt(st.nextToken());
            if(max < num){
                max = num;
                maxIndex = j;
            }
            for(int i=N-1; i>N-1-num; i--){
                tank[i][j] = 1;
            }
        }
        // 왼쪽
        for(int i=0; i<N; i++){

        }
        // 오른쪽

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(tank[i][j]);
            }
            System.out.println();
        }

    }
}
