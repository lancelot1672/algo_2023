package week37;
import java.util.*;
public class PRO_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int groupCnt = minerals.length / 5 + 1; // 그룹 수
        int gocCnt = picks[0] + picks[1] + picks[2];    // 곡괭이 수

        if(groupCnt > gocCnt){  // 곡괭이가 모자라다면 곡괭이만큼만
            groupCnt = gocCnt;
        }
        PriorityQueue<Group> pq = new PriorityQueue<>((g1, g2)-> g2.weight - g1.weight);
        // 그룹짓기
        for(int m=0; m<groupCnt; m++){
            Group group = new Group(m, 0);
            for(int i=0; i<5; i++){
                if(5 * m + i >= minerals.length) break; //미네랄 끝!

                String mineral = minerals[5 * m + i];
                group.mineralList.add(mineral); //그룹의 미네랄 리스트
                group.weight += calculate(mineral); // 그룹의 가중치
            }
            pq.add(group);  // 가중치 내림차순 정렬
        }
        //가중치 높은것부터 다이아곡괭이사용

        int gocIdx = 0;
        int sum = 0;
        while(!pq.isEmpty() && gocIdx < 3){
            Group group = pq.poll();
            if(picks[gocIdx] == 0) gocIdx++;


            if(gocIdx == 0){    // 다이아몬드
                for(String m : group.mineralList){
                    sum += 1;
                }
            }else if(gocIdx == 1){ // iron
                for(String m : group.mineralList){
                    if(m.equals("diamond")){
                        sum += 5;
                    }else{
                        sum += 1;
                    }
                }
            }else{  //stone
                for(String m : group.mineralList){
                    if(m.equals("diamond")){
                        sum += 25;
                    }else if(m.equals("iron")){
                        sum += 5;
                    }else{
                        sum += 1;
                    }
                }
            }
            picks[gocIdx]--;    //곡괭이 사용
        }
        answer = sum;
        return answer;
    }
    // 가중치를 계산하는 함수
    public int calculate(String mineral){
        if(mineral.equals("diamond")){
            return 10;
        }else if(mineral.equals("iron")){
            return 5;
        }else {
            return 1;
        }
    }
    class Group{
        int groupId;
        int weight;
        ArrayList<String> mineralList = new ArrayList<>();

        public Group(int groupId, int weight){
            this.groupId = 0;
            this.weight = 0;
        }
    }
}
