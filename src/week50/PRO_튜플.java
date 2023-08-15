package week50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Time : 15m
 * Category : 문자열
 * Description
 * 2019 KAKAO 카카오 개발자 겨울 인턴쉽
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065/solution_groups?language=java
 *
 */
public class PRO_튜플 {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(1, s.length() - 1);

        ArrayList<String[]> lists = new ArrayList<>();

        int startIndex = 0;
        int endIndex = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '{'){
                startIndex = i + 1;
            }
            else if(s.charAt(i) == '}'){
                endIndex = i;
                lists.add(s.substring(startIndex, endIndex).split(","));
            }
        }
        Collections.sort(lists, (s1, s2) -> {
            return s1.length - s2.length;
        });

        Set<String> set = new HashSet<>();
        answer = new int[lists.size()];

        int idx = 0;
        for(String[] sArr : lists){
            for(String a : sArr){
                if(set.add(a)){
                    answer[idx++] = Integer.parseInt(a);
                }
            }
        }

        return answer;
    }
}
