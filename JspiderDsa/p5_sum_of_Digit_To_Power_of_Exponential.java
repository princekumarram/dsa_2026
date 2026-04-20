//1^3+5^3+3^3=1+125+27=153
public class p5_sum_of_Digit_To_Power_of_Exponential {

    static int power(int a, int b) {
        int pow = 1;
        for (int i = 1; i <= b; i++) {
            pow = pow * a;
        }
        return pow;
    }

    public static void main(String[] args) {
        int N = 1423, exp = 2;
        int rem = 0, sum = 0;

        while (N != 0) {
            rem = N % 10;
            sum = sum + power(rem, exp);
            N = N / 10;
        }

        System.out.println(sum);
    }
}
