package week45;

public class PRO_숫자짝꿍 {
    // 15:38 ~ 15:50
    public String solution(String X, String Y) {
        String answer = "";
        int[] numberX = new int[10];
        int[] numberY = new int[10];
        for(char c : X.toCharArray()) numberX[c - '0']++;
        for(char c : Y.toCharArray()) numberY[c - '0']++;

        StringBuilder sb = new StringBuilder();

        for(int i=9; i>= 0; i--){
            if(numberX[i] == 0 || numberY[i] == 0) continue;
            int min = numberX[i] > numberY[i] ? numberY[i] : numberX[i];

            for(int j=0; j<min; j++){
                sb.append(i);
            }
        }
        answer = sb.toString();

        if(sb.toString().equals("")) return "-1";
        // 0 으로만 이루어져 있으면


        // 기존 코드
//        int zeroCnt = 0;
//        for(char c : sb.toString().toCharArray()) if(c == '0') zeroCnt++;
//        if(zeroCnt == answer.length()) answer = "0";

        // 개선 코드 - 맨 앞자리만 확인하면 됨.
        if(answer.charAt(0) == '0') answer = "0";

        return answer;
    }
}
