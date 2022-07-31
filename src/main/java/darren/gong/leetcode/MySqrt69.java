package darren.gong.leetcode;

public class MySqrt69 {
    public int mySqrt(int x) {
        int high = x;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high-low) >>> 1);
            int mid2 = mid * mid;
            if (mid2 == x) {
                return mid;
            } else if (mid2 > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
