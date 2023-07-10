package week45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Time : 22m
 * Category : BackTracking
 * Description
 * 살짝 비효율??
 */
public class B15663_N과M9 {
    static int N;
    static int M;
    static Integer[] arr;
    static HashSet<String> set;
    static StringBuilder result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 사전 순 정렬
        Arrays.sort(arr, (n1, n2) -> {return n1-n2; });

        selected = new boolean[N];
        output = new int[M];    // M개 선택
        set = new HashSet<>();  // 중복 체크
        result = new StringBuilder();   // 결과용

        dfs(0);

        System.out.println(result.toString());

    }
    static boolean[] selected;
    static int[] output;
    static void dfs(int cnt){
        if(cnt == M){    // M개를 뽑았을 때
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<M; i++){
                sb.append(output[i] + " ");
            }

            if(set.add(sb.toString())){ // set.add => true 이면 처음 들어가는 것
                result.append(sb + "\n");
            }
            return;
        }

        for(int i=0; i<N; i++){
            if(selected[i]) continue;

            selected[i] = true;
            output[cnt] = arr[i];

            dfs(cnt+1);
            selected[i] = false;
        }
    }
}
