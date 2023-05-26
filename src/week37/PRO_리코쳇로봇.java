package week37;
import java.util.*;
public class PRO_리코쳇로봇 {
    int N, M;
    char[][] map;
    int[][] visited;
    int min;
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        visited = new int[N][M];
        min = Integer.MAX_VALUE;

        int[] start = new int[2];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    start = new int[]{i, j};
                    visited[i][j] = 1;
                }
            }
        }

        bfs(start);
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        return min;
    }
    int[] di = new int[]{1, -1, 0, 0};
    int[] dj = new int[]{0, 0, -1, 1};

    public void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = 1;

        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == 'G'){
                    min = Math.min(min, dist);
                    return;
                }
                for(int d=0; d<4; d++){
                    //가고
                    int[] next = forward(now, d);
                    if(next != null){
                        visited[next[0]][next[1]] = 1;
                        q.add(next);
                    }
                }
            }//end for
            dist++;

        }

    }
    public int[] forward(int[] start, int d){

        int starti = start[0];
        int startj = start[1];

        while(true){
            int nexti = starti + di[d];
            int nextj = startj + dj[d];

            if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) break;
            if(map[nexti][nextj] == 'D') break;

            starti = nexti;
            startj = nextj;
        }
        // D 앞에 멈췄을 때,
        if(visited[starti][startj] == 1){    //이미 한번 와봤으면 안갈래
            return null;
        }


        return new int[]{starti, startj};
    }
    public void print(){
        System.out.println();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
