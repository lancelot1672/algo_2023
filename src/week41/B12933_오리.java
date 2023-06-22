package week41;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 37분
 * 64%에서 오류
 * 반례 : quackq
 */
public class B12933_오리 {
    static char[] duck = {'q','u','a','c','k'};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int answer = 0;

        // 5의 배수 확인
        if(arr.length % 5 != 0){
            System.out.println(-1);
            return;
        }
        //duck의 울음소리로 체크
        for(int idx=0; idx<arr.length; idx++){
            if(arr[idx] == 'x') continue;

            int duckIdx = 0;    // 울음 인덱스
            int duckCnt = 0;    // 우는 횟수
            for(int j = idx; j<arr.length; j++){
                if(arr[j] == duck[duckIdx]){
                    duckIdx++;
                    arr[j] = 'x';
                }
                // 연속해서 우는 경우
                if(duckIdx == 5){
                    duckIdx = 0;    // q 부터 다시 실행
                    duckCnt++;
                }

            }
            //System.out.println(Arrays.toString(arr));
            if(duckCnt != 0){
                answer++;
            }else{
                System.out.println(-1);
                return;
            }
        }

        // 울음한 소리가 남아있으면 -1
        if(!isDuck(arr)){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
    static boolean isDuck(char[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 'x') return false;
        }
        return true;
    }
}