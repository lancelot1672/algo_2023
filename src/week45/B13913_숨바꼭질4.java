package week45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Time : 30m
 * Category : BFS, Thinking?
 * 문자열 연산해서 경로 구하는 방식으로 해결
 * 최적화를 위해 어떤 작업이 있을 듯 한데..
 */
public class B13913_숨바꼭질4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(start > K){
            StringBuilder sb = new StringBuilder();
            for(int i = start; i >= K; i--){
                sb.append(i + " ");
            }
            System.out.println(start - K);
            System.out.println(sb.toString());
            return;
        }
        boolean[] visited = new boolean[100001];
        Queue<Subin> q = new LinkedList<>();

        //start 위치
        q.add(new Subin(start, start + " "));
        visited[start] = true;

        int[] dx = new int[]{2, -1, 1};
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++){
                Subin now = q.poll();
                int location = now.location;
                String step = now.step;

                if(location == K){
                    System.out.println(dist);
                    System.out.println(step);
                    return;
                }
                for(int d=0; d<3; d++){
                    int nextX = 0;
                    if(d == 0){
                        nextX = location * dx[d];
                    }else{
                        nextX = location + dx[d];
                    }

                    if(nextX < 0 || nextX >= 100001) continue;
                    if(visited[nextX]) continue;

                    visited[nextX] = true;
                    q.add(new Subin(nextX, step + nextX + " "));
                }
            }
            dist++;
        }
    }

}
class Subin {
    int location;
    String step;
    public Subin(int location, String step){
        this.location = location;
        this.step = step;
    }
}