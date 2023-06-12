package week38;
import java.util.*;
import java.io.*;

/**
 * 33분
 * 그리는 과정
 * 1. 시계방향으로 돈다
 * 2. 반시계방향으로 돈다.
 * 모든 지점은 출발지점이 될 수 있기 때문에 출발지점 기준 수열을 구해놓는다.
 * 반시계방향으로 도는 것은 시계방향의 반대로 도는 것이므로 방향도 반대로, 도는 수열도 반대로
 */
public class B2641_다각형그리기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Set<String> set = abc(N, origin);

        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for(int tc=1; tc<=T ;tc++){
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();    //정답용
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                String num = st.nextToken();
                sb.append(num);
                sb2.append(num + " ");
            }
            if(set.contains(sb.toString())){
                count++;
                answer.append(sb2.toString() + "\n");
            }
        }
        System.out.println(count);
        System.out.println(answer.toString());
    }
    public static Set<String> abc(int N, int[] arr){
        Set<String> set = new HashSet<>();
        // 시계 방향
        for(int n=0; n<N; n++){
            StringBuilder sb = new StringBuilder();
            for(int i=n; i<N; i++){
                sb.append(arr[i]);
            }
            for(int i=0; i<n; i++){
                sb.append(arr[i]);
            }
            set.add(sb.toString());
        }
        //반시계 방향
        for(int n=0; n<N; n++){
            StringBuilder sb = new StringBuilder();

            for(int i=n; i<N; i++){
                sb.append(reverseDirection(arr[i]));
            }
            for(int i=0; i<n; i++){
                sb.append(reverseDirection(arr[i]));
            }
            set.add(sb.reverse().toString());
        }

        return set;
    }
    public static int reverseDirection(int d){
        switch(d){
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
        }
        return -1;
    }
}