package week29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2467_용액 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int M = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] < 0) M++; // 알칼리 갯수
        }
        //만약 알칼리만 있다면
        if(M == N){
            System.out.println(arr[N-2] + " " + arr[N-1]);
            return;
        }
        //만약 산성만 있다면
        if(M == 0){
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        //양수 부분에서 더 크다면
        if(M <= N-2){
            if(Math.abs(arr[M] + arr[M+1]) < min){
                min = Math.abs(arr[M] + arr[M+1]);
                answer[0] = arr[M];
                answer[1] = arr[M+1];
            }
        }
        // 음수 부분에서 더 크다면
        if(M >= 2){
            if(Math.abs(arr[M-2] + arr[M-1]) < min){
                min = Math.abs(arr[M-2] + arr[M-1]);
                answer[0] = arr[M-2];
                answer[1] = arr[M-1];
            }
        }
        // 양수 음수 섞어서 더 크다면
        for(int i=0; i<M; i++){
            for(int j=M; j<N; j++){
                int temp = arr[i] + arr[j];
                if(Math.abs(min) > Math.abs(temp)){
                    min = Math.min(Math.abs(min), Math.abs(temp));
                    answer[0] = arr[i];
                    answer[1] = arr[j];
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
