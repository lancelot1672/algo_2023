package week45;

public class PRO_k진수에서소수개수구하기 {
    //15:50 ~ 16:09
    public int solution(int n, int k) {
        int answer = 0;

        String a = parse(n,k);

        String[] arr = a.split("0");

        for(String s : arr){
            if(!s.equals("") && isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }
    public String parse(int n, int k){
        StringBuilder sb = new StringBuilder();

        while(n > k){
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);

        return sb.reverse().toString();
    }
    public boolean isPrime(long n){
        if(n == 1) return false;
        if(n == 2 || n == 3) return true;

        for(int i=2; i<= (int) Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
