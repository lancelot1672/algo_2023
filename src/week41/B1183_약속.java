package week41;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1183_약속 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];

        int T = 0;
        StringTokenizer st;

        int total = 0;
        for(int n=0;n<N; n++){
            st = new StringTokenizer(br.readLine());


            number[n] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());

            //T값 정하기
            T = Math.max(T, number[n]);

            total += number[n];

        }// end Input



        int answer = 1;
        int min = Integer.MAX_VALUE;

        for(int t=T; t>=T * -1; t--){
            //기다리는 시간의 합 구하기
            int sum = 0;
            for (int n=0; n<N; n++){
                sum += Math.abs(number[n] + t);
                if(sum > min) break;
            }

            //min보다 작으면 카운트 다시
            if(min > sum){
                min = sum;
                answer = 1;
                //System.out.println("sum : " + sum + ",초기화 T : " + t);
            }else if(min == sum){   // 같으면 카운트
                answer++;
                //System.out.println(t);
            }
        }
        System.out.println(answer);
    }
}