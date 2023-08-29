package week52;
import java.util.*;
public class PRO_파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer = {};

        File[] fArr = new File[files.length];
        int ii = 0;
//        PriorityQueue<File> pq = new PriorityQueue<>((f1, f2)->{
//
//            if(f1.head.compareTo(f2.head) == 0){
//                return f1.number - f2.number;    //오름 차순
//            }
//
//            return f1.head.compareTo(f2.head);
//        });
        for(String file : files){ // 파일 하나하나 ㄱㄱ
            //HEAD 따기
            int idx = 0;
            for(int i=0; i<file.length(); i++){
                if(file.charAt(i) >= '0' && file.charAt(i) <= '9'){
                    idx = i;
                    break;
                }
            }
            String head = file.substring(0, idx).toUpperCase();

            int idx2 = file.length();
            //NUMBER 따기
            for(int i=idx; i<file.length(); i++){
                if(i - idx > 5){
                    idx2 = i - 1;
                    break;
                }
                if(file.charAt(i) < '0' || file.charAt(i) > '9'){
                    idx2 = i;
                    break;
                }
            }
            String number = file.substring(idx, idx2);

            String tail = file.substring(idx2, file.length());

            File f = new File();
            f.filename = file;
            f.head = head;
            f.number = Integer.parseInt(number);
            f.tail = tail;

            fArr[ii++] = f;
        }
        Arrays.sort(fArr, (f1, f2)->{
            if(f1.head.compareTo(f2.head) == 0){
                return f1.number - f2.number;    //오름 차순
            }

            return f1.head.compareTo(f2.head);
        });
        answer = new String[files.length];
        ii = 0;
        for(File f : fArr){
            answer[ii++] = f.filename;
        }
        return answer;
    }
    class File{
        String filename;
        String head;
        int number;
        String tail;
    }
}
