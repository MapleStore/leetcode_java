package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0) {
            return "0";
        }
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long numeratorLong = Math.abs(Long.valueOf(numerator));
        long denominatorLong = Math.abs(Long.valueOf(denominator));
        sb.append(numeratorLong/denominatorLong);
        numeratorLong = numeratorLong % denominatorLong;
        if (numeratorLong == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> reminder = new HashMap<>();
        while (numeratorLong != 0) {
            numeratorLong = numeratorLong*10;
            if (reminder.containsKey(numeratorLong)) {
                sb.insert(reminder.get(numeratorLong), "(");
                sb.append(")");
                return sb.toString();
            }
            reminder.put(numeratorLong, sb.length());
            sb.append(""+numeratorLong/denominatorLong);
            numeratorLong = numeratorLong%denominatorLong;
        }
        return sb.toString();
    }
}
