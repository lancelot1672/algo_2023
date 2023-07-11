package week45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 71퍼 시간초과..
 * BFS의 시간 복잡도는 N 제곱이라고 함.
 */
public class B17071_숨바꼭질5 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int[] dx = new int[]{2, -1, 1};

        int step = 1;
        int dist = 0;
        // n초마다 갈 수 있는 곳을 다 정해놔야하나?
            while(!q.isEmpty()){
            K += step++;
            dist++;

            if(K > 500000){
                System.out.println(-1);
                return;
            }

            Set<Integer> set = new HashSet<>();

            int size = q.size();
            for(int s=0; s<size; s++){
                int now = q.poll();

                for(int d=0; d<3; d++){
                    int nextX = 0;
                    if(d==0){
                        nextX = now * dx[d];
                    }else{
                        nextX = now + dx[d];
                    }

                    if(nextX < 0 || nextX >= 500001) continue;

                    if(nextX == K){
                        System.out.println(dist);
                        return;
                    }
                    if(set.add(nextX)){
                        q.add(nextX);
                    }
                }
            }

        }
        // 5 18
        // 1 : 4, 6, 10 || 19
        // 2 : 3, 5, 8,   5, 7, 12,   9, 11, 20 || 21
        // 3 :

        // 18 5
        // 1 : 6  || 17, 19, 36
        // 2 : 8  || 16, 18, 34,   18, 20, 38, ...
        // 3 : 11 || 15, 17,    18, 20 ...
        // 4 : 15 || 14, 16,   16, 18     19, 20
        // 5 : 20 ||

    }
}