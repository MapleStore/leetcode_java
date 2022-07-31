package darren.gong.leetcode;

public class WiggleMaxLength376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length+1][2];
        int max = 0;
        //0 down 1 up
        for (int i = 1; i <= length; i++) {
            dp[i][1] = 1;
            dp[i][0] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i-1] > nums[j-1]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
                } else if (nums[i-1] < nums[j-1]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
                }
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
