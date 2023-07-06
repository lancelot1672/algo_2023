package week44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Time : 57m
 * Category : Implement
 * Description
 * 배열 돌리기와 유사한 문제
 * 시키는대로 하되, 붙일 수 있는지 없는지 검사 후
 * 붙일 수 있다면 붙인다.
 */
public class B18808_스티커붙이기 {
    static int N, M, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int k=0; k<K; k++){    // 스티커 정보
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[n][m];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int rotateCnt = 0;
            while(rotateCnt < 4){
                int[] stickLocation = canStick(map, sticker);

                if(stickLocation == null){
                    //붙일 수 있는 위치가 없다면 90도 회전
                    sticker = rotateArray(sticker);
                    rotateCnt++;
                    continue;
                }
                //붙일 수 있다면 붙이기
                doStick(map, sticker, stickLocation[0], stickLocation[1]);
                break;
            }

        }
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }
    static void doStick(int[][] map, int[][] sticker, int starti, int startj){
        for(int i=0; i<sticker.length; i++){
            for(int j=0; j<sticker[0].length; j++){
                if(map[starti + i][startj + j] == 0)
                    map[starti + i][startj + j] = sticker[i][j];
            }
        }
    }
    static int[] canStick(int[][] origin, int[][] sticker){
        //2. 스티커 붙일 수 있는 위치 반환
        for(int i=0; i<=N - sticker.length; i++){
            for(int j=0; j<=M - sticker[0].length; j++){
                if(checkStick(origin, sticker, i, j)){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    static boolean checkStick(int[][] origin, int[][] sticker, int starti, int startj){

        for(int i=0; i<sticker.length; i++){
            for(int j=0; j<sticker[0].length; j++){
                if(sticker[i][j] == 1 && origin[starti + i][startj + j] == 1)
                    return false;
            }
        }
        return true;
    }
    static int[][] rotateArray(int[][] sticker){
        //행 열 바꾸기
        int n = sticker[0].length;
        int m = sticker.length;

        int[][] copy = new int[n][m];

        //n = 4 => 2
        //m = 2 => 4
        //0,0 -> 0,4
        //0,1 -> 1,4
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][m-1-j] = sticker[j][i];
            }
        }

        return copy;
    }
    static void print(int[][] map){
        System.out.println();
        System.out.println("==============================");
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
