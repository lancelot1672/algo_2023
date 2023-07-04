package week44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18430_무기공학 {
    static int N, M;
    static int[][] map;
    static int[][] di = {{0, +1}, {-1, 0}, {-1, 0}, {0, +1}};
    static int[][] dj = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static int max;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        max = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int total){
        //
        max = Math.max(max, total);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]) continue;
                for(int d=0; d<4; d++){
                    int di1 = i + di[d][0];
                    int dj1 = j + dj[d][0];

                    int di2 = i + di[d][1];
                    int dj2 = j + dj[d][1];

                    if(di1 < 0 || di1 >= N || dj1 < 0 || dj1 >= M) continue;
                    if(di2 < 0 || di2 >= N || dj2 < 0 || dj2 >= M) continue;

                    //visited 체크
                    if(visited[di1][dj1] || visited[di2][dj2]) continue;

                    visited[i][j] = true;
                    visited[di1][dj1] = true;
                    visited[di2][dj2] = true;

                    int sum = map[i][j] * 2 + map[di1][dj1] + map[di2][dj2];
                    dfs(total + sum);

                    visited[i][j] = false;
                    visited[di1][dj1] = false;
                    visited[di2][dj2] = false;
                }
            }
        }
    }
}
