package week40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 20m
 * 딴짓하면서 풀었음...
 * 전형적인 순열 문제
 */
public class B5568_카드놓기 {
    static int[] cards;
    static boolean[] selected;
    static int[] output;
    static int N, K;
    static Set<String> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // n개 줄에는 카드가 적혀있는 수
        cards = new int[N];
        selected = new boolean[N];

        for(int n=0; n<N; n++){
            cards[n] = Integer.parseInt(br.readLine());
        }

        //k개를 선택해서 만들 수 있는 정수의 수
        output = new int[K];
        set = new HashSet<>();

        //순서를 보장하니 순열
        dfs(0);

        System.out.println(set.size());
    }
    static void dfs(int cnt){
        if(cnt == K){
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<K; k++){
                sb.append(output[k]);
            }

            set.add(sb.toString());
            return;
        }

        for(int i=0; i<N; i++){
            if(!selected[i]){

                selected[i] = true;
                output[cnt] = cards[i];
                dfs(cnt+1);
                selected[i] = false;
            }
        }
    }
}