package darren.gong.leetcode;

public class Convert6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++, i++) {
                sbArray[j].append(s.charAt(i));
            }
            for (int j = numRows-2; j > 0 && i < s.length(); j--, i++) {
                sbArray[j].append(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder oneLine : sbArray) {
            result.append(oneLine);
        }
        return result.toString();
    }
}
