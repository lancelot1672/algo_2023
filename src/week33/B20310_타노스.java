package week33;

import java.io.*;

/**
 * 백준 20310 타노스
 * 23m 37s
 */
public class B20310_타노스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = s.charAt(i) - '0';
        }
        //갯수 세기
        int zeroCnt = 0;
        int oneCnt = 0;

        for(int n : arr){
            if(n == 0){
                zeroCnt++;
            }else{
                oneCnt++;
            }
        }
        zeroCnt /= 2;
        oneCnt /= 2;

        // 1은 앞에서 부터 지운다
        tanos(arr, zeroCnt, 0);
        tanos(arr, oneCnt, 1);

        StringBuilder sb = new StringBuilder();
        for(int n : arr){
            if(n != -1)
                sb.append(n);
        }
        System.out.println(sb.toString());
    }
    static void tanos(int[] arr, int count, int num){
        int index = (num == 0) ? arr.length - 1 : 0;
        while(count != 0){
            if(arr[index] == num){
                arr[index] = -1;    //타노스~~
                count--;
            }
            if(num == 0){
                index--;
            }else{    // 1이면 앞에서 부터
                index++;
            }
        }
    }
}
