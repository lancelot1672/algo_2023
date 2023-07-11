package week45;
/**
 * Time : 20m
 * Category : 수학, implements
 * 문제를 꼼꼼히 읽으슈
 */
public class PRO_콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int newCoke = 0;
        int temp = 0;
        while(n >= a){
            newCoke = (n / a) * b;
            answer += newCoke;
            temp = n % a;   //나머지 빈병 모아놓기

            n = newCoke + temp;

        }
        return answer;
    }
}
