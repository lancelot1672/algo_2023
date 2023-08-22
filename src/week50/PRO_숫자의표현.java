package week50;
import java.util.*;
public class PRO_숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        int sum = 1;
        int index = 1;
        queue.add(index++);
        while(!queue.isEmpty()){
            if(sum < n && index <= n){
                sum += index;
                queue.add(index);
                index++;
            }else{
                if(sum == n) answer++;
                sum -= queue.poll();
            }
        }
        return answer;
    }
}
