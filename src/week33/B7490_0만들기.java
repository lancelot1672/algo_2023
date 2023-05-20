package week33;

import java.io.*;
import java.util.*;

/**
 * B7490 0만들기
 * 54m 30s
 */
public class B7490_0만들기 {
    static int N;
    static StringBuilder totalString;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());
            select = new char[N-1];
            totalString = new StringBuilder();
            dfs(0);
            System.out.println(totalString.toString());
        }// end tc
    }
    static char[] opers = {' ','+','-'};
    static char[] select;
    static void dfs(int idx){
        if(idx == N-1){    // N-1개 뽑았어?
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=N; i++){
                //숫자 넣기
                sb.append(i);

                //연산자 넣기
                if(i != N){
                    sb.append(select[i-1]);
                }
            }

            // 공백 제거
            String s = sb.toString();
            s = s.replaceAll(" ", "");
            StringTokenizer st = new StringTokenizer(s, "+|-");

            //첫 번째 수
            int sum = Integer.parseInt(st.nextToken());
            int index=0;
            while(st.hasMoreElements()){
                if(index == N-1) return;
                if(select[index] == ' '){
                    index++;
                    continue;
                }
                if(select[index] == '+')
                    sum += Integer.parseInt(st.nextToken());
                else if(select[index] == '-')
                    sum -= Integer.parseInt(st.nextToken());
                index++;
            }
            if(sum == 0){
                totalString.append(sb.toString() + "\n");
            }

            return;
        }
        for(int i=0; i<3; i++){
            select[idx] = opers[i];
            dfs(idx+1);
        }
    }
}