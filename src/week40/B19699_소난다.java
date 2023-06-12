package week40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 22m
 * 조합 + 소수 구하기
 * isPrime 메서드는 소수인지 판별하는 메서드이다.
 * 1을 제외하고 2부터 N/2까지 나누었을 때 나머지가 0이면 소수가 아니다.
 *
 */
public class B19699_소난다 {
    static int N, M;
    static int[] cows;
    static int[] output;
    static Set<Integer> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cows = new int[N];
        output = new int[M];    // M마리의 소 뽑기
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(set.isEmpty()){
            System.out.println(-1);
        }else{
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            System.out.println(sb.toString());
        }
    }
    public static void dfs(int idx, int cnt){
        if(cnt == M){ // 선별할 소
            int sum = 0;
            for(int m=0; m<M; m++){
                sum += output[m];
            }
            //소수??
            if(isPrime(sum)) set.add(sum);

            return;
        }
        if(idx == N) return;

        output[cnt] = cows[idx];
        dfs(idx+1, cnt+1);    //뽑고

        dfs(idx+1, cnt);

    }
    static boolean isPrime(int num){

        for(int i=2; i<=num/2; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}