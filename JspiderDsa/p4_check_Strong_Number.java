//sum of factorial of each digit is same as the number
public class p4_check_Strong_Number {
    static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;

        }
        return fact;
    }

    public static void main(String[] args) {
        int N = 145;
        int orgN = N;
        int rem = 0, sum = 0, factN = 0;

        while (N != 0) {
            rem = N % 10;

            factN = factorial(rem);
            sum += factN;
            N = N / 10;
        }
        System.out.println((sum == orgN) ? "It is Strong Number" : "It is Not Strong Number");
    }
}
