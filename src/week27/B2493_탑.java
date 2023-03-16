package week27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int[0] : index, int[1] : top
        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            int top = Integer.parseInt(st.nextToken());

            while(true){
                if(stack.isEmpty()){
                    sb.append("0 ");
                    stack.add(new int[]{i, top});
                    break;
                }
                int[] prev = stack.peek();
                if(prev[1] < top){
                    stack.pop();
                }else{
                    sb.append(prev[0] + " ");
                    stack.add(new int[]{i, top});
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }

}
