package week37;

public class PRO_바탕화면정리 {
    int N, M;
    char[][] map;
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        N = wallpaper.length;
        M = wallpaper[0].length();

        map = new char[N][];
        for(int i=0; i<N; i++){
            map[i] = wallpaper[i].toCharArray();
        }
        int minj = -1;
        int maxj = -1;
        int mini = -1;
        int maxi = -1;
        //최소 j, 최대 j 구하기
        for(int j=0; j<M; j++){
            for(int i=0; i<N; i++){
                if(map[i][j] == '#'){
                    if(minj == -1){// 한번만
                        minj = j;
                    }
                    maxj = j+1;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == '#'){
                    if(mini == -1){// 한번만
                        mini = i;
                    }
                    maxi = i+1;
                }
            }
        }
        answer = new int[]{mini, minj, maxi, maxj};
        return answer;
    }
}
