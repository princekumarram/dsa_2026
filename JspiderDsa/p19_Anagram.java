public class p19_Anagram {

    static String sort(String str) {

        char arr[] = str.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        String op = new String(arr);
        return op;
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "eholl";

        String ans1 = sort(str1);
        String ans2 = sort(str2);

        boolean flag = true;
        for (int i = 0; i < ans1.length(); i++) {

            if (ans1.charAt(i) != ans2.charAt(i)) {
                System.out.println("Not Anagram");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Anagram");
        }
    }
}
