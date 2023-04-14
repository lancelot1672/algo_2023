package week30;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_KAKAO1차_프랜즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        int a = 5;
        while(true){
            Queue<int[]> q = getStandPoint(map, m, n);
            if(q.isEmpty()) break;
            System.out.println(q.size());

            eraseMap(q, map, m, n);
            redrawMap(map,m,n);

            print(map, m, n);
        }

        return getCount(map, m, n);
    }
    public void redrawMap(char[][] map, int m, int n){
        for(int j=0; j<n; j++){
            int zeroCnt = 0;
            for(int i=m-1; i>=0; i--){
                if(zeroCnt != 0 && map[i][j] != ' '){
                    map[i + zeroCnt][j] = map[i][j];
                    map[i][j] = ' ';
                }
                else if(map[i][j] == ' ') zeroCnt++;
            }
        }
    }
    public void print(char[][] map, int m, int n){
        System.out.println();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public int getCount(char[][] map, int m, int n){
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == ' ') count++;
            }
        }
        return count;
    }
    public void eraseMap(Queue<int[]> q, char[][] map, int m, int n){
        while(!q.isEmpty()){
            int[] now = q.poll();

            map[now[0]][now[1]] = ' ';
            map[now[0]+1][now[1]] = ' ';
            map[now[0]][now[1]+1] = ' ';
            map[now[0]+1][now[1]+1] = ' ';
        }
    }
    public Queue<int[]> getStandPoint(char[][] map, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                char stand = map[i][j];
                if(stand == ' ') continue;
                if(stand == map[i+1][j] && stand == map[i][j+1] && stand == map[i+1][j+1])
                    q.add(new int[]{i,j});
            }
        }

        return q;
    }
}
