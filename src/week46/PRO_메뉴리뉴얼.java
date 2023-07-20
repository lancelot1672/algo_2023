package week46;
import java.util.*;

/**
 * Time : 45m
 * Category : 완탐, 구현
 *
 */
public class PRO_메뉴리뉴얼 {
    int[][] alpha;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        alpha = new int[orders.length][26];
        for(int i=0; i<orders.length; i++){
            char[] order = orders[i].toCharArray();
            for(int j=0; j<order.length; j++){
                alpha[i][ order[j] - 'A' ] = 1;
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(int m : course){
            // m 길이의 조합을 다 구해
            for(String order : orders){
                if(order.length() < m) break;

                map = new HashMap<>();

                dfs(order, 0, 0, m, "");
            }
            // m 길이의 조합을 다 구했으면
            // 가장 많이 함께 주문한 단품 메뉴의 갯수는?
            int max = 0;
            for(String key : map.keySet()){
                max = Math.max(map.get(key), max);
            }
            for(String key : map.keySet()){
                if(max == map.get(key)){
                    list.add(key);
                }
            }

        }
        System.out.println(list.toString());
        return answer;
    }
    Map<String, Integer> map;
    public void dfs(String order, int idx, int cnt, int m, String output){
        if(cnt == m){
            int count = 0;
            for(int i = 0; i< alpha.length; i++){
                boolean check = true;
                // output의 음식이 다들어가있으면 카운트
                for(char o : output.toCharArray()){
                    if(alpha[i][ o - 'A'] != 1){
                        check = false; break;
                    }
                }
                if(check) count++;
            }
            map.put(output, count);

            return;
        }
        if(idx == order.length()) return;

        dfs(order, idx+1, cnt+1, m, output + order.charAt(idx));
        dfs(order, idx+1, cnt, m, output);
    }
}
