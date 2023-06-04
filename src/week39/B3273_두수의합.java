package week39;
import java.io.*;
import java.util.*;

public class B3273_두수의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] array = new boolean[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 true 처리
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            array[num] = true;
        }

        int x = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=1; i<=1000000; i++){
            if(!array[i]) continue; // 숫자 없으면 패스
            if(x - i == i) continue; // x = 100 일때 50 + 50은 체크 x
            if(x - i < 1 || x - i > 1000000) continue;

            if(array[x - i]){   // i + a = x
                answer++;
                array[x - i] = false;
                array[i] = false;
            }
        }

        System.out.println(answer);
    }
}