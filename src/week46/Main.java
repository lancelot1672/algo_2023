package week46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        //K개 소수 구하기
        int num = 2;
        int cnt = 0;
        while(true){
            if(isPrime(num)) {
                list.add(num);
                cnt++;
            }
            if(cnt == K) break;
            num++;
        }
    }
    static boolean isPrime(int num){
        if(num == 2 || num == 3) return true;

        for(int i=2; i<Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
