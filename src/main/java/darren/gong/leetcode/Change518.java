package darren.gong.leetcode;

public class Change518 {
    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin < i) {
                    dp[i] += dp[i-coin];
                } else if (coin == i) {
                    dp[i] += 1;
                }
            }
        }
        return dp[amount];
    }
}
