package week36;

import java.util.*;
import java.io.*;

public class B9935_문자열폭발 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(input);

        while(true){
            //check
            String sentence = sb.toString();
            boolean isBomb = false;
            sb = new StringBuilder();
            for(int i=0; i<sentence.length() - bomb.length(); i++){
                String check = sentence.substring(i, bomb.length());
                if(bomb.equals(check)){
                    //중간에 비우고
                    sb.append(sentence.substring(0, i));
                    sb.append(sentence.substring(i+bomb.length(), sentence.length()));
                    isBomb = true;
                    break;
                }
            }//end for
            if(!isBomb) break;
        }
        System.out.println(sb.toString());
    }
}