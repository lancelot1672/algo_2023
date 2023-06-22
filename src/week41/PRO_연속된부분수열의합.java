package week41;

/**
 * 투 포인터 문제
 * 처음부터 다시 풀어보자
 */
public class PRO_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int cnt = 1;
        int minCnt = Integer.MAX_VALUE;

        while(true){
            if(end < sequence.length && sequence[end] == k){
                answer = new int[]{end,end};
                break;
            }
            if(sum <= k && end < sequence.length){   // 작거나 같으면 더하기
                end++;
                if(end < sequence.length) sum += sequence[end];
                cnt++;
            }
            else{
                if(start < sequence.length){
                    sum -= sequence[start];
                }
                start++;
                cnt--;
            }
            if(start == sequence.length && end == sequence.length) break;
            if(sum == k){
                if(minCnt > cnt){
                    minCnt = cnt;
                    answer = new int[]{start, end};
                }
            }
        }
        return answer;
    }
}
