package week37;
import java.util.Stack;

public class PRO_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            // index , value
            int[] now = new int[]{i, numbers[i]};

            // 현재 정수보다 앞에 작은 놈 있으면 그 작은 놈에 대한 큰놈은 나다.
            while (!stack.isEmpty() && stack.peek()[1] < now[1]) {
                int[] before = stack.pop();
                answer[before[0]] = now[1];
            }
            stack.push(now);
        }
        // stack에 남아있는 놈들은 뒷 큰수가 존재하지 않는다.
        while (!stack.isEmpty()) {
            int[] num = stack.pop();
            answer[num[0]] = -1;
        }
        return answer;
    }
}
