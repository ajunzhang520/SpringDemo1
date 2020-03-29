package leecode.math.string;

/**
 * ajunzhang
 * 2020/2/2 18:57
 **/
public class Atoi {
    public static void main(String[] args) {
        String str = " 1 1-+1";
        int result = myAtoi(str);
        System.out.println(result);
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
