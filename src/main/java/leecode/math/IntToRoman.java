package leecode.math;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ajunzhang
 * 2020/4/6 10:11
 **/
public class IntToRoman {

    public static void main(String[] args) {
        IntToRoman roman = new IntToRoman();
        String romanStr = roman.intToRoman(99);
        System.out.println(romanStr);

    }

    public String intToRoman(int num) {
        Map<Integer, String> map = initRomaMap();
        StringBuilder romanStr = new StringBuilder();

        final int[] numArr = {num};
        map.forEach((key, value) -> {
            System.out.println("tempNum=" + numArr[0] + " key=" + key + " value=" + value);
            while (numArr[0] >= key) {
                romanStr.append(value);
                numArr[0] -= key;
            }
        });
        return romanStr.toString();
    }


    /**
     * ls=[(1000,'M'),(900,'CM'),(500,'D'),(400,'CD'),(100,'C'),
     * (90,'XC'),(50,'L'),(40,'XL'),(10,'X'),(9,'IX'),(5,'V'),
     * (4,'IV'),(1,'I')]
     *
     * @return
     */
    private Map initRomaMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        return map;
    }

}
