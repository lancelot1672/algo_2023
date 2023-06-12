package week37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 30m
 */
public class B2659_십자카드문제 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cards = new int[4];

        cards[0] = Integer.parseInt(st.nextToken());
        cards[1] = Integer.parseInt(st.nextToken());
        cards[2] = Integer.parseInt(st.nextToken());
        cards[3] = Integer.parseInt(st.nextToken());

        int clockNumber = getClockNumber(cards);

        int answer = 0;
        // 1111 부터 시작
        for(int i=1111; i<clockNumber; i++){
            // 10으로 나누어떨어지면 X
            if(i % 10 == 0) continue;

            // 테스트 시계수
            int[] tCards = getCards(i);
            int tClockNum = getClockNumber(tCards);

            // 시계수가 아니라면
            if(i != tClockNum) continue;

            //해당 수의 시계수가 입력 시계수보다 작으면.
            if(tClockNum < clockNumber){
                answer++;
            }
        }

        System.out.println(answer + 1);
    }
    // 숫자를 카드로 변환
    public static int[] getCards(int num){
        int[] cards = new int[4];

        String str = num + "";

        for(int i=0; i<4; i++){
            cards[i] = str.charAt(i) - '0';
        }

        return cards;
    }
    // 시계수 구하기
    // 시계방향으로 돌린 수 중에 제일 작은 수
    public static int getClockNumber(int[] cards){
        int[] clockNumbers = new int[4];

        for(int n=0; n<4; n++){
            StringBuilder sb = new StringBuilder();
            for(int i=n; i<4; i++){
                sb.append(cards[i]);
            }
            for(int i=0; i<n; i++){
                sb.append(cards[i]);
            }
            clockNumbers[n] = Integer.parseInt(sb.toString());
        }
        return Arrays.stream(clockNumbers).min().getAsInt();
    }
}