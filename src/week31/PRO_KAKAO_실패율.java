package week31;

import java.util.Arrays;
import java.util.Comparator;

public class PRO_KAKAO_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        answer = new int[N]; // array init

        // 각 스테이지의 실패율 배열
        Info[] infos = new Info[N];

        for(int i=0; i<N; i++){
            int now = 0;
            int total = 0;
            for(int j=0; j<stages.length; j++){
                if(stages[j] == i+1) now++;
                if(stages[j] >= i+1) total++;
            }
            System.out.println(i+1 + " : " + (double) now / (double) total);
            infos[i] = new Info(i+1, (double) now / (double) total);
        }
        Arrays.sort(infos, new Comparator<Info>(){
            @Override
            public int compare(Info o1, Info o2) {
                return Double.compare(o2.rate, o1.rate);
            }
        });
        //실패율 내림차순 정렬
        for(int i=0; i<N; i++){
            answer[i] = infos[i].index;
        }
        return answer;
    }
    class Info{
        int index;
        double rate;

        public Info(int index, double rate){
            this.index = index;
            this.rate = rate;
        }
    }
}
