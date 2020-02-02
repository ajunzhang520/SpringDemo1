package leecode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * ajunzhang
 * 2020/2/1 21:11
 **/
public class ZStringLoop {

    public static void main(String[] args) {

        String s = "ab";
        int num = 1;
        System.out.println(loopZStr(s, num));

    }

    public static String loopZStr(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> resultSBList = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            resultSBList.add(new StringBuilder());
        }

        boolean isGoingDown = false;// 标记是否是转折点
        int curRow = 0;
        for (char c : s.toCharArray()) {
            resultSBList.get(curRow).append(c);//把字符放到正确的行位置
            if (curRow == 0 || curRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            curRow += isGoingDown ? 1 : -1;//根据转折点标记位调整 行索引
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : resultSBList) {
            result.append(sb);
        }

        return result.toString();
    }
}
