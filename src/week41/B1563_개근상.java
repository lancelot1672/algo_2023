package week41;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간초과
 */

public class B1563_개근상 {
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = 0;

        char[] arr = new char[N];

        dfs(0, arr, 0, 0);
        System.out.println(answer);
    }
    static void dfs(int idx, char[] arr, int Lcnt, int Acnt){
        if(idx == N){
            answer++;
//            System.out.println(Arrays.toString(arr));
            return;
        }
        //결석 카운트 초기화
        if(idx > 0 && arr[idx - 1] != 'A'){
            Acnt = 0;
        }
        //지각 카운트
        if(Lcnt == 0){
            arr[idx] = 'L';
            dfs(idx+1, arr, Lcnt+1, Acnt);
        }
        //결석 카운트
        if(Acnt < 2){
            arr[idx] = 'A';
            dfs(idx+1, arr, Lcnt, Acnt+1);
        }
        arr[idx] = 'O';
        dfs(idx+1, arr, Lcnt, Acnt);
    }
}