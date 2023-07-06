package week44;

/**
 * Time : 30m
 * Category : implement
 * Description
 * 쓸데없는 설명이 많은데 거기서 문제를 파악할 수 있어야 함
 * -> 처음에 입력을 무작위로 섞어야 한다?? => nPn => 시간초과
 * -> 입력은 무작위로 선택된 카드가 들어오는 것이였음.
 * -> 그룹 A를 선택한 다음 나머지 것으로 그룹 B 선택
 * 코드의 중복 -> 최적화 필요!!
 */
public class PRO_혼자놀기의달인 {
    int max;
    boolean flag;
    public int solution(int[] cards) {
        int answer = 0;

        max = 0;
        flag = false;
        //임의의 상자를 하나 선택
        for(int i=1; i<= cards.length; i++){
            picked = new boolean[cards.length];
            dfsA(cards[i-1], 0, cards);
        }
        answer = max;
        if(flag) answer = 0;
        return answer;
    }
    int cntA = 0;
    boolean[] picked;
    public void dfsA(int idx, int cnt, int[] cards){
        if(picked[idx-1]){  //이미 열려있는 상자
            if(cnt == cards.length){
                flag = true;
                return;
            }
            cntA = cnt;
            for(int i=1; i<= cards.length; i++){
                if(picked[i-1]) continue;
                dfsB(cards[i-1], 0, cards);
            }
            return;
        }
        picked[idx-1] = true;
        dfsA(cards[idx-1], cnt+1, cards);
    }
    public void dfsB(int idx, int cnt, int[] cards){
        if(picked[idx-1]){
            max = Math.max(max, cnt * cntA);
            return;
        }
        picked[idx-1] = true;
        dfsB(cards[idx-1], cnt+1, cards);
    }
}
