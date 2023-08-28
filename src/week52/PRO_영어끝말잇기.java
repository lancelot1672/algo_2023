package week52;
import java.util.*;

public class PRO_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        Set<String> set = new HashSet<>();
        String word = words[0];
        set.add(word);

        int idx=1;
        int word_index=2;
        int round = 1;
        for(int i=1; i<words.length; i++){
            //글자가 안맞아
            if(word.charAt(word.length()-1) != words[i].charAt(0)){
                answer = new int[]{idx+1, round};
                break;
            }
            //중복
            if(!set.add(words[i])){
                answer = new int[]{idx+1, round};
                break;
            }

            word = words[i];
            idx++;
            word_index++;
            if(idx % n == 0){
                idx = 0;
                round++;
            }
        }
        return answer;
    }
}
