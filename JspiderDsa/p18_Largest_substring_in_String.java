public class p18_Largest_substring_in_String {
    public static void main(String[] args) {
        String s = "hi hello welcome bye";
        String[] arr = s.split(" ");
        int max = 0;
        String ans = "";

        for (String ele : arr) {
            if (max < ele.length()) {
                max = ele.length();
                ans = ele;
            }
        }

        System.out.println(ans);
    }
}
