package week41;

public class PRO_덧칠하기 {
    /*
        앞에서 부터 칠하면 될 것 같음
        앞에서부터 정해진 만큼 칠하고 칠해야 하는 부분은 true처리 해준다면
        남는 곳을 다 칠했을 때 횟수가 제일 최소 횟수
    */
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int idx = 0;
        boolean[] visited = new boolean[n+1];
        for(int i=section[0]; i<=n; i++){
            if(i == section[idx] && !visited[i]){
                for(int j=0; j<m; j++){ // m만큼 칠하기
                    visited[i + j] = true;
                    if(i + j == section[idx]) idx++;
                    if(idx == section.length) break;
                }
                answer++;   //한번 페인트칠
                i+= m-1;
                if(idx == section.length) break;
            }
        }
        return answer;
    }
}
