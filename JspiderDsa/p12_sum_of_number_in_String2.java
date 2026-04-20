public class p12_sum_of_number_in_String2 {
    public static void main(String[] args) {
        String str = "Hello 100 hi 200 by 500";// 100+200+500=800
        int sum = 0;
        int num = 0;

        boolean isNumber = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
                isNumber = true;
            } else {
                if (isNumber) {
                    sum += num;
                    num = 0;
                    isNumber = false;
                }
            }
        }
        if (isNumber) {
            sum += num;
        }
        System.out.println(sum);
    }
}
