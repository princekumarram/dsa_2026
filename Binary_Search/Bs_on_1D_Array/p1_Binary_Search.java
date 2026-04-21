
public class p1_Binary_Search {

    static int binarySearch(int arr[], int target) {
        int n = arr.length; // size of the array
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int binarySearch2(int arr[], int target) {
        return binarySearchRecursion(arr, 0, arr.length - 1, target);
    }

    static int binarySearchRecursion(int arr[], int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (target > arr[mid]) {
            return binarySearchRecursion(arr, mid + 1, high, target);
        }
        return binarySearchRecursion(arr, low, mid - 1, target);

    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 }; // sorted array
        int target = 6; // target element to search

        // int ind = binarySearch(a, target);
        int ind = binarySearch2(a, target);

        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}
