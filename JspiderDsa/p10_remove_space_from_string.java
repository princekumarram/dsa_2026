public class p10_remove_space_from_string {
    public static void main(String[] args) {
        String str = "hi           by         hello";

        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == ' ' && str.charAt(i + 1) == ' ')) {
                ans += str.charAt(i);
            }
        }

        System.out.println(ans);
    }
}
