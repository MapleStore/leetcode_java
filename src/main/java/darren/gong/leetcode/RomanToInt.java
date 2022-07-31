package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    private static Map<String, Integer> table = new HashMap<>();
    static {
        table.put("I", 1);
        table.put("IV", 4);
        table.put("V", 5);
        table.put("IX", 9);
        table.put("X", 10);
        table.put("XL", 40);
        table.put("L", 50);
        table.put("XC", 90);
        table.put("C", 100);
        table.put("CD", 400);
        table.put("D", 500);
        table.put("CM", 900);
        table.put("M", 1000);
    }
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length();) {
            if (i+2 <= s.length() && table.containsKey(s.substring(i, i+2))) {
                String subString = s.substring(i, i+2);
                result += table.get(subString);
                i += 2;
            } else {
                String subString = s.substring(i, i+1);
                if (table.containsKey(subString)) {
                    result += table.get(subString);
                    i += 1;
                }
            }
        }
        return result;
    }
}
