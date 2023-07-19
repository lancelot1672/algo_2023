package week46;
import java.util.*;
/**
 * Time : 40m
 * Category : BFS
 * Description
 * 2021 카카오 채용연계형 인턴쉽
 */
public class PRO_거리두기확인하기 {
    int N = 5;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx=0;
        for(String[] place : places){
            answer[idx++] = check(place);
        }
        return answer;
    }
    int[] di = new int[]{1, -1, 0, 0};
    int[] dj = new int[]{0, 0, -1, 1};
    public int check(String[] place){
        //각 place 마다 실행
        char[][] map = new char[N][N];

        int idx=0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String s = place[i];
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'P') list.add(new int[]{i, j});
            }
        }
        for(int[] p : list){
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> q = new LinkedList<>();
            q.add(p);
            visited[p[0]][p[1]] = true;
            int dist = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int s=0; s<size; s++){
                    int[] now = q.poll();
                    if(map[now[0]][now[1]] == 'P' && (dist > 0 && dist <= 2)) return 0;

                    for(int d=0; d<4; d++){
                        int nexti = now[0] + di[d];
                        int nextj = now[1] + dj[d];

                        if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) continue;
                        if(visited[nexti][nextj]) continue;
                        if(map[nexti][nextj] == 'X') continue;

                        visited[nexti][nextj] = true;
                        q.add(new int[]{nexti,nextj});
                    }
                }
                dist++;
            }

        }


        return 1;
    }
}
