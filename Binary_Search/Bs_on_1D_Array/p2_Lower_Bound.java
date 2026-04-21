
public class p2_Lower_Bound {
    // Brute Force
    static int lowerBound(int arr[], int x) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }

        return arr.length;
    }

    static int lowerBound2(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 15, 19 }; // Sorted array
        int x = 9; // Target value

        // int ind = lowerBound(arr, x); // Find lower bound
        int ind = lowerBound2(arr, x); // Find lower bound

        System.out.println("The lower bound is the index: " + ind); // Print result
    }
}
