public class p20_subsequence_palindromic_substring {

    static boolean isPalindrome(String s) {
        int i = 0;
        int n = s.length() - 1;
        while (i <= n) {
            if (s.charAt(i) != s.charAt(n)) {
                return false;
            }
            i++;
            n--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "abzbc";

        for (int i = 0; i < str.length(); i++) {
            String temp = "" + str.charAt(i);

            for (int j = i + 1; j < str.length(); j++) {
                temp = temp + str.charAt(j);

                if (isPalindrome(temp)) {

                    System.out.println(temp);
                }

            }
        }
    }
}
