package darren.gong.leetcode;

public class NumRollsToTarget1155 {
    public static void main(String[] args) {
        NumRollsToTarget1155 numRollsToTarget1155 = new NumRollsToTarget1155();
        //numRollsToTarget1155.numRollsToTarget(2, 6, 7);
        numRollsToTarget1155.numRollsToTarget(2, 5, 5);
    }
    public int numRollsToTarget(int d, int f, int target) {
        int[] dp = new int[target+1];
        int mod = 1000000007;
        for (int i = 1; i <= f && i <= target; i++) {
            dp[i] = 1;
        }
        if (d == 1) {
            return dp[target];
        }
        for (int i = 2; i <= d; i++) {
            for (int j = target; j >= 1; j--) {
                int result = 0;
                for (int k = 1; k <= f && j-k > 0; k++) {
                    result = dp[j-k]+result;
                    if (result >= mod) {
                        result = result-mod;
                    }
                }
                dp[j] = result;
            }
        }
        return dp[target];
    }
}
