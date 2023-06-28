package week43;

import java.util.*;

public class PRO_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // minerals 를 다섯개씩 쪼개고 군집 생성
        // 군집의 가중치
        int index = 0;

        // 가중치 내림차순
        PriorityQueue<Bucket> pq = new PriorityQueue<>((b1, b2) -> b2.weight - b1.weight);

        Bucket bucket = new Bucket();
        for(String mineral : minerals){
            //새로운 군집
            if(index % 5 == 0) bucket = new Bucket();

            if(mineral.equals("diamond")) bucket.weight += 400;
            else if(mineral.equals("iron")) bucket.weight += 20;
            else bucket.weight += 1;
            bucket.minerals.add(mineral);

            index++;

            //5개 군집 생성 or 나머지 => 우선순위 큐 넣기
            if(index == minerals.length || bucket.minerals.size() == 5){
                pq.add(bucket);
            }

            // 주의!!!! 곡괭이 수가 적은 TC
            // 우선순위를 부여하다보니 캘 수 없는 군집이 앞으로 오게 됨.
            if(pq.size() == picks[0] + picks[1] + picks[2]) break;
        }
        // 곡괭이 큐에 넣기
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<picks.length; i++){
            for(int j=0; j<picks[i]; j++){
                q.add(i);
            }
        }
        // 가장 많은 피로도를 차지하는 군집부터 다이아몬드 곡괭이 물리기
        while(!pq.isEmpty()){
            Bucket now = pq.poll();

            if(q.isEmpty()) break;  // 곡괭이 없으면 끝
            int gocIdx = q.poll();
            for(String mineral : now.minerals){
                answer += cornf(gocIdx, mineral);
            }
        }

        return answer;
    }
    public int cornf(int pickIdx, String minerals){ //채굴
        if(pickIdx == 0){   //dia
            return 1;
        }else if(pickIdx == 1){  //iron
            if(minerals.equals("diamond")) return 5;
            else return 1;
        }else{  //stone
            if(minerals.equals("diamond")) return 25;
            else if(minerals.equals("iron")) return 5;
            else return 1;
        }
    }
}
class Bucket{
    ArrayList<String> minerals = new ArrayList<>();
    int weight; //가중치
}