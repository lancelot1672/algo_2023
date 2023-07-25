package week47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465_스티커 {
    static int N;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
        N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N];
            for(int i=0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int n=0; n<N; n++){
                    arr[i][n] = Integer.parseInt(st.nextToken());
                }
            }
            int[][][] D = new int[2][2][N+1];

            for(int i=0; i<N; i++){
                //선택 후 대각선 선택하고 갈 때
                if(D[1][1][i+1] < D[1][0][i] + arr[1][i]){
                    D[1][1][i+1] = D[1][0][i] + arr[1][i];
                }
                if(D[1][0][i+1] < D[1][1][i] + arr[0][i]){
                    D[1][0][i+1] = D[1][1][i] + arr[0][i];
                }
                //선택 후 대각선 선택 X
                if(D[0][1][i+1] < D[1][0][i]){
                    D[0][1][i+1] = D[1][0][i];
                }
                if(D[0][0][i+1] < D[1][1][i]){
                    D[0][0][i+1] = D[1][1][i];
                }
                //선택하지 않고 왔을 때, 2방향 가능
                //위
                if(D[1][0][i+1] < D[0][0][i] + arr[0][i]){
                    D[1][0][i+1] = D[0][0][i] + arr[0][i];
                }
                if(D[1][1][i+1] < D[0][0][i] + arr[1][i]){
                    D[1][1][i+1] = D[0][0][i] + arr[1][i];
                }
                // 아래
                if(D[1][0][i+1] < D[0][1][i] + arr[0][i]){
                    D[1][0][i+1] = D[0][1][i] + arr[0][i];
                }
                if(D[1][1][i+1] < D[0][1][i] + arr[1][i]){
                    D[1][1][i+1] = D[0][1][i] + arr[1][i];
                }
                //선택하지 않고 왔을 때, 선택 안할 거

            }
            int answer = 0;
            for(int a=0; a<2; a++){
                for(int b=0; b<2; b++){
                    answer = Math.max(answer, D[a][b][N]);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}