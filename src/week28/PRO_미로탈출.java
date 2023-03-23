package week28;
import java.util.*;

public class PRO_미로탈출 {
    public int solution(String[] maps) {
        int answer = -1;
        int[] start = new int[2];
        int[] levor = new int[2];
        int[] end = new int[2];
        int N = maps.length;
        int M = maps[0].length();
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = maps[i].toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j] == 'S'){   // 시작점
                    start = new int[]{i, j};
                }else if(map[i][j] == 'L'){   // 레버
                    levor = new int[]{i, j};
                }else if(map[i][j] == 'E'){    // 출구
                    end = new int[]{i, j};
                }
            }
        }
        int time1 = bfs(map, start, levor, N, M);
        int time2 = bfs(map, levor, end, N, M);

        if(time1 != -1 && time2 != -1){
            answer = time1 + time2;
        }
        return answer;
    }
    public int bfs(char[][] map, int[] start, int[] end, int N, int M){
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, -1 ,1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // 시작점 체크
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int s=0; s<size; s++){
                int[] now = q.poll();

                if(now[0] == end[0] && now[1] == end[1]){
                    return time;
                }
                for(int d=0; d<4; d++){
                    int nexti = now[0] + di[d];
                    int nextj = now[1] + dj[d];

                    if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
                    if(visited[nexti][nextj]) continue;
                    if(map[nexti][nextj] == 'X') continue;

                    q.add(new int[]{nexti, nextj});
                    visited[nexti][nextj] = true;
                }

            }//end s
            time++;
        }
        return -1;
    }
}