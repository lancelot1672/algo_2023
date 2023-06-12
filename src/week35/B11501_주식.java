package week35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501_주식 {
    static int N;
    static Long max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            max = 0L;   // 최대 이익 초기화
            int[] stockPrice = new int[N];  // 날별 주식 가격
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                stockPrice[n] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            int maxIdx = 0;
            Long money = 0L;
            int stockCnt = 0;
            while(idx < N){
                //최댓값과 최댓값 인덱스 찾기
                for(int i=idx+1; i<N; i++){
                    if(stockPrice[i] > stockPrice[maxIdx]){
                        maxIdx = i;
                    }
                }
                if(stockPrice[idx] == stockPrice[maxIdx]){
                    //굳이 살필요 없지 이제는..
                    break;
                }
                //최댓값이 있는 곳만큼 주식을 사자
                stockCnt += maxIdx - idx;
                for(int i=idx; i<maxIdx; i++){
                    money -= stockPrice[i];
                    stockCnt++;
                }

                idx = maxIdx;

                // 다팔아
                money += stockPrice[idx] * stockCnt;
                idx++;

            }

            sb.append(money + "\n");
        }//end tc
        System.out.println(sb.toString());
    }
}
