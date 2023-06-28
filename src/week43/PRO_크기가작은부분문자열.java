package week43;

/**
 * 시간 : 08m 37s
 * 분류 : 투 포인터
 */
public class PRO_크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;

        long pNum = Long.parseLong(p);

        int end = p.length();

        for(int start=0; start<=t.length() - end; start++){
            long checkNum = Long.parseLong(t.substring(start, start+p.length()));
            if(pNum >= checkNum) answer++;

        }
        return answer;
    }
}
