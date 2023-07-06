package week44;

public class DivisorCountCalculator {
    public static int countDivisors(int number) {
        if (number == 2) {
            return 2;
        }

        int count = 0;
        int sqrt = (int) Math.sqrt(number);

        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                count += 2;
            }
            if(sqrt * sqrt == number) count--;
        }

        return count;
    }

    public static void main(String[] args) {
        int number = 6;
        int divisorCount = countDivisors(number);

        System.out.println("약수의 개수: " + divisorCount);
    }
}
