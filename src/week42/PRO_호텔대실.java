package week42;
import java.util.*;
public class PRO_호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2)-> t1[0] - t2[0]);
        // Change hour to minute
        for(String[] time : book_time){
            st = new StringTokenizer(time[0], ":");
            int start = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(time[1], ":");
            int end = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) + 10;

            pq.add(new int[]{start, end});
        }

        int[] now = pq.poll();
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((t1, t2)-> t1[1] - t2[1]);
        pq2.add(now);
        answer = 1;
        // First out by start time
        while(!pq.isEmpty()){
            int[] next = pq.poll();

            int[] before = pq2.peek();

            if(before[1] > next[0]){
                //겹치는 부분이 있다면
                answer++;   // 방 하나 더
                pq2.add(next);
                answer = Math.max(answer, pq2.size());
            }else{
                pq2.poll();
                pq2.add(next);
            }
        }

        return answer;
    }
}
