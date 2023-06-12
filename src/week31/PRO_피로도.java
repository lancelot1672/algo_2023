package week31;

public class PRO_피로도 {
    boolean[] visited;
    int max;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        max = 0;

        dfs(dungeons, k, 0);
        answer = max;
        return answer;
    }
    public void dfs(int[][] dungeons, int k, int cnt){
        for(int i=0; i<dungeons.length; i++){   // 갈 수 있는 곳 가
            if(dungeons[i][0] <= k && !visited[i]){ // 최소 피로도보다 높아?
                visited[i] = true;
                dfs(dungeons, k-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
        max = Math.max(max, cnt);
    }
}
