package week33;

import java.util.*;
import java.io.*;

/**
 * 백준 3758번
 * 33m 40s
 */
public class B3758_KCPC {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    //TC
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());    // 팀 갯수
            int k = Integer.parseInt(st.nextToken());    // 문제 갯수
            int t = Integer.parseInt(st.nextToken());    // 내 팀 ID
            int m = Integer.parseInt(st.nextToken());    // 로그 갯수

            Team[] teams = new Team[n];
            //팀 초기화
            for(int a = 0; a<n; a++){
                teams[a] = new Team(a+1, k);
            }

            //로그 엔트리 갯수만큼
            for(int p=0; p<m; p++){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());    // 팀 ID
                int j = Integer.parseInt(st.nextToken());    // 문제 번호
                int s = Integer.parseInt(st.nextToken());    // 획득한 점수

                int score = teams[i-1].problem[j-1];

                if(score < s){
                    teams[i-1].problem[j-1] = s;  //최고 점수
                    teams[i-1].totalScore += (s - score);    //차 점수 더하기
                }
                teams[i-1].submitCount++;    // 제출 기록 증가
                teams[i-1].lastSubmitTime = p+1;    // 마지막 제출 시간
            }

            //정렬
            PriorityQueue<Team> pq = new PriorityQueue<>((t1, t2) ->{
                int t1Score = t1.totalScore;
                int t2Score = t2.totalScore;

                if(t1Score < t2Score){
                    return 1;
                }else if(t1Score > t2Score){
                    return -1;
                }else{
                    //최종 점수가 같은 경우
                    int t1Count = t1.submitCount;
                    int t2Count = t2.submitCount;
                    if(t1Count > t2Count){
                        return 1;
                    }else if(t1Count < t2Count){
                        return -1;
                    }else{
                        //최종 점수도 같고 제출 횟수도 같은 경우
                        int t1Time = t1.lastSubmitTime;
                        int t2Time = t2.lastSubmitTime;
                        return t1Time - t2Time;
                    }
                }
            });
            for(Team team : teams){
                pq.add(team);
            }
            int index = 1;
            while(!pq.isEmpty()){
                Team team = pq.poll();

                if(team.teamId == t){
                    sb.append(index + "\n");
                    break;
                }
                index++;
            }//end While
        }//end for
        System.out.println(sb.toString());
    }
    static class Team{
        int teamId;
        int totalScore = 0;
        int submitCount = 0;
        int lastSubmitTime = 0;
        int[] problem;

        public Team(int teamId, int k){
            this.teamId = teamId;
            this.problem = new int[k];
        }
    }
}