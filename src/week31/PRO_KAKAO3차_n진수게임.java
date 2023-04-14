package week31;

public class PRO_KAKAO3차_n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int i = 0;
        int turn = 1;
        while(true){
            String num = getAnswer(n, i);
            System.out.println(num);
            for(int j=0; j<num.length(); j++){
                if(turn++ == p){    // 튜브의 순서
                    answer += num.charAt(j);
                    if(answer.length() == t){
                        return answer;
                    }
                }
                if(turn == m+1){
                    turn = 1;
                }
            }
            i++;
        }
    }
    public String getAnswer(int n, int num){    // n 진법

        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return "0";
        }
        while(num > 0){
            int rest = num % n;
            if(rest >= 10 && rest <= 15){
                sb.append((char) ('A' + rest % 10));
            }else{
                sb.append(rest);
            }
            num /= n;
        }
        return sb.reverse().toString();
    }
}
