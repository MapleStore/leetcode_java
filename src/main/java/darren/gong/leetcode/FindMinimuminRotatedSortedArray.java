package darren.gong.leetcode;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while (high > low) {
            int mid = low+(high-low)/2;
            if (nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[high];
    }
}
