package week43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10655_마라톤1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }
        int maxValue = 0;
        int maxIdx = 0;
        for(int i=1; i<=N-2; i++){
            int a = Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
            int b = Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i+1][1]);
            int c = Math.abs(arr[i-1][0] - arr[i+1][0]) + Math.abs(arr[i-1][1] - arr[i+1][1]);

            //최솟값 갱신
            if(a + b > c && a + b - c > maxValue){
                maxValue = a + b - c;
                maxIdx = i;
            }
        }

        int sum = 0;

        for(int i=1; i<=N-1; i++){
            if(i == maxIdx || i-1 == maxIdx) continue;
            sum += Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
        }
        sum += Math.abs(arr[maxIdx-1][0] - arr[maxIdx+1][0]) + Math.abs(arr[maxIdx-1][1] - arr[maxIdx+1][1]);
        System.out.println(sum);
    }
}
