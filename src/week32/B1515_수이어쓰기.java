package week32;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1515_수이어쓰기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int len = 0;
        int number = 1;
        while(len <= 3000){
            String str = number++ + "";
            len += str.length();

            sb.append(str + ",");
        }

        String str = sb.toString();
        int index=0;
        for(int i=0; i<=str.length(); i++){
            if(str.charAt(i) == ',') continue;

            if(str.charAt(i) == input.charAt(index)){
                index++;
                if(index == input.length()){
                    // start end 찾기
                    int start = 0;
                    int end = 0;

                    for(int s = i; s >= 0; s--){
                        if(str.charAt(s) == ','){
                            start = s;
                            break;
                        }
                    }
                    for(int e = i; e < str.length(); e++){
                        if(str.charAt(e) == ','){
                            end = e;
                            break;
                        }
                    }
                    System.out.println(str.substring(start+1, end));
                    break;
                }
            }
        }
    }
}
