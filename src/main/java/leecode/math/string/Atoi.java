package leecode.math.string;

/**
 * ajunzhang
 * 2020/2/2 18:57
 **/
public class Atoi {
    public static void main(String[] args) {
        String str = " 1 1-+1";
        int result = myAtoi2(str);
        System.out.println(result);
    }


    public static int myAtoi2(String str) {
        int len = str.length();

        // 去除前导空格
        int index = 0;
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }

        if (index == len) {
            return 0;
        }

        // 第 1 个字符如果是符号，判断合法性，并记录正负
        int sign = 1;
        char firstChar = str.charAt(index);
        if (firstChar == '+') {
            index++;
            sign = 1;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = str.charAt(index);
            // 判断合法性
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;

    }


    public static int myAtoi(String str) {
        char[] charArr = str.toCharArray();
        final char space = ' ';
        final char negativeChar = '-';
        final char positiveChar = '+';
        boolean setSymbol = false;
        final char point = '.';

        int symbol = 1;
        StringBuilder resultStr = new StringBuilder();
        boolean isWord = false;

        for (char c : charArr) {
            if (c == space) {
                continue;
            }

            if (c == negativeChar && resultStr.length() == 0 && setSymbol == false) {
                symbol = -1;
                setSymbol = true;
                continue;
            }

            if (c == positiveChar && resultStr.length() == 0 && setSymbol == false) {
                symbol = 1;
                setSymbol = true;
                continue;
            }

            if (resultStr.length() == 0 && !((c >= '0' && c <= '9') || c == space)) {
                isWord = true;
                break;
            }

            if (resultStr.length() != 0 && ((c >= '0' && c <= '9') || c == space)) {
                break;
            }


            if (c >= '0' && c <= '9') {
                resultStr.append(c);
            }

            if (c == point) {
                break;
            }
        }

        if (isWord) {
            return 0;
        }

        long result = 0;
        int len = resultStr.toString().length();
        for (int i = len - 1; i >= 0; i--) {
            result += Math.pow(10, len - 1 - i) * ((int) resultStr.toString().charAt(i) - 48);
        }

        if (symbol * result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (symbol * result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) (symbol * result);
    }
}
