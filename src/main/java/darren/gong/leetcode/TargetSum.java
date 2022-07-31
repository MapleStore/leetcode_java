package darren.gong.leetcode;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        //position - negetine = target
        //positive - negetive + sum(posttive + negetive) = target + sum
        //2positive = target + sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S <0 && (S + sum) % 2 != 0) {
            return 0;
        }
        int positive = (S + sum) / 2;
        //前i个数，正数和为positive的组合种类有多少
        int dp[][] = new int[nums.length+1][positive+1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= positive; j++) {
                if (i == 1 && nums[i-1] == j) {
                    dp[i][j] = 1;
                }else if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][positive];
    }

}
