package week48;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1309_동물원 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][][] D = new int[2][2][N+1];
        D[0][0][0] = 1;
        D[0][1][0] = 1;
        D[1][0][0] = 1;
        D[1][1][0] = 1;

        for(int j=0; j<N; j++){
            //안뽑고 다음에도 안뽑아
            D[0][0][j+1] += D[0][0][j] % 9901;
            D[0][1][j+1] += D[0][1][j] % 9901;;

            //안뽑고 다음에는 뽑아
            D[1][0][j+1] += D[0][0][j] % 9901;;
            D[1][1][j+1] += D[0][1][j] % 9901;;
            D[1][1][j+1] += D[0][0][j] % 9901;;
            D[1][0][j+1] += D[0][1][j] % 9901;;

            //뽑고 다음에도 뽑아
            D[1][0][j+1] += D[1][1][j] % 9901;;
            D[1][1][j+1] += D[1][0][j] % 9901;;

            //뽑고 다음에는 안뽑아
            D[0][0][j+1] += D[1][1][j] % 9901;
            D[0][1][j+1] += D[1][0][j] % 9901;
        }

        System.out.println(D[1][1][N] % 9901);
    }
}
