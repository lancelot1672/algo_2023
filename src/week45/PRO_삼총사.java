package week45;

/**
 * Time : 8m
 * Category : BackTracking
 */
public class PRO_삼총사 {
    int answer;
    public int solution(int[] number) {
        answer = 0;

        dfs(0, 0, number, 0);

        return answer;
    }
    public void dfs(int cnt, int idx, int[] number, int sum){
        if(cnt == 3 && sum == 0){
            answer++;
            return;
        }
        if(idx == number.length) return;

        dfs(cnt, idx+1, number, sum);
        dfs(cnt+1, idx+1, number, sum + number[idx]);

    }
}
