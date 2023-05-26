package week37;
import java.util.Arrays;

public class PRO_숫자변환하기 {
    int[] memo;
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) return answer;

        memo = new int[y+1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        if(memo[y] == Integer.MAX_VALUE){
            return -1;
        }
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
