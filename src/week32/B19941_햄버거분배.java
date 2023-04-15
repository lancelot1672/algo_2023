package week32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19941_햄버거분배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        boolean[] selected = new boolean[N];

        int cnt = 0;
        for(int i=0; i<N; i++) {
            if (input[i] == 'H') continue;

            //제일 왼쪽부터 선택해보자
            for (int w = i - K; w <= i + K; w++) {
                if (w < 0 || w >= N) continue;
                if (input[w] == 'P' || selected[w]) continue;
                //선택
                selected[w] = true;
                cnt++;
                break;
            }
        }
        System.out.println(cnt);
    }
}
