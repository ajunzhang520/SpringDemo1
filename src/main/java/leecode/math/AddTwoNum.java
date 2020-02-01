package leecode.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ajunzhang
 * 2020/1/10 20:57
 **/
public class AddTwoNum {
    public static void main(String[] args) {

        int[] nums = {1, 6, 4, 4, 5, 6};
        int target = 12;

        int[] result = twosummap(nums, target);
        if (result == null) {
            return;
        } else {
            System.out.println(Arrays.toString(result));
        }


    }

    // key 放值，key放下标
    public static int[] twosummap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int fist, second;

        for (int i = 0; i < nums.length; i++) {
            fist = nums[i];
            second = target - fist;
            if (map.containsKey(second)) {
                result[0] = i;
                result[1] = map.get(second);
                return result;
            }

            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int fistNum = 0;
        int secondNum = 0;
        // 遍历数组，用结果减去遍历的值。再去找第二个值。找到就返回。
        for (int i = 0; i < nums.length - 1; i++) {
            fistNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                secondNum = nums[j];
                if (fistNum + secondNum == target) {
                    result[0] = fistNum;
                    result[1] = secondNum;
                    return result;
                }
            }

        }

        return null;
    }
}
