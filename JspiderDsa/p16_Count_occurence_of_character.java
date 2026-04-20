public class p16_Count_occurence_of_character {
    public static void main(String[] args) {
        // Create an array to store counts for all 128 standard ASCII characters
        int arr[] = new int[128];
        String s = "hello";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println((char) (i) + " : " + arr[i]);
            }
        }
    }
}
