package week52;
import java.util.*;
/**
 * Time : 31m
 * Category : 구현
 * description : 냅다 구현..
 * 2020 카카오 인턴쉽 - 키패드 누르기
 */
public class PRO_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keyPad = new int[4][3];
        int[] leftLoc = new int[]{3, 0};
        int[] rightLoc = new int[]{3, 2};
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){  // 키패드 하나씩 누르자
            if(number == 1 || number == 4 || number == 7){
                //왼손 이동
                if(number == 1){
                    //손가락 이동
                    leftLoc[0] = 0;
                    leftLoc[1] = 0;
                }else if(number == 4){
                    //손가락 이동
                    leftLoc[0] = 1;
                    leftLoc[1] = 0;
                }else{
                    //손가락 이동
                    leftLoc[0] = 2;
                    leftLoc[1] = 0;
                }
                sb.append("L");
            }else if(number == 3 || number == 6 || number == 9){
                //오른손 이동
                if(number == 3){
                    //손가락 이동
                    rightLoc[0] = 0;
                    rightLoc[1] = 2;
                }else if(number == 6){
                    //손가락 이동
                    rightLoc[0] = 1;
                    rightLoc[1] = 2;
                }else{
                    //손가락 이동
                    rightLoc[0] = 2;
                    rightLoc[1] = 2;
                }
                sb.append("R");
            }else{
                //두 손가락 중 가까운 것으로 터치~
                sb.append(func(number, leftLoc, rightLoc, hand));
            }
        }
        answer = sb.toString();
        return answer;
    }
    public String func(int number, int[] leftLoc, int[] rightLoc, String hand){
        Map<Integer, int[]> map = new HashMap<>();
        map.put(2, new int[]{0, 1});
        map.put(5, new int[]{1, 1});
        map.put(8, new int[]{2, 1});
        map.put(0, new int[]{3, 1});

        //왼쪽 손가락과의 거리
        int leftDist = 0;

        //오른쪽 손가락과의 거리
        int rightDist = 0;

        switch(number){
            case 2: // 0 1
                leftDist = Math.abs(0 - leftLoc[0]) + Math.abs(1 - leftLoc[1]);
                rightDist = Math.abs(0 - rightLoc[0]) + Math.abs(1 - rightLoc[1]);
                break;
            case 5: // 1 1
                leftDist = Math.abs(1 - leftLoc[0]) + Math.abs(1 - leftLoc[1]);
                rightDist = Math.abs(1 - rightLoc[0]) + Math.abs(1 - rightLoc[1]);
                break;
            case 8: // 2 1
                leftDist = Math.abs(2 - leftLoc[0]) + Math.abs(1 - leftLoc[1]);
                rightDist = Math.abs(2 - rightLoc[0]) + Math.abs(1 - rightLoc[1]);
                break;
            case 0: // 3 1
                leftDist = Math.abs(3 - leftLoc[0]) + Math.abs(1 - leftLoc[1]);
                rightDist = Math.abs(3 - rightLoc[0]) + Math.abs(1 - rightLoc[1]);
                break;
        }
        String h = "";
        if(leftDist < rightDist){
            //왼손이 더 가깝다면
            func2(leftLoc, map.get(number));
            h = "L";
        }else if(leftDist > rightDist){
            //오른손이 더 가깝다면
            func2(rightLoc, map.get(number));
            h = "R";
        }else{
            //같다면 손잡이 비교
            if(hand.equals("left")){    //왼손 잡이
                func2(leftLoc, map.get(number));
                h = "L";
            }else{  //오른손 잡이
                func2(rightLoc, map.get(number));
                h = "R";
            }
        }

        return h;
    }
    // 손가락 옮기기
    public void func2(int[] finger, int[] destination){
        finger[0] = destination[0];
        finger[1] = destination[1];
    }
}
