package week34;

import java.util.*;

/**
 * 단순 bfs, dfs 문제
 */
public class PRO_무인도여행 {
    int[] di = new int[]{1,-1, 0, 0};
    int[] dj = new int[]{0, 0, 1, -1};
    int N,M;
    public int[] solution(String[] maps) {
        int[] answer = {};
        N = maps.length;    // i
        M = maps[0].length();   // j

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        // map 배열 만들기
        int idx=0;
        for(String s : maps){
            map[idx++] = s.toCharArray();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 'X' && !visited[i][j]){
                    int sum = bfs(map, visited, i, j);
                    if(sum != 0) list.add(sum);
                }
            }
        }
        if(list.size() == 0) return new int[]{-1};

        //리스트 정렬
        Collections.sort(list);

        answer = new int[list.size()];
        idx=0;
        for(int num : list){
            answer[idx++] = num;
        }

        return answer;
    }
    public int bfs(char[][] map, boolean[][] visited, int starti, int startj){
        Queue<int[]> q = new LinkedList<>();

        // 시작점 넣기
        q.add(new int[]{starti, startj});
        visited[starti][startj] = true;

        int sum = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();

            //나올 때마다 식량 추가하기
            sum += (map[now[0]][now[1]] - '0');

            for(int d=0; d<4; d++){
                int nexti = now[0] + di[d];
                int nextj = now[1] + dj[d];

                if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
                if(visited[nexti][nextj] || map[nexti][nextj] == 'X') continue;

                visited[nexti][nextj] = true;   // visit
                q.add(new int[]{nexti, nextj});
            }
        }

        return sum;
    }
}
