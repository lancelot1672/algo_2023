package week51;

import java.util.PriorityQueue;

public class PRO_가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(s1).append(s2);

            StringBuilder sb2 = new StringBuilder();
            sb2.append(s2).append(s1);

            return sb2.toString().compareTo(sb1.toString());
        });
        for(int number : numbers){
            pq.add("" + number);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        answer = sb.toString();

        // 앞에 0제거
//        int zeroCnt = 0;
//        for(int i=0; i<answer.length(); i++){
//            if(answer.charAt(i) != '0') break;
//            zeroCnt++;
//        }
//        if(zeroCnt == answer.length()){
//            return "0";
//        }
//        answer = answer.substring(zeroCnt, answer.length());

        //기가 막히네,,,
        if(answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}
