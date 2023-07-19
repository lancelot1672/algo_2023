package week46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Time : 18m
 * Category : 그래프
 *
 */
public class B5567_결혼식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adjList = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            adjList[n] = new ArrayList<Integer>();
        }

        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            adjList[to].add(from);
            adjList[from].add(to);

        }

        boolean[] visited = new boolean[N+1];
        visited[1] = true;    //상근이~

        Queue<Integer> q = new LinkedList<>();
        q.add(1);    // 상근이~~

        int answer = 0;    // 하객 수
        int depth = 0;
        while(!q.isEmpty() && depth < 2){
            int size = q.size();
            for(int s=0; s<size; s++){
                int now = q.poll();

                for(int next : adjList[now]){    // now의 친구
                    if(visited[next]) continue;

                    visited[next] = true;
                    answer++;    // 하객 수 + 1
                    q.add(next);
                }
            }
            depth++;
        }
        System.out.println(answer);
    }
}