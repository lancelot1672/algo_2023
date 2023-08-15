package week50;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PRO_등산코스정하기 {
    ArrayList<Point>[] adjList;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        adjList = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<Point>();
        }
        for(int[] path : paths){
            int from = path[0];
            int to = path[1];
            int w = path[2];

            adjList[from].add(new Point(to, w));
            adjList[to].add(new Point(from, w));
        }
        //
        char[] map = new char[n+1];
        for(int gate : gates){
            map[gate] = 'G';
        }
        for(int summit : summits){
            map[summit] = 'S';
        }

        return answer;
    }
    public void func(int[] gates, int n) {
        for (int gate : gates) {
            //PQ이용 - 가중치 제일 작은 것부터
            PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.w - p2.w);
            boolean[] visited = new boolean[n + 1];
            pq.add(new Point(gate, 0));
            visited[gate] = true;

            while (!pq.isEmpty()) {
                Point now = pq.poll();
                // if(now.to == )

                for (Point next : adjList[now.to]) {
                    if (visited[next.to]) continue;

                    next.max = Math.max(next.max, next.w);
                }
            }

        }

    }
}
class Point{
    int to;
    int w;
    int max = 0;
    public Point(int to, int w){
        this.to = to;
        this.w = w;
    }
}

