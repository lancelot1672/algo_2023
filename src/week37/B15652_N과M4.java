package week37;

import java.util.*;
import java.io.*;

public class B15652_N과M4{
    static int N, M;
    static int[] output;
    static boolean[][] visited;
    static StringBuilder sb;
    /*
        중복순열
    */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];    // M개를 뽑는다.
        sb = new StringBuilder();

        dfs(1, 0);

        System.out.println(sb.toString());
    }
    public static void dfs(int idx, int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=idx; i<=N; i++){
            output[cnt] = i;
            dfs(i, cnt+1);
        }
    }
}