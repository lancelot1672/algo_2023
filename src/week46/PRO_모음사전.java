package week46;
import java.util.*;
/**
 * Time : 12m
 * Category : 완전탐색, 중복순열
 */
public class PRO_모음사전 {
    // 17:05 ~ 17:17
    public int solution(String word) {
        int answer = 1;

        pq = new PriorityQueue<>((s1, s2) -> s1.compareTo(s2));
        for(int i=1; i<=5; i++){
            output = new char[i];   // i개 뽑기
            dfs(0, i);
        }
        while(!pq.isEmpty()){
            if(pq.poll().equals(word)) break;
            answer++;
        }
        return answer;
    }
    PriorityQueue<String> pq;
    char[] alpha = new char[]{'A','E','I','O','U'};
    char[] output;
    public void dfs(int cnt, int m){
        if(cnt == m){
            StringBuilder sb = new StringBuilder();
            sb.append(output);
            pq.add(sb.toString());
            return;
        }

        for(int i=0; i<5; i++){
            output[cnt] = alpha[i];
            dfs(cnt+1, m);
        }
    }
}
