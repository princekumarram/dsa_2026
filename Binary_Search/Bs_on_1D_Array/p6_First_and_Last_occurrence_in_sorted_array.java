
public class p6_First_and_Last_occurrence_in_sorted_array {

    // Brute Force
    static int[] getFirstandLastOccr(int arr[], int x) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == x) {
                if (first == -1) {
                    first = i;
                    last = i; // [1] first=0,last=0
                } else {
                    last = i;
                }
            }
        }

        return new int[] { first, last };
    }

    // Optimal
    static int[] getFirstandLastOccr2(int arr[], int x) {
        int result[] = { -1, -1 };
        int first = binarySearch(arr, x, true);
        int last = binarySearch(arr, x, false);

        result[0] = first;
        result[1] = last;
        return result;
    }

    static int binarySearch(int arr[], int x, boolean isSearchingList) {
        int low = 0;
        int high = arr.length - 1;
        int indx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                indx = mid;

                if (isSearchingList) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return indx;
    }

    public static void main(String[] args) {
        int x = 8;
        int arr[] = { 5, 7, 7, 8, 8, 10 };

        // int[] res = getFirstandLastOccr(arr, x);
        int[] res = getFirstandLastOccr(arr, x);
        System.out.println("The first and last occurence are: " + res[0] + " " + res[1]);

    }
}
