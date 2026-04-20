import java.util.Arrays;

public class p15_Sort_the_String {
    public static void main(String[] args) {
        String str = "nsbda";

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

        // Arrays.sort(charArray);

        // Convert back to string
        String sortedString = new String(arr);

        System.out.println("Original: " + str);
        System.out.println("Sorted: " + sortedString);

    }
}
