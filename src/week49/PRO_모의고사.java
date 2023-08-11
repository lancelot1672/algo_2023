package week49;

public class PRO_모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] n1 = new int[]{1,2,3,4,5};
        int[] n2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] n3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        int index = 0;
        for(int a : answers){
            if(n1[index % 5] == a) score[0]++;
            if(n2[index % 8] == a) score[1]++;
            if(n3[index % 10] == a) score[2]++;
            index++;
        }
        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        int len = 0;
        for(int i=0; i<3; i++){
            if(score[i] == max) len++;
        }
        answer = new int[len];

        int idx = 0;
        for(int i=0; i<3; i++){
            if(score[i] == max) answer[idx++] = i+1;
        }
        return answer;
    }
}
