package week41;

import java.util.Arrays;

public class PRO_대충만든자판 {
    /*
        HashMap을 하나 만들어서 최소로 눌러야 하는 카운트를 저장, 갱신하면 됨.
        문자가 들어왔을 때 map에서 검사해서 몇번 누르면 되는지 파악
    */
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[ targets.length];

        int[] map = new int[26];
        Arrays.fill(map, 101);
        for(String key : keymap){
            char[] cArr = key.toCharArray();
            for(int i=0; i<cArr.length; i++){
                //최소 횟수 갱신, i + 1은 몇 번 눌러야 나오는지
                if(map[ cArr[i] - 'A' ] > i + 1){
                    map[ cArr[i] - 'A' ] = i + 1;
                }
            }
        }
        int idx=0;
        for(String target : targets){
            int cnt = 0;
            for(char c : target.toCharArray()){
                //못 만드는 경우 존재
                if(map[ c - 'A'] == 101){
                    cnt = -1;
                    break;
                }
                cnt += map [ c - 'A'];
            }
            answer[idx++] = cnt;
        }
        return answer;
    }
}
