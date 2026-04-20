public class p8_count_vowel_in_String {
    public static void main(String[] args) {
        String str = "Hello";
        str = str.toUpperCase();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
