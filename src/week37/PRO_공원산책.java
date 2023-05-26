package week37;
import java.util.*;
public class PRO_공원산책 {
    char[][] map;
    int N, M;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        N = park.length;
        M = park[0].length();
        int[] now = new int[2];

        map = new char[N][M];
        for(int i=0; i<N; i++){
            String line = park[i];
            for(int j=0; j<M; j++){
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == 'S'){
                    now = new int[]{i, j};
                }
            }
        }

        for(String route : routes){
            StringTokenizer st = new StringTokenizer(route);
            char direction = st.nextToken().charAt(0);
            int step = Integer.parseInt(st.nextToken());

            //돌려보기
            now = order(now, direction, step);
        }
        return now;
    }
    int[] di = new int[]{1, -1, 0, 0};
    int[] dj = new int[]{0, 0, -1, 1};
    public int[] order(int[] now, char direction, int step){
        switch(direction){
            case 'E':
                if(forward(now, 3, step)){
                    now[0] += di[3] * step;
                    now[1] += dj[3] * step;
                }
                return now;
            case 'W':
                if(forward(now, 2, step)){
                    now[0] += di[2] * step;
                    now[1] += dj[2] * step;
                }
                return now;
            case 'S':
                if(forward(now, 0, step)){
                    now[0] += di[0] * step;
                    now[1] += dj[0] * step;
                }
                return now;
            case 'N':
                if(forward(now, 1, step)){
                    now[0] += di[1] * step;
                    now[1] += dj[1] * step;
                }
                return now;
        }

        return now;
    }
    public boolean forward(int[] now, int d, int step){
        for(int s=1; s<=step; s++){
            int nexti = now[0] + di[d] * s;
            int nextj = now[1] + dj[d] * s;

            if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) return false;
            if(map[nexti][nextj] == 'X') return false;
        }

        return true;
    }
}
