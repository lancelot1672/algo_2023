package week46;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 93퍼 시간초과 빡세다..
 */
public class B11437_LCA {
    static int N;
    static ArrayList<Integer>[] adjList;
    static int[] before;
    static int[] depth;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            adjList[n] = new ArrayList<Integer>();
        }
        for(int n=0; n<N-1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);

        }
        // 그 전 노드만 기억
        before = new int[N+1];
        depth = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.add(1);
        visited[1] = true;

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++) {
                int now = q.poll();
                depth[now] = dist;  // 노드 레벨 저장

                for(int next : adjList[now]){
                    if(visited[next]) continue;

                    before[next] = now;    // 부모 노드 저장

                    visited[next] = true;
                    q.add(next);
                }
            }
            dist++;
        }

        //자기 자신부터 1까지의 depth를 구하면서

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            System.out.println("to = " + to);
            System.out.println("depth[to] = " + depth[to]);
            System.out.println("from = " + from);
            System.out.println("depth[from] = " + depth[from]);
            // 둘 중 더 깊이가 깊은 것을 작은 것과 맞추기
            int lcaNum = lca(to, depth[to], from, depth[from]);
            sb.append(lcaNum).append("\n");
        }
        System.out.println(sb);
    }
    static int lca(int a, int aDepth, int b, int bDepth){
        if(a > b){
            while(aDepth > bDepth){
                aDepth--;
                a = before[a];
            }
        }else if(a < b){
            while (bDepth > aDepth){
                bDepth--;
                b = before[b];
            }
        }
        // a == b
        while(a != b){
            a = before[a];
            b = before[b];
        }
        // a == b 가 되는 순간 끝나기 때문에 a 리턴 == b 리턴
        return a;
    }

}