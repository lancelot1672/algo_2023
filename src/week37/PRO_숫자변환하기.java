package week37;
import java.util.*;

public class PRO_숫자변환하기 {
    int[] memo;
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) return answer;

        memo = new int[y+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()){
            int now = q.poll();

            if(now + n <= y && memo[now + n] > memo[now] + 1){
                memo[now + n] = memo[now] + 1;
                q.add(now + n);
            }
            if(now * 2 <= y && memo[now * 2] > memo[now] + 1){
                memo[now * 2] = memo[now] + 1;
                q.add(now * 2);
            }
            if(now * 3 <= y && memo[now * 3] > memo[now] + 1){
                memo[now * 3] = memo[now] + 1;
                q.add(now * 3);
            }
        }
        if(memo[y] == Integer.MAX_VALUE) return -1;
        answer = memo[y];
        return answer;
    }
//    public void dfs(int x, int y, int n, int cnt){
//        if(x == y){ // 다 왔다!
//            return;
//        }
//
//        if(x + n <= y && memo[x + n] >= cnt+1){
//            memo[x + n] = cnt+1;
//            dfs(x+n, y, n, cnt+1);
//        }
//        if(x * 2 <= y && memo[x * 2] >= cnt+1){
//            memo[x * 2] = cnt+1;
//            dfs(x * 2, y, n, cnt+1);
//        }
//        if(x * 3 <= y && memo[x * 3] >= cnt+1){
//            memo[x * 3] = cnt+1;
//            dfs(x * 3, y, n, cnt+1);
//        }
//    }
}
