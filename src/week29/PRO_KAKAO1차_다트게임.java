package week29;

public class PRO_KAKAO1차_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;

        char[] charArr = dartResult.toCharArray();

        int[] dartArr = new int[3];
        String[] operArr = new String[3];
        int dartIndex = 0;
        int operIndex = 0;
        String num = "";
        String oper = "";

        for(int i=0; i<charArr.length; i++){
            if(charArr[i] >= '0' && charArr[i] <= '9'){
                if(!oper.equals("")){
                    operArr[operIndex++] = oper;
                    oper = "";
                }

                num += charArr[i];
            }else{  // 문자면
                if(!num.equals("")){
                    dartArr[dartIndex++] = Integer.parseInt(num);
                    num = "";
                }
                oper += charArr[i];
            }
            if(i == charArr.length-1){
                operArr[operIndex] = oper;
            }
        }
        for(int i=0; i<3; i++){
            int score = dartArr[i];
            if(operArr[i].charAt(0) == 'D'){
                dartArr[i] = (int) Math.pow(score, 2);

            }else if(operArr[i].charAt(0) == 'T'){
                dartArr[i] = (int) Math.pow(score, 3);
            }else if(operArr[i].charAt(0) == 'S'){
                dartArr[i] = score;
            }

            if(operArr[i].length() == 2){   //옵션 있을 때
                if(operArr[i].charAt(1) == '#'){    // 아차...상
                    dartArr[i] *= -1;
                    continue;
                }
                if(i == 0){
                    dartArr[i] *= 2;
                }else{
                    dartArr[i-1] *= 2;
                    dartArr[i] *= 2;
                }
            }
        }
        answer = dartArr[0] + dartArr[1] + dartArr[2];
        return answer;
    }
}
