package leecode.math;

/**
 * ajunzhang
 * 2020/1/31 15:21
 **/
public class JudgeNumPalindrome {


    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome2(x));
    }

    public static boolean isPalindrome(int x) {
        String inputStr = String.valueOf(x);
        String reverseStr;
        char[] reverseCharArr = new char[inputStr.length()];
        for (int i = 0; i < inputStr.length(); i++) {
            reverseCharArr[inputStr.length() - 1 - i] = inputStr.charAt(i);
        }
        reverseStr = new String(reverseCharArr);
        return inputStr.equals(reverseStr);
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        boolean result = true;
        String inputStr = String.valueOf(x);
        for (int i = 0; i < inputStr.length() / 2; i++) {
            if (inputStr.charAt(i) != inputStr.charAt(inputStr.length() - 1 - i)) {
                result = false;
                break;
            }
        }
        return result;
    }

}
