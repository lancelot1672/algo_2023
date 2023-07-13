package week45;
import java.util.*;

/**
 * Time : 50m
 * Category : implements
 *
 */
public class PRO_주차요금계산 {
    //14:00
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> timeMap = new HashMap<>();  // 누적 주차 시간
        Map<String, Integer> parking = new HashMap<>();

        //시각으로 정렬
        Arrays.sort(records, (r1, r2) -> r1.substring(0,5).compareTo(r2.substring(0,5)));

        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String[] timeStr = st.nextToken().split(":");
            int minute = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

            //차량 번호
            String carNum = st.nextToken();

            //입출차 내역
            String order = st.nextToken();

            if(order.equals("IN")){
                parking.put(carNum, minute);
            }else{  // 출차 오더
                int inTime = parking.get(carNum);
                parking.put(carNum, null);
                int outTime = minute;

                //기존의 시간이 있다면 더해야함
                if(timeMap.get(carNum) != null){
                    timeMap.put(carNum, timeMap.get(carNum) + (outTime - inTime));
                }else{
                    timeMap.put(carNum, outTime - inTime);
                }
            }
        }
        //23:59 이후 출차 내역이 없는 경우
        for(String carNum : parking.keySet()){
            if(parking.get(carNum) != null){
                int inTime = parking.get(carNum);
                int outTime = 23 * 60 + 59;

                //기존의 시간이 있다면 더해야함
                if(timeMap.get(carNum) != null){
                    timeMap.put(carNum, timeMap.get(carNum) + (outTime - inTime));
                }else{
                    timeMap.put(carNum, outTime - inTime);
                }
            }
        }
        PriorityQueue<Car> pq = new PriorityQueue<>((c1, c2) -> c1.carNum.compareTo(c2.carNum));
        for(String carNum : timeMap.keySet()){
            int totalMinute = timeMap.get(carNum);
            System.out.println("carNum : " + carNum + ", tm : " + totalMinute);
            int fee = cacul(fees, totalMinute);
            System.out.println("fee : " + fee);
            pq.add(new Car(carNum, fee));
        }
        answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll().fee;
        }
        return answer;
    }
    public int cacul(int[] fees, int totalMinute){
        if(totalMinute <= fees[0]) return fees[1];   //기본 요금

        // fee[1] + [ a = (tm - fee[0]) / 10 ] * fee[3]
        double a = ((double)totalMinute - (double)fees[0]) / (double) fees[2];

        int b = 0;
        if(a % 1.0 != 0){
            b = (int) a + 1;
        }else{
            b = (int) a;
        }

        return fees[1] + b * fees[3];
    }
}
class Car {
    String carNum;
    int fee;

    public Car(String carNum, int fee){
        this.carNum = carNum;
        this.fee = fee;
    }
}
