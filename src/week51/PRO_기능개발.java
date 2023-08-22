package week51;
import java.util.*;
public class PRO_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Job> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            Job job = new Job();
            job.progress = progresses[i];
            job.speed = speeds[i];

            queue.add(job);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            // 맨 처음 프로그램 빼
            Job job = queue.poll();
            boolean isDeployment = true;

            // 맨 처음 프로그램 배포 일자
            int day = (100 - job.progress) / job.speed;
            if((100 - job.progress) % job.speed != 0) day++;

            int deployment_count = 1;   // 배포 갯수
            int size = queue.size();    // 종료조건 플리스
            if(size == 0){
                list.add(deployment_count);
                break;
            }

            for(int s=0; s<size; s++){
                Job nextJob = queue.poll();

                int nextDay = (100 - nextJob.progress) / nextJob.speed;
                if((100 - nextJob.progress) % nextJob.speed != 0) nextDay++;

                if(nextDay <= day){ //같이 배포
                    if(isDeployment){
                        deployment_count++;
                    }else{
                        if(nextJob.progress < 100) nextJob.progress += day * nextJob.speed;
                        queue.add(nextJob); // 다음에 같이 배포합시다~
                    }
                }else{  // 같이 배포 못해요
                    isDeployment = false;
                    nextJob.progress += day * nextJob.speed;
                    queue.add(nextJob); // 다음에 배포합시다~
                }
            }
            //배포 몇개 가능하니??
            list.add(deployment_count);
        }
        answer = new int[list.size()];
        int idx=0;
        for(int num : list){
            answer[idx++] = num;
        }
        return answer;
    }
    class Job {
        int progress;
        int speed;
    }
}
