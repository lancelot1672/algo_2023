package week52;
import java.util.*;
public class PRO_예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for(int num : d){
            if(budget - num < 0) break;
            budget -= num;
            answer++;
        }
        return answer;
    }
}
