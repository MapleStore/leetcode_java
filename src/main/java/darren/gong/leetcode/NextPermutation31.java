package darren.gong.leetcode;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length-1;
        int pre = Integer.MIN_VALUE;
        for (; i >= 0; i--) {
            if (nums[i] < pre) {
                break;
            }
            pre = nums[i];
        }
        if (i == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j = nums.length-1;
        for (; j > i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverse(nums, i+1, nums.length-1);
        return;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return;
    }
}
