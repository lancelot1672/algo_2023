package week46;

/**
 * Time : 10m
 * Category : 구현
 *
 */
public class PRO_이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        while(!s.equals("1")){  // 1이 될 때까지 반복
            cnt++;
            int originLen = s.length();
            //제거한 0개 갯수
            s = s.replaceAll("0","");
            answer[1] += originLen - s.length();

            int len = s.length();   //x의 길이
            s = logic(len); // 2진법으로 표현한 문자열

        }
        answer[0] = cnt;
        return answer;
    }
    public String logic(int len){
        StringBuilder sb = new StringBuilder();

        while(len != 1){
            sb.append(len % 2);
            len /= 2;
        }
        sb.append(len);

        String a = sb.reverse().toString();

        return a;
    }
}
