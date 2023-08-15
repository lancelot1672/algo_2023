package week50;
import java.util.*;

/**
 * Time : 60m
 * Category : 구현
 * Description
 * 2022 KAKAO TECH INTERNSHIP
 * queue1을 기준으로 잡고 
 * queue1의 합계가 중간 기준점보다 크다면 queue2로 옮기고
 * queue1의 합계가 작다면 queue2에서 가져오기
 * 종료 조건은 처음 queue size * 3 (원래대로 돌아오는 카운트)
 */
public class PRO_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0L;
        long sum2 = 0L;

        for(int n : queue1){
            q1.add(n);
            sum1 += n;
        }
        for(int n : queue2){
            q2.add(n);
            sum2 += n;
        }

        long average = (sum1 + sum2) / 2;
        // queue1을 기준으로 up down 진행
        int cnt = 0;
        while(cnt < queue1.length * 3){
            if(sum1 == sum2) return cnt;

            if(sum1 >= average){ // q1 -> q2
                int num = q1.poll();
                sum1 -= num;

                sum2 += num;
                q2.add(num);
            }else{
                int num = q2.poll();
                sum1 += num;

                sum2 -= num;
                q1.add(num);
            }
            cnt++;
        }

        return answer;
    }
}
