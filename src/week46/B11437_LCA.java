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
        int[] before = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : adjList[now]){
                if(visited[next]) continue;

                before[next] = now;
                visited[next] = true;
                q.add(next);
            }
        }

        //자기 자신부터 1까지의 depth를 구하면서

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());


            ArrayList<Integer> listA = bfs(before, to);
            ArrayList<Integer> listB = bfs(before, from);
//            System.out.println("시작~");
//            System.out.println(listA.toString());
//            System.out.println(listB.toString());
            sb.append(getAnswer(listA, listB)).append("\n");
        }
        System.out.println(sb);
    }
    static int getAnswer(ArrayList<Integer> listA, ArrayList<Integer> listB){
        for(int a : listA){
            for(int b : listB){
                if(a == b) return a;
            }
        }
        return 1;
    }
    static ArrayList<Integer> bfs(int[] before, int start){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.add(start);
        visited[start] = true;
        ArrayList<Integer> list = new ArrayList<>();    // 내 위에 있는 녀석들
        while(!q.isEmpty()){
            int now = q.poll();
            list.add(now);

            int up = before[now];
            if(visited[up]) continue;

            visited[up] = true;
            q.add(up);



        }

        return list;
    }
}