package week30;

import java.util.Stack;

public class PRO_KAKAO1차_비밀지도 {
    public static void main(String[] args) {

    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] map1 = getMap(arr1, n);
        String[] map2 = getMap(arr2, n);


        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                // OR 연산
                if(map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1'){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
    public String[] getMap(int[] arr, int n){
        String[] map = new String[n];

        for(int i=0; i<n; i++){
            map[i] = getLine(arr[i], n);
        }

        return map;
    }
    public String getLine (int num, int n){
        Stack<Integer> stack = new Stack<>();

        while(num != 0){
            int remain = num % 2;
            stack.push(remain);
            System.out.println(remain);
            num /= 2;
        }
        StringBuilder sb = new StringBuilder();

        //앞에 0 채우기
        for(int i=0; i< n - stack.size(); i++){
            sb.append("0");
        }
        //맵 채우기
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
