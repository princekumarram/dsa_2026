// Number which contain  atleast 1 zero

public class p3_check_Duck_Number {
    public static void main(String[] args) {
        int N = 4502;
        int rem = 0;
        int prod = 1;

        while (N != 0) {
            rem = N % 10;
            prod *= rem;
            N = N / 10;
        }
        System.out.println((prod == 0) ? "It is Duck Number" : "It is Not Duck Number");
    }
}
