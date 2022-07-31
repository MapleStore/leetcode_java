package darren.gong.leetcode;

public class FindUnsortedSubarray581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i+1 < nums.length && nums[i+1] < nums[i]) {
                min = Math.min(min, nums[i+1]);
            }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (i-1 >= 0 && nums[i-1] > nums[i]) {
                max = Math.max(max, nums[i-1]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        int minIndex = 0;
        int maxIndex = nums.length-1;
        for (; minIndex < nums.length; minIndex++) {
            if (nums[minIndex] > min) {
                break;
            }
        }
        for (; maxIndex >= 0; maxIndex--) {
            if (nums[maxIndex] < max) {
                break;
            }
        }
        return maxIndex-minIndex+1;
    }
}
