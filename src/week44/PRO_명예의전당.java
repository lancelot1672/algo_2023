package week44;
import java.util.*;

/**
 * Time : 34m
 * Category : implement
 * Description
 * 문제가 쉬워도 의심을 해봐라.
 * 명예의 전당인 k가 score의 길이보다 클 수 있다는 것을 생각.
 */
public class PRO_명예의전당 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2)-> s1 - s2);

        for(int i=0; i<k; i++){
            if(i >= score.length) break;
            pq.add(score[i]);
            answer[i] = pq.peek();
        }

        for(int i=k; i<score.length; i++){
            pq.add(score[i]);

            pq.poll();
            answer[i] = pq.peek();
        }
        return answer;
    }
}
