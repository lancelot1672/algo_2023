package week44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Time : 43m
 * Category : implement
 * Description
 * 200,000 * 200,000
 * Q개 줄에 걸쳐 S를 다시 계산하면 최악의 경우
 *
 */
public class B17128_소가정보섬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int[] sArr = new int[N];

        for(int i=0; i<N; i++){
            sArr[i] = arr[i];
            for(int j=1; j<4; j++){
                if(i+j >= N){
                    sArr[i] *= arr[i+j - N];
                }else{
                    sArr[i] *= arr[i+j];
                }
            }
        }
        int sum = addAll(N, sArr);

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int q=0; q<Q; q++){
            int cowNum = Integer.parseInt(st.nextToken()) - 1;
            // cowNum == 3 => idx => 2 ||  0, 1, 2 ,7
            for(int j=0; j<4; j++){
                if(cowNum - j < 0){
                    sum -= sArr[N + cowNum - j];
                    sArr[N + cowNum - j] *= -1;
                    sum += sArr[N + cowNum - j];
                }else{
                    sum -= sArr[cowNum - j];
                    sArr[cowNum - j] *= -1;
                    sum += sArr[cowNum - j];
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
    static int addAll(int N, int[] sArr){
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += sArr[i];
        }

        return sum;
    }
}