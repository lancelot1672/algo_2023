package week45;
import java.util.*;

/**
 * Time : 12m
 * Category : Two Pointer, Set
 * Description
 * 길이가 N인 수열이 있다고 하면, 앞에서부터 N-1까지 뒤에 붙여준다.
 *
 */
public class PRO연속부분수열합의개수 {
    Set<Integer> set;
    public int solution(int[] elements) {
        int answer = 0;

        int[] newArr = new int[elements.length + elements.length - 1];
        set = new HashSet<>();
        for(int i=0; i<elements.length; i++){
            newArr[i] = elements[i];

            if(i + elements.length == newArr.length) continue;
            newArr[i + elements.length] = elements[i];
        }
        // 길이가 1인 연속 부분 수열부터 N까지
        for(int i=1; i<=elements.length; i++){
            simulation(i, newArr);
        }
        answer = set.size();
        return answer;
    }
    public void simulation(int n, int[] arr){
        //길이가 n인 연속 부분 수열

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        set.add(sum);

        for(int i=0; i< arr.length - n; i++){
            sum -= arr[i];
            sum += arr[i + n];
            set.add(sum);
        }
    }
}
