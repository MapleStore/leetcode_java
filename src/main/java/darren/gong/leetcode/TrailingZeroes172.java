package darren.gong.leetcode;

public class TrailingZeroes172 {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            int temp = n/5;
            result += temp;
            n = temp;
        }
        return result;
    }
}
