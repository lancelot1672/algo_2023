package week47;

// 맨 뒤 부터 앞으로 오면서
// i 부터 N까지 더한 값을 저장
// 1번 벌을 0번에 놓기
// 2번 벌을 i+1번부터 놓으면서 저장 ㄱㄱ

// 벌통 위치
// 왼쪽 끝일 때
// 오른쪽 끝일 때
// 중간일 때

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B21758_꿀따기 {
    static int answer;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[N];
        int temp = 0;
        for(int i=0; i<N; i++){
            temp += arr[i];
            left[i] = temp;
        }

        int[] right = new int[N];
        temp = 0;
        for(int i=N-1; i>=0; i--){
            temp += arr[i];
            right[i] = temp;
        }
        answer = 0;

        //벌통 위치 옮기기
        for(int i=0; i<N; i++){
            oneone(i, left, right);
            twoZero(i, left, arr);
            zeroTwo(i, right, arr);
        }

        System.out.println(answer);
    }
    static void twoZero(int tong, int[] left, int[] arr){
        int sum = left[tong] - arr[0]; //36
        for(int i=1; i<tong; i++){
            int max = sum + (left[tong] - left[i]) - arr[i];
            // i = 3
            // 36 + (45 - 23) - 1 = 21
            answer = Math.max(max, answer);
        }

    }
    static void oneone(int tong, int[] left, int[] right){
        answer = Math.max(left[tong] - left[0] + right[tong] - right[N-1], answer);
    }
    static void zeroTwo(int tong, int[] right, int[] arr){
        int sum = right[tong] - arr[N-1];
        for(int i=N-2; i>tong; i--){
            int max = sum + (right[tong] - right[i]) - arr[i];

            answer = Math.max(max, answer);
        }
    }
}