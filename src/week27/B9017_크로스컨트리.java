package week27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B9017_크로스컨트리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            Team[] team = new Team[201];    // 팀 선수 수
            for(int i=1; i<=200; i++){
                team[i] = new Team(i);
            }
            int[] people = new int[201];
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<input.length; i++){
                int num = Integer.parseInt(input[i]);
                people[num]++;
                q.add(num);
            }
            int score = 1;
            while(!q.isEmpty()){
                int teamNum = q.poll();
                if(people[teamNum] != 6) continue;

                team[teamNum].scores[team[teamNum].clearCount] = score;
                if(team[teamNum].clearCount < 4){
                    //4명까지 점수 세기
                    team[teamNum].totalScore += score;
                }
                team[teamNum].clearCount++; // 들어온 사람 횟수
                score++;    //점수 올리기
            }
            PriorityQueue<Team> pq = new PriorityQueue<>();
            for(int i=1; i<=200; i++){
                if(team[i].clearCount != 6) continue;
                pq.add(team[i]);
            }
            System.out.println(pq.poll().num);
        }//end TC
    }
    static class Team implements Comparable<Team>{
        int num;
        int clearCount = 0;
        int[] scores = new int[6];
        int totalScore = 0;
        public Team(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Team o) {
            if(this.totalScore > o.totalScore){
                return 1;
            }else if(this.totalScore < o.totalScore){
                return -1;
            }else{
                return this.scores[4] - o.scores[4];
            }
        }
    }
}
