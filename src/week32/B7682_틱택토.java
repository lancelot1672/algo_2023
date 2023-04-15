package week32;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B7682_틱택토 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            char[][] map = new char[3][];

            map[0] = input.substring(0, 3).toCharArray();
            map[1] = input.substring(3, 6).toCharArray();
            map[2] = input.substring(6, 9).toCharArray();

            int[] presentCnt = getPresentCnt(map);
            if(presentCnt[0] == 0){
                // end game
                if(presentCnt[1] == 5 && presentCnt[2] == 4) sb.append("valid\n");
                else sb.append("invalid\n");
            }else{
                //빈칸을 제외한 X,0의 갯수
                // 같거나 X갯수 -1 == O의 갯수
                if(presentCnt[1] == presentCnt[2] || presentCnt[1]-1 == presentCnt[2]){
                    // 결과가 나온 것들만 ㅇㅋ
                    boolean checkX = checkResult(map, 'X');
                    boolean checkO = checkResult(map, 'O');

                    // 둘다 같이 끝날 수 없음, 둘다 안끝나도 안됌.
                    if((checkO && checkX) || (!checkO && !checkX)){
                        sb.append("invalid\n");
                        continue;
                    }

                    if(checkX){  // X가 끝났을 때는
                        if(presentCnt[1] -1 == presentCnt[2])
                            sb.append("valid\n");
                        else
                            sb.append("invalid\n");
                    }else if(checkO){
                        //O가 끝났을 때는 두개가 같아야 함.
                        if(presentCnt[1] == presentCnt[2])
                            sb.append("valid\n");
                        else
                            sb.append("invalid\n");
                    }
                }else{
                    sb.append("invalid\n");
                }
            }
        }// end while
        System.out.println(sb.toString());
    }
    public static int[] getPresentCnt(char[][] map){
        int[] result = new int[3];
        // 0 : empty
        // 1 : X
        // 2 : O

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(map[i][j] == '.'){
                    result[0]++;
                }else if(map[i][j] == 'X'){
                    result[1]++;
                }else{
                    result[2]++;
                }
            }
        }
        return result;
    }
    static int[] di = {-1, 1, 1, 0};
    static int[] dj = {1, 0, 1, 1};
    public static boolean checkResult(char[][] map, char c ){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                for(int d=0; d<4; d++){
                    if(map[i][j] != '.' && checkLine(map, c, i, j ,d)) return true;
                }
            }
        }
        return false;
    }
    public static boolean checkLine(char[][] map, char c, int i, int j, int d){
        int nowi = i;
        int nowj = j;

        int cnt = 1;
        while(true){
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];
            //cnt == 3이면 return true;
            //범위 밖으로 나가면 false;

            if(nexti < 0 || nexti >= 3 || nextj < 0 || nextj >= 3) return false;
            if(map[nexti][nextj] == c) cnt++;

            if(cnt == 3) return true;

            nowi = nexti;
            nowj = nextj;
        }
    }
}
