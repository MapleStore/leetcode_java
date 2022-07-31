package darren.gong.leetcode;

public class CombinationSum4377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num < i) {
                    dp[i] += dp[i-num];
                } else if (num == i) {
                    dp[i] += 1;
                }
            }
        }
        return dp[target];
    }
}
