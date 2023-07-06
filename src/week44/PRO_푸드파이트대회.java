package week44;

/**
 * Time : 4m
 */
public class PRO_푸드파이트대회 {
    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++){
            for(int j=1; j<=food[i] / 2; j++) sb.append(i);
        }
        answer += sb.toString() + "0" + sb.reverse().toString();
        return answer;
    }
}
