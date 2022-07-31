package darren.gong.leetcode;

public class IsPerfectSquare367 {
    public static void main(String[] args) {
        IsPerfectSquare367 isPerfectSquare367 = new IsPerfectSquare367();
        isPerfectSquare367.isPerfectSquare(2147483647);
    }
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = left+(right-left)/2;
            long value = mid*mid;
            if (value == num) {
                return true;
            } else if (value > num) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}
