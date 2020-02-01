package leecode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * ajunzhang
 * 2020/1/30 16:53
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abca";
        int result = lengthOfLongestSubstring2(s);
        System.out.println(result);
    }

    /**
     * 用map来存储不重复字符串的index信息
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> vectory = new HashMap<Integer, Integer>();
        int maxLength = 0;//记录不重复字符串最大长度
        int left = -1;//标记不重复字符串左边坐标
        for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i);//用ascall 值作为key, value 用字符串中的index
            int tempIndex = vectory.containsKey(charValue) ? vectory.get(charValue) : -1;
            left = left > tempIndex ? left : tempIndex;
            vectory.put(charValue, i);
            maxLength = maxLength > i - left ? maxLength : i - left;
        }
        return maxLength;
    }

    /**
     * 用数组模拟Map.主要思路为维护一个left变量表示不重复字符串的左坐标，右坐标天然就是字符所在字符串的索引值
     * 窗口从左往右移动，只需要判断所遍历的字符，是否已经被标记过了，也就是arr[charValue] != -1，如果发现标记了
     * 就要更新left,left值就取arr[charValue]的值。同时更新arr[charValue],以及判断maxLength值是否需要更新。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int[] vectory = new int[256];
        for (int i = 0; i < vectory.length; i++) {
            vectory[i] = -1;
        }
        int maxLength = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i);
            left = left > vectory[charValue] ? left : vectory[charValue];
            vectory[charValue] = i;
            maxLength = maxLength > i - left ? maxLength : i - left;
        }
        return maxLength;
    }
}
