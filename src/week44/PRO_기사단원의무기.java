package week44;

/**
 * 약수 구하는 것을 최적화 하여 최대 10배의 성능을 보임
 *
 */
public class PRO_기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;


        for(int i=1; i<=number; i++){
            int cnt = getDivisions(i);
            System.out.println(cnt);
            if(limit < cnt){
                //제한수치를 초과
                answer+= power;
            }else{
                answer += cnt;
            }
        }

        return answer;
    }
    public int getDivisions(int number){
        if(number == 2 || number == 3) return 2;

        int count = 0;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                count += 2;
            }

        }
        if(sqrt * sqrt == number) count--;

        return count;
    }
}
