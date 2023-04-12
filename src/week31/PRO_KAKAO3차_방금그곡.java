package week31;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 가사 길이 재고
 * 2. 흘러 나온 시간 재고
 * 3. 흘러나온 가사 만들고
 * 4. 기억한 멜로디가 가사에 포함되어 있다면
 * 5. 조건 확인
 */
public class PRO_KAKAO3차_방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int max_time = 0;

        // 문자열 자르기
        for(String music : musicinfos){
            StringTokenizer st = new StringTokenizer(music, ",");

            String start_time = st.nextToken();
            String end_time = st.nextToken();
            String title = st.nextToken();
            String gasa = st.nextToken();

            //총 흘러나온 분 재기
            int total_minute = getTotal_minute(end_time) -getTotal_minute(start_time);

            // 가사 잇기
            StringBuilder sb = new StringBuilder();

            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i < gasa.length(); i++){
                // 그 다음 글자까지 확인
                if(i != gasa.length()-1 && gasa.charAt(i + 1) == '#'){
                    list.add(gasa.substring(i, i+2));
                    i++;
                    continue;
                }
                list.add(gasa.substring(i, i+1));
            }
            System.out.println(list.toString());
            for(int i=0; i<total_minute; i++){
                sb.append(list.get(i % list.size()));
            }
            System.out.println("gana : " + sb.toString());

            String total_gasa = sb.toString();
            for(int i=0; i<=total_gasa.length() - m.length(); i++){
                if(i != total_gasa.length() - m.length()){
                    //어 맞아?
                    if(m.equals(total_gasa.substring(i, i + m.length()))){
                        //근데 뒤에 음 확인해야대
                        if(total_gasa.charAt(i + m.length()) == '#'){
                            continue;
                        }
                        //제일 긴지 확인
                        if(max_time < total_minute){
                            max_time = total_minute;
                            answer = title;
                        }
                    }
                }else{
                    if(m.equals(total_gasa.substring(i, i + m.length()))){
                        //제일 긴지 확인
                        if(max_time < total_minute){
                            max_time = total_minute;
                            answer = title;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public int getTotal_minute(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));

        int total_minute = hour * 60 + minute;

        return total_minute;
    }
}
