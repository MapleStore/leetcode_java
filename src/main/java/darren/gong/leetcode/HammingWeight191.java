package darren.gong.leetcode;

public class HammingWeight191 {
    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = (n & (n-1));
        }
        return result;
    }
}
