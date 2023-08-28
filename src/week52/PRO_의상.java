package week52;
import java.util.*;
public class PRO_의상 {
    int answer;
    public int solution(String[][] clothes) {
        answer = 0;

        Map<String, Integer> map = new HashMap<>();

        int len = 0;
        for(String[] cloth : clothes){
            if(map.get(cloth[1]) == null){
                map.put(cloth[1], 1);
                len++;  //새로운 의상의 종류
            }else{
                map.put(cloth[1], map.get(cloth[1]) + 1);
            }
        }
        arr = new int[len];
        int i=0;
        for(String key : map.keySet()){
            arr[i++] = map.get(key);
        }
        //의상의 종류의 수만큼
        // for(int c=1; c<=len; c++){
        //     output = new int[c];
        //     comb(c, len, 0, 0);
        // }

        //A의 종류가 N개, B의 종류가 M개 일 때 선택하는 모든 경우의 수는 (N + 1)(M + 1)
        //+1 의 의미는 선택하지 않음을 의미
        int temp = 1;
        for(int c=0; c<len; c++){
            temp *= (arr[c] + 1);
        }
        answer = temp - 1;
        return answer;
    }
    int[] output;
    int[] arr;
    public void comb(int m, int n, int idx, int cnt){
        if(cnt == m){
            int temp = 1;
            for(int i=0; i<m; i++){
                temp *= output[i];
            }
            answer += temp;
            return;
        }
        if(idx == n){
            return;
        }
        output[cnt] = arr[idx];
        comb(m, n, idx+1, cnt+1);
        comb(m, n, idx+1, cnt);

    }
}
