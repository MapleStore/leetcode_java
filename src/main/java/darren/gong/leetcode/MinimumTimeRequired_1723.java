package darren.gong.leetcode;

public class MinimumTimeRequired_1723 {
  public static void main(String[] args) {
    MinimumTimeRequired_1723 minimumTimeRequired_1723 = new MinimumTimeRequired_1723();
    minimumTimeRequired_1723.minimumTimeRequired(new int[]{3,2,3}, 3);
  }
  public int minimumTimeRequired(int[] jobs, int k) {
    int length = jobs.length;
    int mask = (1<<length)-1;
    int[] times = new int[mask+1];
    for (int i = 0; i < length; i++) {
      times[1<<i] = jobs[i];
    }
    for (int i = 1; i <= mask; i++) {
      int subJob = lowBit(i);
      times[i] = times[i-subJob]+times[subJob];
    }
    int[][] dp = new int[k+1][mask+1];
    // i个工人 完成j状态的工作最少时间
    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= mask; j++) {
        if (i == 1) {
          dp[i][j] = times[j];
          continue;
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int subJob = j; subJob > 0; subJob = (subJob-1)&j) {
          dp[i][j] = Math.min(dp[i][j], Math.max(times[subJob], dp[i-1][j-subJob]));
        }
      }
    }
    return dp[k][mask];
  }
  private int lowBit(int num) {
    return num&-num;
  }
}
