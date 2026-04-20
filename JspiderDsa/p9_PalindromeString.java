public class p9_PalindromeString {
    static boolean isPalindrome(String str) {
        int i = 0;
        int n = str.length() - 1;

        while (i < n) {
            if (str.charAt(i) != str.charAt(n)) {
                return false;
            }
            i++;
            n--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "level";
        System.out.println(isPalindrome(str) ? "Palindrome" : "Not Palindrome");

    }
}
