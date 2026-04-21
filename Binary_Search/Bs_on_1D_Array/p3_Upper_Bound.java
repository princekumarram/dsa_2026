
public class p3_Upper_Bound {

    static int upperBound(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                return i;
            }
        }
        return arr.length;
    }

    static int upperBound2(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 15, 19 }; // Sorted array
        int x = 9;

        // int ind = upperBound(arr, x);
        int ind = upperBound2(arr, x);

        System.out.println("The upper bound is the index: " + ind); // Output result
    }
}
