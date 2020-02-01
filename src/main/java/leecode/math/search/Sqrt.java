package leecode.math.search;

/**
 * ajunzhang
 * 2020/2/1 16:35
 **/
public class Sqrt {

    public static void main(String[] args) {

        int x = 21;
        int result = sqrtMethod(x);
        System.out.println(result);

    }

    public static int sqrtMethod(int x) {
        if (x <= 0) {
            return 0;
        }

        long temp_x = (long) x;
        long left = 1;
        long right = x / 2;

        while (left < right) {
            // 取右中位数保证不会陷入死循环
            long mid = left + (right + 1 - left) / 2;
            if (mid * mid > temp_x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
