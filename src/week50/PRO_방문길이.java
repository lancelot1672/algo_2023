package week50;

import java.util.HashSet;
import java.util.Set;

public class PRO_방문길이 {
    int visitCnt;
    Set<String> set;
    public int solution(String dirs) {
        int answer = 0;

        visitCnt = 0;
        set = new HashSet<>();
        dfs(0, dirs, new int[]{5, 5});

        answer = visitCnt;

        return answer;
    }
    public void dfs(int idx, String dirs, int[] now){
        if(idx == dirs.length()){
            return;
        }

        int nexti = now[0] + di[getDir(dirs.charAt(idx))];
        int nextj = now[1] + dj[getDir(dirs.charAt(idx))];

        if(nexti < 0 || nexti >= 11 || nextj < 0 || nextj >= 11){
            //범위를 넘어간다면 가만히
            dfs(idx+1, dirs, now);
        }else{
            String from = "" + now[0] + "" + now[1];
            String to = "" + nexti + "" + nextj;

            if(set.add(from+to) && set.add(to+from)){
                visitCnt++;
            }
            dfs(idx+1, dirs, new int[]{nexti, nextj});
        }

    }
    int[] di = new int[]{1, -1, 0, 0};
    int[] dj = new int[]{0, 0, -1, 1};
    public int getDir(char d){
        switch(d){
            case 'D':
                return 0;
            case 'U':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }

        return -1;
    }
}
