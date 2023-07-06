package week44;

public class PRO_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        if(topping.length == 1) return 0;
        // 한군데씩 자르면서 => 투포인터
        // 3을 자르면 0, 1, 2 | 3, 4, 5, 6, 7
        int[] topA = new int[10001];
        int[] topB = new int[10001];

        int cntA = 1;
        int cntB = 0;

        // 초창기 = 1로 잘랐을 때
        for(int i=0; i<1; i++){
            topA[ topping[i] ]++;
        }
        for(int i=1; i<topping.length; i++){
            if(topB[ topping[i] ] == 0) cntB++; //새로운 토핑
            topB[ topping[i] ]++;
        }

        //시작
        for(int i=1; i<topping.length; i++){
            //B에서 토핑하나 줄이고
            if(topB[ topping[i] ] > 0){
                topB[ topping[i] ]--;

                if(topB[ topping[i] ] == 0){    //줄였을 때 0개면 --
                    cntB--;
                }
            }

            //A에서 토핑하나 늘린다.
            if(topA[ topping[i] ] == 0) cntA++;
            topA[ topping[i] ]++;

            if(cntA == cntB) answer++;
        }

        return answer;
    }
}
