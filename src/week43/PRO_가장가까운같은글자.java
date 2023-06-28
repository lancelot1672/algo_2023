package week43;

public class PRO_가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] alpha = new int[26];
        int idx = 1;
        for(char c : s.toCharArray()){
            if(alpha[c - 'a'] == 0){
                answer[idx-1] = -1;
            }else{
                answer[idx-1] = idx - alpha[c - 'a'];
            }
            alpha[c - 'a'] = idx;   //인덱스 표시

            idx++;
        }
        return answer;
    }
}
