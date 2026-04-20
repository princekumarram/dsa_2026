public class p6_Armstrong_Number {

    static int getCount(int n) {
        int rem = 0, cnt = 0;
        while (n != 0) {
            n = n / 10;
            cnt++;
        }
        return cnt;
    }

    static int getPower(int base, int exp) {
        int pow = 1;
        for (int i = 1; i <= exp; i++) {
            pow = pow * base;
        }
        return pow;
    }

    public static void main(String[] args) {
        int N = 153;
        int orgN = N;
        int count = getCount(N);
        int rem = 0, sum = 0;

        while (N != 0) {
            rem = N % 10;
            sum = sum + getPower(rem, count);
            N = N / 10;
        }

        System.out.println((orgN == sum) ? "It is Armstrong Number" : "It is Not Armstrong Number");
    }
}
