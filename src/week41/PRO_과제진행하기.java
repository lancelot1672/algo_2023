package week41;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class PRO_과제진행하기 {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        PriorityQueue<Homework> pq = new PriorityQueue<>((h1, h2)-> h1.start - h2.start);
        Stack<Homework> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();

        for(String[] plan : plans){
            Homework hw = new Homework();
            hw.name = plan[0];
            // 시간 -> 분 변환
            StringTokenizer st = new StringTokenizer(plan[1], ":");
            hw.start = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            hw.during = Integer.parseInt(plan[2]);

            pq.add(hw);
        }

        //첫번째 것
        Homework now = pq.poll();
        int nowTime = now.start;

        while(!pq.isEmpty()){
            Homework next = pq.poll();  //꺼내서 확인

            // 다음 숙제가 먼저 실행되어야 하는 경우
            if(nowTime + now.during > next.start){
                //남은 것 스택에 저장
                now.during -= next.start - nowTime;
                stack.push(now);

            }else if(nowTime + now.during < next.start){
                //다음 숙제 전까지 시간이 남는 경우
                //앞에것 끝
                list.add(now.name);
                nowTime += now.during;

                // 다음 숙제 시간까지 남는 시간
                int restTime = next.start - nowTime;

                while(restTime > 0 && !stack.isEmpty()){
                    //미뤄둔 숙제
                    Homework restHw = stack.pop();

                    if(restHw.during > restTime){
                        restHw.during -= restTime;
                        restTime = 0;
                        stack.push(restHw);
                    }else{
                        //미뤄둔 숙제 끝
                        restTime -= restHw.during;
                        list.add(restHw.name);
                    }
                }//END WHILE

            }else{
                //바로 다음 숙제
                list.add(now.name);
            }
            //기준 시간 갱신
            now = next;
            nowTime = next.start;

            //마지막 HW 시작
            if(pq.isEmpty()){
                list.add(now.name);
            }
        }//end out while
        //남은 숙제 순차 처리
        while(!stack.isEmpty()){
            list.add(stack.pop().name);
        }

        int idx = 0;
        for(String name : list){
            answer[idx++] = name;
        }
        return answer;
    }
}
class Homework {
    String name;
    int start;
    int during;

}