package week39;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean[] picked;
    static int[] output;
    static int N;
    static String input;
    static int max;
    static String answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        N = input.length();
        // 1부터 N까지 최대 50개
        // 9 + 40 * 2 = 약 90
        picked = new boolean[9 + 41];
        output = new int[9 + 41];
        max = 0;
        answer = "";

        dfs(0, 0);

        System.out.println(answer);
    }
    static void dfs(int idx, int cnt){
        if(idx == N){
            if(max <= cnt){
                max = cnt;  // 최댓값 갱신
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<cnt; i++){
                    sb.append(output[i] + " ");
                }
                answer = sb.toString();
                System.out.println(cnt);
                System.out.println(answer);
            }
            return;
        }

        //한 자리 수
        int num1 = Integer.parseInt(input.substring(idx, idx+1));
        if(num1 != 0 && !picked[num1]){
            picked[num1] = true;
            output[cnt] = num1;
            dfs(idx+1, cnt+1);
            picked[num1] = false;
        }

        if(idx + 2 > N) return;
        //두 자리 수
        int num2 = Integer.parseInt(input.substring(idx, idx+2));
        if(num2 <= 50 && !picked[num2]){
            picked[num2] = true;
            output[cnt] = num2;
            dfs(idx+2, cnt+1);
            picked[num2] = false;
        }
    }
}