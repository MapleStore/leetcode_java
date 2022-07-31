package darren.gong.leetcode;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int preMax = 1;
        int preMin = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = nums[i] >= 0 ? Math.max(preMax*nums[i], nums[i]) : Math.max(preMin*nums[i], nums[i]);
            int tempMin = nums[i] >= 0 ? Math.min(preMin*nums[i], nums[i]) : Math.min(preMax*nums[i], nums[i]);
            preMax = tempMax;
            preMin = tempMin;
            result = Math.max(tempMax, result);
        }
        return result;
    }
}
