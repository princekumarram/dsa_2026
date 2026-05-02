
public class p1_Pow_x_n {
    // Brute Force
    public static double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0 || x == 1.0)
            return 1;

        long temp = n; // to avoid integer overflow

        // Handle negative exponents
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1;

        for (long i = 0; i < temp; i++) {
            // Multiply ans by x for n times
            ans *= x;
        }
        return ans;
    }

    // Recursion
    static double myPower(double x, int n) {
        if (n == 0)
            return 1;

        long N = n;

        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        if (N % 2 == 0) {
            return myPower(x * x, (int) (N / 2));
        } else {
            return x * myPower(x, (int) (N - 1));
        }
    }

    public static void main(String[] args) {

        System.out.println(myPow(2.00000, 5));
        System.out.println(myPow(2.00000, -2));

        System.out.println(myPower(2.00000, 5));
        System.out.println(myPower(2.00000, -2));
    }
}
