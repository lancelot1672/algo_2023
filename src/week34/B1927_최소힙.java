package week34;
import java.util.*;
import java.io.*;
public class B1927_최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()) sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
                continue;
            }
            pq.add(num);
        }
        System.out.println(sb.toString());
    }
}