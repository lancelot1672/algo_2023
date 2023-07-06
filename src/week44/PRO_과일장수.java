package week44;

import java.util.Arrays;

/**
 *
 */
public class PRO_과일장수 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] s = new Integer[score.length];
        for(int i=0; i<score.length; i++) s[i] = score[i];

        Arrays.sort(s, (s1, s2)->{
            return s2 - s1;
        });
        int cnt = 0;
        for(int i=0; i<s.length; i++){
            cnt++;

            if(cnt % m == 0){   // m개 만큼 담았으면
                answer += s[i] * m;
            }
        }
        return answer;
    }
}
