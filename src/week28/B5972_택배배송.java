package week28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  최소 비용 알고리즘
 *
 * */
public class B5972_택배배송 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프
        ArrayList<Point>[] adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Point(to, weight));
            adjList[to].add(new Point(from, weight));
        }

        int[] D = new int[N+1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[1] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2)-> p1.weight - p2.weight);
        pq.add(new Point(1,0));

        while(!pq.isEmpty()){
            Point now = pq.poll();

            if(now.to == N) break;

            for(Point next : adjList[now.to]){
                if(D[next.to] > D[now.to] + next.weight){
                    D[next.to] = D[now.to] + next.weight;
                    pq.add(new Point(next.to, D[next.to]));
                }
            }
        }
        System.out.println(D[N]);
    }
    static class Point {
        int to;
        int weight;

        public Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
