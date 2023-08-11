package week49;

import java.util.Stack;

public class PRO_크레인인형뽑기게임 {
    int N;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        N = board.length;
        Stack<Integer> stack = new Stack<>();
        //해당 위치 - 1 에서 탐색
        for(int move : moves){
            int doll = getDoll(board, move - 1);
            System.out.println(doll);
            if(doll == -1) continue;

            if(!stack.isEmpty()){
                int before = stack.peek();
                if(doll == before){ // 터트린 인형
                    stack.pop();
                    answer++;
                    continue;
                }
            }
            stack.push(doll);
        }

        return answer * 2;
    }
    // 인형 리턴
    // -1일 경우 Nothing
    public int getDoll(int[][] board, int j){
        for(int i=0; i<N; i++){
            if(board[i][j] != 0) {
                int n = board[i][j];
                board[i][j] = 0;
                return n;
            }
        }
        return -1;
    }
}
