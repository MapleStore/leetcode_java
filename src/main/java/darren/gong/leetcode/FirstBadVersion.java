package darren.gong.leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int high = n;
        int low = 1;
        while (high > low) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return high;
    }
    boolean isBadVersion(int version) {
        return true;
    }
}
