package week50;

public class PRO_다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        int one = parseTwo(n);
        while(n <= 1000000){
            if(one == parseTwo(++n)){
                answer = n;
                break;
            }
        }
        return answer;
    }
    public int parseTwo(int num){
        int cnt = 0;
        while(num > 1){
            if(num % 2 == 1) cnt++;
            num /= 2;
        }
        if(num == 1) cnt++;

        return cnt;
    }
}
