package week30;

import java.util.ArrayList;
import java.util.HashMap;

public class PRO_KAKAO3차_압축 {
    HashMap<String, Integer> dict;
    int index;
    public int[] solution(String msg) {
        int[] answer = {};
        dict = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        for(int i=0; i<26; i++){
            char temp = (char)('A' + i);
            dict.put("" + temp, i+1);
        }

        index = 26;

        for(int i=0; i<msg.length(); i++){
            String temp = msg.substring(i, i+1);    //첫 글자 따기
            if(i == msg.length() - 1){
                list.add(dict.get(temp));
                break;
            }
            String temp1 = "" + temp;
            for(int j=i+1; j<msg.length(); j++){
                String temp2 = msg.substring(j, j+1);
                if(dict.get(temp1 + temp2) == null){
                    //사전에 없으므로 등록하고 그 전에거 출력
                    list.add(dict.get(temp1));
                    dict.put(temp1 + temp2, ++index);
                    temp1 += temp2;
                    i = --j;
                    break;
                }
                temp1 += temp2;
                if(j == msg.length() - 1){
                    list.add(dict.get(temp1));
                    i = j;
                    break;
                }
            }
        }
        answer = new int[list.size()];

        int i = 0;
        for(int value : list){
            answer[i++] = value;
        }

        return answer;
    }
}
