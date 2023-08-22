package week51;

public class PRO_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[]{0, 0};

        // 노란색 카펫의 한변의 가로 길이를 완전 탐색
        for(int y=1; y<=yellow; y++){
            // 노란 카펫 높이 = (yellow 갯수 / 한변의 길이)
            if(yellow % y != 0) continue;
            int yellow_height = yellow / y;

            //갈색 카펫
            // brown = yellow 높이 * 2 + 노랑 한변의 길이 * 2 + 모서리(4)
            if(brown == (yellow_height * 2) + (y * 2) + 4){
                answer = new int[]{y + 2, yellow_height + 2};
            }
        }
        return answer;
    }
}
