package week27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234_인구이동 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        //L 이상, R 이하
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, -1, 1};

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//end Input
        int cycle = 0;
        while(true){
            boolean flag = false;
            int index = 1;  // index
            int[][] visited = new int[N][N];    // 방문체크 배열
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] != 0) continue;    //이미 연합 결성

                    Queue<int[]> q = new LinkedList<>();
                    ArrayList<int[]> list = new ArrayList<>();

                    q.add(new int[]{i, j});
                    visited[i][j] = index;

                    int union = 1;  // 연합 나라 수
                    int population = map[i][j]; //인구

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        list.add(now);

                        for(int d=0; d<4; d++){
                            int nexti = now[0] + di[d];
                            int nextj = now[1] + dj[d];

                            if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) continue;
                            if(visited[nexti][nextj] != 0) continue;
                            int abs = Math.abs(map[nexti][nextj] - map[now[0]][now[1]]);
                            if(abs < L || abs > R) continue;

                            flag = true;    //인구 이동이 일어나네~
                            union++;    // 연합을 이루고 있는 칸의 개수 증가
                            population += map[nexti][nextj]; // 연합의 인구 수
                            q.add(new int[]{nexti, nextj});
                            visited[nexti][nextj] = index;
                        }
                    }// 연합 했슈
                    if(list.size() > 1){    // 연합 나라 2개 이상
                        for (int[] c : list) {
                            map[c[0]][c[1]] = population / union;
                        }
                        index++;
                    }
                }//end for j
            }//end for i
            if(!flag) break;
            cycle++;
        }
        System.out.println(cycle);
    }
}
