package week44;
import java.util.*;

/**
 * Time : 37m
 * Category : implements
 *
 */
public class PRO_우박수열_정적분 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);


        while(k != 1){
            if(k % 2 == 0) k /= 2;
            else{
                k *= 3; k++;
            }
            list.add(k);
        }
        // 각 구간 넓이 구하기
        double[] width = new double[list.size()-1];
        for(int i=0; i<list.size()-1; i++){
            width[i] = ((double)list.get(i) + (double)list.get(i+1)) / 2;
        }

        int maxIdx = list.size() - 1;
        // System.out.println(list.toString());
        // System.out.println(Arrays.toString(width));

        //구간에 대해 정적분
        int idx = 0;
        answer = new double[ranges.length];
        for(int[] range: ranges){
            if(range[0] == 0 && range[1] == 0){
                //전체구간에 대한
                answer[idx++] = getValue(0, maxIdx, width);
                continue;
            }

            //구간의 시작
            int startX = range[0];
            int endX = maxIdx + range[1];

            if(startX == endX){
                answer[idx++] = 0.0;
                continue;
            }

            // 주어진 구간의 시작점이 끝점보다 커서??
            if(endX < startX){
                answer[idx++] = -1.0;
                continue;
            }

            answer[idx] = getValue(startX, endX, width);

            idx++;
        }//end range for
        return answer;
    }
    public double getValue(int start, int end, double[] width){
        double temp = 0.0;
        for(int i=start; i<end; i++){
            temp += width[i];
        }

        return temp;
    }
}
