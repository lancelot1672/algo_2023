package week31;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] number;
    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];
        for(int i=0; i<N; i++){
            number[i] = i+1;
        }
        result = new int[M];    // M개 뽑아

        perm(0);
    }
    static void perm(int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                System.out.print(result[cnt] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            result[cnt] = number[i];
            perm(cnt+1);
        }
    }
}