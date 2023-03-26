package week28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305_주유소 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] road = new Long[N-1];  // 도로 길이
        Long[] oilBank = new Long[N]; // 주유소

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            road[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            oilBank[i] = Long.parseLong(st.nextToken());
        }

        //초기값
        Long expense = 0L;

        int now = 0;
        while(now != N-1){
            Long d = 0L;
            for(int i = now + 1; i<N; i++){
                //거리 계산
                d += road[i-1];

                // 마지막 주유소 까지 간다면
                if(i == N-1){
                    System.out.println(expense + d * oilBank[now]);
                    return;
                }
                //현재 주유소보다 작은애 나올때 까지
                if(oilBank[now] > oilBank[i]){
                    expense += (d * oilBank[now]);
                    now = i;
                    break;
                }
            }
        }
        System.out.println(expense);
    }
}
