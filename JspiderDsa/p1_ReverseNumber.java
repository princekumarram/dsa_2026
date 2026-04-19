
public class p1_ReverseNumber {
    public static void main(String[] args) {
        int n = 5637;
        int orgN = n;
        int rev = 0;
        while (n != 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;

        }

        System.out.println("Revers number of " + orgN + " is : " + rev);

    }
}
