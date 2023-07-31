package week47;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13459_구슬탈출  {
    static int N, M;
    static boolean answer;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        Ball Red = null;
        Ball Blue = null;
        for(int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = arr[j];
                if(map[i][j] == 'R'){
                    Red = new Ball(i, j);
                }else if(map[i][j] == 'B'){
                    Blue = new Ball(i, j);
                }
            }
        }//end input
        answer = false;

        dfs(0, Red, Blue);

        System.out.println(answer ? "1" : "0");
    }
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static void dfs(int depth, Ball red, Ball blue){
        if(depth == 10){
            return;
        }
        // Red, Blue 한 방향씩 돌리기
        // 얼마나 갔는지, 굴러갔을 때 위치가 같다면 작은
        for(int d=0; d<4; d++){
            int[] redInfo = rotate(red, d);
            int[] blueInfo = rotate(blue, d);

            if(blueInfo == null){
                continue;
            }
            if(redInfo == null){
                answer = true;
                return;
            }
            Ball nextRed = new Ball(red.i + di[d] * redInfo[2], red.j + dj[d] * redInfo[2]);
            Ball nextBlue = new Ball(blue.i + di[d] * blueInfo[2], blue.j + dj[d] * blueInfo[2]);

            // 두 구슬 위치가 같을 때 ....?
            map[red.i][red.j] = '.';
            map[blue.i][blue.j] = '.';
            map[nextRed.i][nextRed.j] = 'R';
            map[nextBlue.i][nextBlue.j] = 'B';

            dfs(depth+1, nextRed, nextBlue);


            map[nextRed.i][nextRed.j] = '.';
            map[nextBlue.i][nextBlue.j] = '.';
            map[red.i][red.j] = 'R';
            map[blue.i][blue.j] = 'B';
        }
    }
    static void print(){
        System.out.println("======================");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[] rotate(Ball start, int d){
        // 경로에 있는 . 갯수 세기

        int nowi = start.i;
        int nowj = start.j;
        int cnt = 0;
        while(true){
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(map[nexti][nextj] == '.') {
                cnt++;
            }
            if(map[nexti][nextj] == '#') break;
            if(map[nexti][nextj] == 'O') return null;

            nowi = nexti;
            nowj = nextj;
        }

        int[] info = new int[3];
        info[0] = nowi;
        info[1] = nowj;
        info[2] = cnt;

        return info;
    }
    static class Ball {
        int i;
        int j;
        public Ball(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}