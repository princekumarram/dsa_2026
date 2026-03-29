import java.util.*;
class p6_Next_Greater_Element_2{

//Brute Force
    static int[] nextGreaterElements(int[] arr){
    
         int n = arr.length;

        // To store the next greater elements
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Traverse each element to find its next greater
        for (int i = 0; i < n; i++) {
            int currEle = arr[i];

            // Look ahead in circular manner
            for (int j = 1; j < n; j++) {
                int ind = (i + j) % n;

                if (arr[ind] > currEle) {
                    ans[i] = arr[ind];
                    break;
                }
            }
        }

        return ans;
    }
       public static void main(String[] args) {
        int[] arr = {5, 7, 1, 7, 6, 0};
 

        // Call function
        int[] ans = nextGreaterElements(arr);

        System.out.println("The next greater elements are: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
