//! ## all alphabet should be available in the string

public class p17_Managram {
    public static void main(String[] args) {
        // String s = "Hello hi by how are you";
        String s = "abcde fghijklmn opqrs tuvwxyz";
        String str = s.toUpperCase();

        int[] arr = new int[128];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            arr[ch]++;
        }

        boolean flag = true;

        for (int i = 65; i <= 90; i++) {
            if (arr[i] == 0) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "Managram" : "Not Managram");
    }
}
