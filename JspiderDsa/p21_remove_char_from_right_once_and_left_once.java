public class p21_remove_char_from_right_once_and_left_once {
    public static void main(String[] args) {
        String str = "JSPIDERS";
        int l = 0, h = str.length() - 1;

        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                h--;
            } else {
                l++;
            }
            String temp = "";
            for (int j = l; j <= h; j++) {
                temp = temp + str.charAt(j);
            }
            System.out.println(temp);
        }

    }
}