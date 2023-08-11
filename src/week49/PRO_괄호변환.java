package week49;

import java.util.Stack;

/**
 * Time : 60m
 * Category : 구현
 * Description
 * 2020 KAKAO BLIND RECRUITMENT 괄호 변환 Lv2
 */
public class PRO_괄호변환 {
    public String solution(String p) {
        String answer = "";

        if(collectString(p)) return p;

        answer = func2(p);

        return answer;
    }
    public String func2(String w){
        //입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(w.equals("")) return w;

        //문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        int idx = func(w);
        String u = w.substring(0, idx);
        String v = w.substring(idx, w.length());
        //문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(collectString(u)){
            //수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + func2(v);
        }else{
            //빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            String newStr = "(";

            //문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            newStr += func2(v);

            //')'를 다시 붙입니다.
            newStr += ")";

            //u의 첫 번째와 마지막 문자를 제거하고,
            String temp = u.substring(1, u.length() - 1);

            //나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            for(char c : temp.toCharArray()){
                if(c == '('){
                    newStr += ")";
                }else{
                    newStr += "(";
                }
            }

            return newStr;
        }
    }
    //균형잡힌 괄호 문자열 체크
    public int func(String str){
        int left = 0;
        int right = 0;
        int idx = 0;
        for(char c : str.toCharArray()){
            if(c == '('){
                left++;
            }else{
                right++;
            }
            idx++;
            if(left == right) return idx;
        }
        return idx;
    }
    // 올바른 괄호 문자열 체크
    public boolean collectString(String str){
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(stack.peek() != '(') return false;

                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
