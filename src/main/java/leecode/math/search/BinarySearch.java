package leecode.math.search;

/**
 * ajunzhang
 * 2020/2/1 11:30
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;
        //int index = Arrays.binarySearch(nums, target);
        int index = search_recursion(nums, target, 0, nums.length - 1);
        System.out.println(index);
    }

    /**
     * 标准非递归二分搜索算法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 参考写的https://www.liwei.party/2019/06/19/leetcode-solution-new/search-insert-position/#toc-heading-2
     * 取右中位数二分模板，防止死循环。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            // right 不加1 取左中位数， right 加1取右中位数。 如下写法防止 left + right int 溢出。
            mid = left + (right + 1 - left) / 2;
            if (nums[mid] > target) {
                right = right - 1;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 递归二分搜索
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int search_recursion(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right + 1 - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search_recursion(nums, target, left, mid - 1);
        } else {
            return search_recursion(nums, target, mid + 1, right);
        }
    }
}
