package week45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * Time : 22m
 * Category : BackTracking
 * Description
 * 마지막에 output을 결정할 for문을 따로 돌지 않고
 * 재귀의 인자로 문자열 연산을 사용해서 넘긴다.
 */
public class B15664_N과M10 {
    static int N, M;
    static Integer[] arr;
    static Set<String> set;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        set = new HashSet<>();
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        dfs(0, 0, "");

        System.out.println(sb);
    }
    static void dfs(int idx, int cnt, String output){
        if(cnt == M){
            if(set.add(output)) sb.append(output + "\n");
            return;
        }
        if(idx == N) return;

        dfs(idx+1, cnt+1, output + arr[idx] + " ");
        dfs(idx+1, cnt, output);
    }
}
