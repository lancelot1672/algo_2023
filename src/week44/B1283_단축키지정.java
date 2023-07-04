package week44;

import java.io.*;

/**
 * Time : 37m
 * Category : implement
 * Description
 * substring 과정 중 일어나는 런타임에러는 StringIndexOut
 * arrayOutOfBounds랑은 다르다.
 */
public class B1283_단축키지정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] alpha = new boolean[26];
        for(int i=0; i<N; i++){
            String input = br.readLine();

            //공백으로 자르기
            String[] st = input.split(" ");

            // 모든 단어 확인
            int cnt = 0;
            int len = 0;
            for(int s=0; s<st.length; s++){

                char c = st[s].toUpperCase().charAt(0);
                if(!alpha[c - 'A']){    //단어의 첫 글자가 단축키?
                    alpha[c - 'A'] = true;    // 알파벳 단축키 지정

                    String newString = input.substring(0, len);
                    newString += "[" + st[s].charAt(0) + "]";
                    newString += input.substring(len+1, input.length());

                    sb.append(newString + "\n");
                    break;
                }
                len += st[s].length() + 1;    // 앞 길이 추가
                cnt++;
            }
            //2.
            if(st.length == cnt) {
                boolean flag = false;
                for (int j = 0; j < input.length(); j++) {
                    char c = input.toUpperCase().charAt(j);
                    if(c == ' ') continue;
                    // 왼쪽부터 차례대로 알파벳 보면서 단축키 지정
                    if (!alpha[c - 'A']) {
                        alpha[c - 'A'] = true;
                        flag = true;

                        String newString = input.substring(0, j);
                        newString += "[" + input.charAt(j) + "]";
                        newString += input.substring(j + 1, input.length());

                        sb.append(newString + "\n");
                        break;
                    }
                }// end for
                //안돼는건 그냥 넣어
                if(!flag) sb.append(input + "\n");
            }
        }
        System.out.println(sb);
    }
}