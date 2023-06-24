package week42;

public class PRO_둘만의암호 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean[] alpha = new boolean[26];

        // skip 해야하는 alpha는 true
        for(char c : skip.toCharArray()){
            alpha[ c - 'a'] = true;
        }

        // 각 알파벳을 index만큼 보낸다
        for(char c : s.toCharArray()){
            int tmpIndex = 0;
            int skipIndex = 0;

            int cnt = 1;    // index만큼 뒤로 보내는데
            while(true){
                tmpIndex = (c - 'a') + cnt + skipIndex;
                while(tmpIndex >= 26) tmpIndex -= 26;

                if(alpha[tmpIndex]){
                    skipIndex++;
                    cnt--;    // skip 부분에서는 카운트 안셈
                }

                cnt++;

                if(cnt > index){
                    sb.append((char)('a' + tmpIndex));
                    break;
                }
            }
        }

        return sb.toString();
    }
}
