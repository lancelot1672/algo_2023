package week50;
/**
 * Time : 60m
 * Category : 문자열
 * Description
 * Summer/Winter Coding(~2018)
 */
public class PRO_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        boolean[] alpha = new boolean[26];
        int[] learnIdx = new int[26];


        for(char c : skill.toCharArray()){
            alpha[c - 'A'] = true;
        }
        char firstSkill = skill.charAt(0);

        for(int i=1; i<skill.length(); i++){
            learnIdx[skill.charAt(i) - 'A'] = (skill.charAt(i-1) - 'A');
        }


        for(String skill_tree : skill_trees){
            boolean[] isLearn = new boolean[26];
            if(func(alpha, isLearn, learnIdx, skill_tree, firstSkill)){
                answer++;
            }
        }


        return answer;
    }
    public boolean func(boolean[] alpha, boolean[] isLearn, int[] learnIdx, String skill_tree, char firstSkill){
        for(int i=0; i<skill_tree.length(); i++){
            char c = skill_tree.charAt(i);

            if(!alpha[c - 'A']) continue;

            if(c == firstSkill){
                isLearn[c - 'A'] = true;
                learnIdx[c - 'A'] = (c - 'A');
            }
            if(!isLearn[learnIdx[c - 'A']]){
                return false;
            }

            isLearn[c - 'A'] = true;
        }
        return true;
    }
}
