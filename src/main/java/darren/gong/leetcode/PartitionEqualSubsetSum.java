package darren.gong.leetcode;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int []nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        //nums中前i个数，是否能选出和为j的几个数
        boolean [][]dp = new boolean[nums.length+1][(sum / 2) + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= (sum / 2); j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][(sum / 2)];
    }
}
