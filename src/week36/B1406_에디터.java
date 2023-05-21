package week36;
import java.util.*;
import java.io.*;

/**
 * try 1 : LinkedList 이용 문제 해결
 * try 2 : stack 이용 문제 해결
 *  stack의 모든 연산은 O(1)의 시간복잡도를 갖는다.
 */
public class B1406_에디터 {
    static int N;
    static int cursor;
    static Stack<Character> LWords;
    static Stack<Character> RWords;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cArr = br.readLine().toCharArray();

        LWords = new Stack<>();
        RWords = new Stack<>();
        for(int c=0; c<cArr.length; c++){
            LWords.push(cArr[c]);
        }

        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            String input = br.readLine();
            changeHandler(input);
        }
        StringBuilder sb = new StringBuilder();

        //왼쪽 문자열 오른쪽으로 push
        while(!LWords.isEmpty()){
            RWords.push(LWords.pop());
        }
        while(!RWords.isEmpty()){
            sb.append(RWords.pop());
        }
        System.out.println(sb.toString());
    }
    static void changeHandler(String input){
        StringTokenizer st = new StringTokenizer(input);

        char order = st.nextToken().charAt(0);
        switch(order){
            case 'L':   //왼쪽으로 이동
                if(!LWords.isEmpty()){
                    RWords.push(LWords.pop());
                }
                break;
            case 'D':
                if(!RWords.isEmpty()){
                    LWords.push(RWords.pop());
                }
                break;
            case 'B':
                if(!LWords.isEmpty()){
                    LWords.pop();
                }
                break;
            case 'P':
                LWords.push(st.nextToken().charAt(0));
                break;
        }
    }
}