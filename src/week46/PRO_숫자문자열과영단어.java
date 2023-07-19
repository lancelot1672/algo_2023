package week46;

/**
 *
 */
public class PRO_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;

        String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int idx=0;
        for(String number : numbers){
            s = s.replaceAll(number, "" + idx++);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
