package leecode.math;

/**
 * ajunzhang
 * 2020/1/31 10:18
 **/
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abba";
        String sub = longestPalindrome(s);
        System.out.println(sub);

    }

    /**
     * 找到字符串s 最大回文。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];//二维数组记录 arr[l][r] = true是回文
        int maxLeft = 0;// 最大回文左坐标
        int maxRigth = 0;// 最大回文右坐标
        int maxLength = 1;// 最大回文长度，每次检查到符合回文要对比是否更新为最大长度回文

        // 右坐标从1开始往右移动
        for (int r = 1; r < s.length(); r++) {
            // 右坐标移动一格，左坐标要把右坐标左边所有情况都遍历一次
            for (int l = r - 1; l >= 0; l--) {
                // 判断条件，什么样的情况满足回文：
                // 左坐标字符等于右坐标字符， 同时左坐标加1，右坐标减1也是回文。
                // r - l <= 2的含义是如果子字符串长度为 1或者2. 只要比较左坐标字符等于右坐标字符即可。
                // 无需检查左坐标加1右坐标减1是否为回文这种情况。
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || isPalindrome[l + 1][r - 1] == true)) {
                    isPalindrome[l][r] = true;// 一旦满足条件标记arr[l][r] = true
                    // 如果这个子字符串回文长度大于maxLength, 则更新如下三个标记位
                    if (maxLength < r - l + 1) {
                        maxLength = r - l + 1;
                        maxLeft = l;
                        maxRigth = r;
                    }
                }
            }
        }
        // 子字符串左闭右开，所以需要加1
        return s.substring(maxLeft, maxRigth + 1);
    }
}
