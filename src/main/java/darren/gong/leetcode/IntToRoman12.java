package darren.gong.leetcode;

public class IntToRoman12 {
    private static int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                sb.append(romans[i]);
                num -= nums[i];
            }
        }
        return sb.toString();
    }
}
