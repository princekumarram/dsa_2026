public class p7_Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int n1 = 0, n2 = 1, sum = 0;

        int i = 0;
        while (i < n) {
            System.out.println(n1 + " ");
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            i++;
        }
    }
}
