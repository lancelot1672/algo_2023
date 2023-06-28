package week43;
import java.util.Arrays;

/**
 * 시간 : 42m
 * 행, 열에 대한 이해가 살짝 부족
 * XOR 연산을 하기 위하여 Integer -> binary 메서드 익숙해져야 함
 */
public class PRO_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (d1, d2)->{
            //col번째 컬럼의 값을 기준으로 오름차순 정렬
            if(d1[col-1] > d2[col-1]){
                return 1;
            }else if(d1[col-1] < d2[col-1]){
                return -1;
            }else{
                return d2[0] - d1[0];
            }
        });

        // 3. 맨처음 bit
        int S_i = 0;
        for(int j=0; j<data[row_begin-1].length; j++){
            S_i += data[row_begin-1][j] % (row_begin);
        }
        String bitA = Integer.toBinaryString(S_i);
        row_begin++;

        for(int i = row_begin; i<=row_end; i++){
            S_i = 0;
            for(int j=0; j<data[i-1].length; j++){
                S_i += data[i-1][j] % (i);
            }
            String bitB = Integer.toBinaryString(S_i);

            //길이 맞추기
            String temp = "";
            for(int j=0; j<Math.abs(bitA.length() - bitB.length()); j++){
                temp += "0";
            }
            if(bitA.length() > bitB.length()){
                bitB = temp + bitB;
            }else{
                bitA = temp + bitA;
            }

            //XOR 연산
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<bitA.length(); j++){
                if(bitA.charAt(j) == bitB.charAt(j)) sb.append("0");
                else sb.append("1");
            }
            bitA = sb.toString();
        }

        //bitwise XOR
        answer = Integer.parseInt(bitA, 2);
        return answer;
    }
}
