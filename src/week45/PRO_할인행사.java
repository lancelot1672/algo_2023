package week45;
import java.util.*;

/**
 * Time : 30m
 * Category : Implement
 * Description
 * 100,000 * 10 의 시간복잡도를 가진다.
 * 연속으로 10일간의 데이터를 비교하면서 진행
 * map을 통해 원하는 품목(Key)의 Index(Value)를 가져올 때,
 * Null 이면 장바구니에 없는 품목 즉, 더 볼 필요가 없음.
 * 갯수가 1개 이상이여야 품목 갯수 - 1 동시에 count
 * 10개 다돌았을 경우 count == 0 이여야 가능한 날
 */
public class PRO_할인행사 {
    Map<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //장바구니 목록 => Map
        map = new HashMap<>();

        for(int i=0; i<want.length; i++){
            map.put(want[i], i);
        }

        for(int i=0; i<=discount.length - 10; i++){
            if(simulation(i, number, discount)) answer++;
        }

        return answer;
    }
    public boolean simulation(int start, int[] number, String[] discount){

        int[] copy = deepcopy(number);
        int cnt = 10;
        //10일 비교
        // map에서 가져온 Index를 통해 copy 배열에서 수 --
        for(int i=start; i<start + 10; i++){
            Integer proIdx = map.get(discount[i]);
            if(proIdx == null) break;

            if(copy[proIdx] > 0){
                copy[proIdx]--;
                cnt--;
            }
        }
        if(cnt == 0) return true;

        return false;
    }

    public int[] deepcopy(int[] origin){
        int[] copy = new int[origin.length];

        for(int i=0; i<origin.length; i++){
            copy[i] = origin[i];
        }

        return copy;
    }
}
