package week52;

public class PRO_예상대진표 {
    public int solution(int n, int a, int b){
        int answer = 0;

        int L = 0;
        int R = n;
        int M = n/2;

        while(true){
            if( (L < a && a <= M) && (L < b && b <= M) ){
                //왼쪽에 몰려있는 경우
                R = M;
                M = (L + M) / 2;
                n /= 2;
            }else if( (M < a && a <= R) && (M < b && b <= R) ){
                //오른쪽에 몰려있는 경우
                L = M;
                M = (M + R) / 2;
                n /= 2;
            }else{
                while (n != 1){
                    n /= 2;
                    answer++;
                }
                break;
            }
        }

        return answer;
    }
}
