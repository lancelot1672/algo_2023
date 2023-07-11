package week45;
/**
 * Time : 35m
 * Category : 문자열
 * 비효율적인 빡 구현 코드
 * => 조건문을 통해 최적화 가능
 */
public class PRO_옹알이2 {

    String[] baby = new String[]{"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for(String s : babbling){
            if(canSpeak(s)) answer++;
        }
        return answer;
    }
    public boolean canSpeak(String s){
        String before = "";
        while(s.length() > 1){
            switch(s.charAt(0)){
                case 'a':
                    if(s.length() < 3) return false;    //길이가 aya보다 작으면
                    if(!s.substring(0,3).equals(baby[0])) return false; //aya가 아니면
                    if(s.substring(0,3).equals(before)) return false;   // 연속 발음
                    before = s.substring(0,3);
                    s = s.substring(3, s.length());

                    break;
                case 'y':
                    if(s.length() < 2) return false;    //길이가 ye보다 작으면
                    if(!s.substring(0,2).equals(baby[1])) return false; //ye가 아니면
                    if(s.substring(0,2).equals(before)) return false;   // 연속 발음
                    before = s.substring(0,2);
                    s = s.substring(2, s.length());

                    break;
                case 'w':
                    if(s.length() < 3) return false;    //길이가 ye보다 작으면
                    if(!s.substring(0,3).equals(baby[2])) return false; //ye가 아니면
                    if(s.substring(0,3).equals(before)) return false;   // 연속 발음
                    before = s.substring(0,3);
                    s = s.substring(3, s.length());

                    break;
                case 'm':
                    if(s.length() < 2) return false;    //길이가 ye보다 작으면
                    if(!s.substring(0,2).equals(baby[3])) return false; //ye가 아니면
                    if(s.substring(0,2).equals(before)) return false;   // 연속 발음
                    before = s.substring(0,2);
                    s = s.substring(2, s.length());

                    break;
                default :
                    return false;
            }
        }
        if(s.length() == 0) return true;
        else return false;
    }
}
