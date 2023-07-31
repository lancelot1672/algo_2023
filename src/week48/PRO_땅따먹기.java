package week48;

public class PRO_땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;

        int[][] D = new int[land.length+1][4];

        for(int i=0; i<land.length; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    int t = (k+1) % 4;
                    if(j == t) continue;
                    if(D[i+1][j] < land[i][t] + D[i][t])
                        D[i+1][j] = land[i][t] + D[i][t];
                }
            }
        }
        for(int i=0; i<4; i++){
            answer = Math.max(D[land.length][i], answer);
        }
        return answer;
    }
}
