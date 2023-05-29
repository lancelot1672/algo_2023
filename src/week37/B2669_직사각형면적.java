package week37;

import java.util.*;
        import java.io.*;
public class B2669_직사각형면적 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[101][101];
        int answer = 0;
        for(int n=0; n<4; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    if(!map[x][y]){
                        map[x][y] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}