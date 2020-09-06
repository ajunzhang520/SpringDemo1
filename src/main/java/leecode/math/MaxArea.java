package leecode.math;

/**
 * ajunzhang
 * 2020/4/3 20:22
 **/
public class MaxArea {

    public static void main(String[] args) {
        int[] inputArr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = calcMaxAreaTwoPoints(inputArr);
        System.out.println(maxArea);
    }

    private static int min(int x, int y) {
        if (x < y) {
            return x;
        }
        return y;
    }

    /**
     * 暴力破解法
     *
     * @param height
     * @return
     */
    private static int calcMaxArea(int[] height) {
        int[] inputArr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = 0;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                int tempArea = (j - i) * min(inputArr[i], inputArr[j]);
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }


    /**
     * 双指针，左右两边逼近中间。
     *
     * @param height
     * @return
     */
    private static int calcMaxAreaTwoPoints(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {

            int tempArea = (right - left) * min(height[left], height[right]);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            // 左边的高度小于右边的高度，左边指针向后移动一位
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;// 左边的高度大于右边的高度，右指针向前移动一位
            }
        }
        return maxArea;
    }
}
