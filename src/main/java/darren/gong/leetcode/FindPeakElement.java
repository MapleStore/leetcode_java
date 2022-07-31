package darren.gong.leetcode;

public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        findPeakElement.findPeakElement(new int[]{1,2,3,1});
    }
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int numsLength = nums.length;
        int low = 0;
        int high = numsLength-1;
        if (numsLength == 1) {
            return 0;
        } else {
            int highLess = numsLength-2 < 0 ? Integer.MIN_VALUE : nums[numsLength-2];
            int lowMore = 1 >= numsLength ? Integer.MIN_VALUE : nums[1];
            if (lowMore < nums[0]) {
                return 0;
            }
            if (highLess < nums[numsLength-1]) {
                return numsLength-1;
            }
        }
        while (high > low) {
            int mid = low+(high-low)/2;
            int lessMid = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
            int moreMid = mid == numsLength-1 ? Integer.MIN_VALUE : nums[mid+1];
            if (lessMid < nums[mid] && moreMid < nums[mid]) {
                return mid;
            } else if (lessMid < nums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
