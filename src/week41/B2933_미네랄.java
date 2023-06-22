package week41;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2933_미네랄 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int n=0; n<N; n++){
            map[n] = br.readLine().toCharArray();
        }

        int T = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int t=0; t<T; t++){
            int h = N - Integer.parseInt(st.nextToken());

            //Shoot left
            int[] mineral = shoot(h, 0);

            //새로운 클러스터가 생성되었는지 확인
            newCluster = true;

            //4방향 확인
            for(int d=0; d<4 ; d++){

                int nexti = mineral[0] + di[d];
                int nextj = mineral[1] + dj[d];

                if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
                if(nexti == N-1) continue;  // 바닥에 붙어있음
                if(map[nexti][nextj] != 'x') continue;

                visited = new boolean[N][M];
                dfs(nexti, nextj);

                if(newCluster){
                    ArrayList<int[]> list = new ArrayList<>();
                    //새로운 클러스터 리스트 가져오기
                    for(int i=0; i<N; i++){
                        for(int j=0; j<M; j++){
                            if(visited[i][j]) list.add(new int[]{i, j});
                        }
                    }

                    //클러스터 리스트
                    break;
                }
            }

        }
    }
    static int[] di = {0 , 0};
    static int[] dj = {1, -1};
    static int[] shoot(int h, int d){
        //해당 높이에서 L->R(d == 0) R->L(d == 1) 슈팅
        int nowi = h;
        int nowj = (d == 0) ? 0 : M-1;

        while(true){
            if(map[nowi][nowj] == 'x') {
                map[nowi][nowj] = '.';
                return new int[]{nowi, nowj};
            }

            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nextj < 0 || nextj >= M) return null;

            nowi = nexti;
            nowj = nextj;
        }
    }
    static boolean newCluster;
    static void dfs(int nowi , int nowj){
        if(nowi == N-1 && map[nowi][nowj] == 'x'){
            newCluster = false; // 바닥에 붙어 있으면 new x
            return;
        }

        for(int d=0; d<4; d++){
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
            if(visited[nexti][nextj]) continue;

            visited[nexti][nextj] = true;
            dfs(nexti, nextj);
        }
    }
}
