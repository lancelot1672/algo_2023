package week39;
import java.util.*;
import java.io.*;

public class B2075_N번째큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        int answer = 0;
        for(int i=0; i<N; i++){
            answer = pq.poll();
        }
        System.out.println(answer);
    }
}