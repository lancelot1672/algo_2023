package week50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_퍼즐조각채우기 {
    int N;
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        N = game_board.length;

        //도형 리스트를 구하자
        boolean[][] visited = new boolean[N][N];
        ArrayList<int[][]> figureList = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && table[i][j] != 0)
                    figureList.add(bfs(table, visited, new int[]{i, j}, 0));
            }
        }
        //game_board에 빈곳
        visited = new boolean[N][N];
        ArrayList<int[][]> boardFigureList = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && game_board[i][j] != 1)
                    boardFigureList.add(bfs(game_board, visited, new int[]{i, j}, 1));
            }
        }

        boolean[] used = new boolean[figureList.size()];
        //두개 비교해가면서 넣기
        for(int i=0; i<boardFigureList.size(); i++){
            int[][] bf = boardFigureList.get(i);
            int iSize = bf.length;
            int jSize = bf[0].length;

            for(int j=0; j<figureList.size(); j++){
                if(used[j]) continue;
                int[][] figure = figureList.get(j);
                //같은 사이즈 확인
                if((iSize == figure.length && jSize == figure[0].length) || (jSize == figure.length && iSize == figure[0].length)){
                    // System.out.println("iSize : " + iSize);
                    // System.out.println("jSize : " + jSize);
                    // System.out.println("figure.length : " + figure.length);
                    // System.out.println("figure[0].length : " + figure[0].length);

                    //4방향으로 돌려가면서 체크
                    for(int d=0; d<4; d++){
                        int[][] copy = rotateFigure(figure);

                        // System.out.println("같나 체크");
                        // print(bf);
                        // print(copy);
                        // 돌렸을 때 iSize jSize 맞는 것만
                        if(iSize == copy.length && jSize == copy[0].length){
                            // System.out.println("copy.length : " + copy.length);
                            // System.out.println("copy[0].length : " + copy[0].length);
                            int cnt = check(bf, copy);
                            if(cnt == -1){
                                figure = copy;
                                continue;
                            }
                            // System.out.println("같음");
                            // System.out.println(cnt);
                            draw(bf);
                            used[j] = true;
                            answer += cnt;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
    public int check(int[][] game_board, int[][] figure){
        int cnt = 0;
        for(int i=0; i<game_board.length; i++){
            for(int j=0; j<game_board[0].length; j++){
                if(game_board[i][j] == figure[i][j]) return -1; //안맞음
                if(figure[i][j] == 1) cnt++;

            }
        }
        return cnt;
    }
    public void draw(int[][] figure){
        for(int i=0; i<figure.length; i++){
            for(int j=0; j<figure[0].length; j++){
                if(figure[i][j] == 0) figure[i][j] = 1;
            }
        }
    }
    public int[][] rotateFigure(int[][] origin){
        // i : origin[0].length = 2
        // j : origin.length = 3
        int[][] copy = new int[origin[0].length][origin.length];

        for(int j=0; j<origin[0].length; j++){
            for(int i=0; i<origin.length; i++){
                copy[j][origin.length - (i+1)] = origin[i][j];
            }
        }
        return copy;

    }

    int[] di = new int[]{0, 0, -1, 1};  // L R U D
    int[] dj = new int[]{-1, 1, 0, 0};
    //도형 리스트를 구하자
    public int[][] bfs(int[][] table, boolean[][] visited, int[] start, int check){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        //up_i
        //down_i
        //left_j
        //right_j
        int left = start[1];
        int right = start[1];
        int up = start[0];
        int down = start[0];


        while(!q.isEmpty()){
            int[] now = q.poll();
            left = Math.min(left, now[1]);
            right = Math.max(right, now[1] );
            down = Math.max(down, now[0]);
            for(int d=0; d<4; d++){
                int nexti = now[0] + di[d];
                int nextj = now[1] + dj[d];

                if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) continue;
                if(visited[nexti][nextj]) continue;
                if(table[nexti][nextj] == check) continue;

                visited[nexti][nextj] = true;
                q.add(new int[]{nexti, nextj});
            }
        }
        int[] dict = new int[4];
        dict[0] = left;
        dict[1] = right;
        dict[2] = up;
        dict[3] = down;
        System.out.println(Arrays.toString(dict));

        // 여기서 뻗은 만큼 도형을 떼어내야 함.
        int[][] figure = getFigure(table, dict, start[0], start[1]);
        print(figure);
        return figure;
    }
    // L R U D
    // 0 1 2 3
    public int[][] getFigure(int[][] table, int[] dict, int starti, int startj){
        int[][] figure = new int[1 + dict[3] - dict[2]][1 + dict[1] - dict[0]];
        // int a = 0;
        // int b = 0;
        // for(int i=starti; i<=starti + dict[3]; i++){
        //     for(int j=startj - dict[0]; j<=startj + dict[1]; j++){
        //         figure[a][(b++) % (1 + dict[0] + dict[1])] = table[i][j];
        //     }
        //     a++;
        // }

        for(int i=0; i<=dict[3] - dict[2]; i++){
            for(int j=0; j<=dict[1] - dict[0]; j++){
                figure[i][j] = table[dict[2] + i][dict[0] + j];
            }
        }
        return figure;
    }
    public void print(int[][] array){
        System.out.println();
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
