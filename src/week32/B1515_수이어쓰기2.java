package week32;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1515_수이어쓰기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int idx = 1;

        int step = 0;
        while(true){
            StringBuilder sb = new StringBuilder();
            char[] cArr = sb.append(idx).toString().toCharArray();

            for(int i=0; i<cArr.length; i++){
                if(cArr[i] == input.charAt(step)){
                    step++;
                    if(step == input.length()){
                        System.out.println(idx);
                        return;
                    }
                }
            }
            idx++;
        }

    }
}
