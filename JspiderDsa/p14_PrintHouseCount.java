public class p14_PrintHouseCount {
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int target = 15;
        int n = 8;

        int arr[] = { 12, 7, 5, 2, 2, 7, 13, 23 };
        int sum = 0, countHouses = 0;

        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) {
                sum += arr[i];
                countHouses++;
                if (sum >= target) {
                    System.out.println(countHouses);
                    return;
                }
            }
        }
    }
}
