package darren.gong.leetcode;

public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length+1];
        int result = 0;

        for (int i = 1; i <= nums.length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i-1] > nums[j-1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
