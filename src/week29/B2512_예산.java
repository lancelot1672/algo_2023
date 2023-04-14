package week29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512_예산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] country = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++){
            country[i] = Integer.parseInt(st.nextToken());
            sum += country[i];
        }
        int total = Integer.parseInt(br.readLine());

        int R = Arrays.stream(country).max().getAsInt();
        int L = (total / N);

        // 예산 충분
        if(sum <= total){
            System.out.println(R);
            return;
        }

        int answer = 0;
        int M = 0;
        while(R > L){
            // 중간 값
            M = (R + L) / 2;

//            System.out.println("R : " + R + ", L : " + L);
            //확인
            int amount = 0;
            for(int i=0; i<N; i++){
                if(M >= country[i]){
                    amount += country[i];   // 어 그만큼 ㅇㅋ
                }else{
                    amount += M;    // 이거밖에 못줘
                }
            }
//            System.out.println(amount);
            if(amount > total){ // 총 양보다 더 크다면 못줌!
                R = M;
            }else if(amount < total){ // 더 줄 수 있음!!
                if(answer == M){
                    break;
                }
                answer = Math.max(answer, M);

                L = M;

            }else{  // 딱맞아!
                if(answer == M){
                    break;
                }
                answer = Math.max(answer, M);
                break;
            }
        }
        System.out.println(answer);
    }
}
