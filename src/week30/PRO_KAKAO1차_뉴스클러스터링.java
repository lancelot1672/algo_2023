package week30;

import java.util.HashMap;

public class PRO_KAKAO1차_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        if(str1.equals(str2)){
            return 65536;
        }
        HashMap<String, Integer> dict1 = getDict(str1);
        HashMap<String, Integer> dict2 = getDict(str2);

        answer = dict1.size();

        float one = 0f;
        float two = 0f;
        for(String key : dict1.keySet()){
            //dict2에 존재한다면 1지우고 2지우고 교집합
            if(dict2.get(key) != null){
                int oneCount = dict1.get(key);
                int twoCount = dict2.get(key);

                one += Math.min(oneCount, twoCount);    //교집합
                two += Math.max(oneCount, twoCount);    //합집합
            }else{  // 1에만 있는듯? 합집합
                int oneCount = dict1.get(key);

                two += oneCount;
            }
        }
        for(String key : dict2.keySet()){
            if(dict1.get(key) == null){
                //남은 것 처리 - 합집합
                two += dict2.get(key);
            }
        }
        answer = (int)((one / two) * 65536.0);
        // System.out.println(one);
        // System.out.println(one);
        return answer;
    }
    public HashMap<String, Integer> getDict(String str){
        HashMap<String, Integer> dict = new HashMap<>();

        for(int i=0; i<str.length()-1; i++){
            String temp = str.substring(i,i+2);

            // 특수 문자는 제외
            if(temp.charAt(0) < 'A' || temp.charAt(0) > 'Z') continue;
            if(temp.charAt(1) < 'A' || temp.charAt(1) > 'Z') continue;
            if(dict.get(temp) == null){
                dict.put(temp, 1);
                continue;
            }else{
                int count = dict.get(temp);
                dict.put(temp, count+1);
            }
        }//end for

        return dict;
    }
}
