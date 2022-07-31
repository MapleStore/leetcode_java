package darren.gong.leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int digit = 1;
        int curIndex = digits.length-1;
        while (digit != 0) {
            int newNum = digits[curIndex]+digit;
            digit = newNum/10;
            digits[curIndex] = digit > 0 ? 0 : newNum;
            curIndex--;
            if (curIndex < 0) {
                break;
            }
        }
        if (digit == 0) {
            return digits;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        curIndex = 1;
        for (int num : digits) {
            result[curIndex++] = num;
        }
        return result;
    }
}
