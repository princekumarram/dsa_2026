public class p11_Sum_of_Number_in_String {
    public static void main(String[] args) {
        String str = "329 Hell 303";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sum += (ch - 48);
            }
        }

        System.out.println(sum);
    }
}
