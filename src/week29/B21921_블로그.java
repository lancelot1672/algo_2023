package week29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21921_블로그 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visit = new int[N];

        for(int i=0; i<N; i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int total = 0;
        int count = 1;
        for(int i=0; i<X; i++){
             total += visit[i];
        }
        max = Math.max(max, total);

        for(int i=X; i<N; i++){
            total -= visit[i-X];
            total += visit[i];

            if(max < total){ // 최대 방문자
                count = 1;  // count 초기화
                max = total;
            }else if(max == total){ // count 추가
                count++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(count);
    }
}
