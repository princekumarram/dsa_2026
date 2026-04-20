//HACKER RANK

public class p13_EvenWordReverse {

    static String revstr(String str) {
        String rev = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            rev = ch + rev;

        }
        return rev;
    }

    public static void main(String[] args) {
        String str = "hello hi bye welcome";

        String[] arr = str.split(" ");
        String ans = "";

        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 == 0) {
                ans = ans + revstr(arr[i]);
            } else {
                ans = ans + arr[i];
            }
            if (i < arr.length - 1) {
                ans = ans + " ";
            }
        }

        System.out.println(ans);
    }
}
