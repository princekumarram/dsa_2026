//sum and product digit should be same

public class p2_check_Spy_Number {
    public static void main(String[] args) {
        int N = 1421;
        int sum = 0;
        int prod = 1;
        int rev = 0;

        while (N != 0) {
            rev = N % 10;
            sum += rev;
            prod *= rev;
            N = N / 10;
        }

        System.out.println((prod == sum) ? "It is Spy Number" : "It is Not Spy Number");

    }
}
