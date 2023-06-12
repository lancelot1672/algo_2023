package week37;

import java.util.Arrays;
import java.util.Stack;

public class PRO_택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int N = Arrays.stream(order).max().getAsInt();
        int orderIdx = 0;
        // 1번 상자부터 N상자
        int n=1;
        while(n<=N){

            //order
            int o = order[orderIdx];

            //먼저 보조 컨테이너 벨트 확인
            if(!stack.isEmpty() && stack.peek() == o){
                // 보조에 있다면
                stack.pop();
                answer++;
                orderIdx++;
                // 보조 컨테이너에서 가져오는 경우는 n 증가 x
                // n++;
                continue;
            }
            // 새주문
            if(n == o){
                answer++;
                orderIdx++;
                n++;
                continue;
            }
            stack.push(n++);
        }
        for(int i=orderIdx; i<order.length; i++){
            if(stack.isEmpty() || order[i] != stack.peek()) break;

            stack.pop();
            answer++;
        }
        return answer;
    }
}
