package week27;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int n=1; n<=N; n++){
            q.add(n);
        }

        while(q.size() != 1){
            // 맨 위 카드 버리기
            q.poll();

            // 맨 위 카드 맨 밑으로 보내기
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }
}
