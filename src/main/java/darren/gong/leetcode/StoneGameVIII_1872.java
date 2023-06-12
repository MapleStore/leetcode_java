package darren.gong.leetcode;

public class StoneGameVIII_1872 {
  public static void main(String[] args) {
    StoneGameVIII_1872 stoneGameVIII_1872 = new StoneGameVIII_1872();
    stoneGameVIII_1872.stoneGameVIII(new int[]{-1,2,-3,4,-5});
  }
  public int stoneGameVIII(int[] stones) {
    int length = stones.length;
    int[] prefix = new int[length];
    prefix[0] = stones[0];
    for (int i = 1; i < length; i++) {
      prefix[i] = prefix[i-1]+stones[i];
    }

    int[] dp = new int[length+1];
    int max = Integer.MIN_VALUE;
    for (int currentIndex = length-1; currentIndex >= 1; currentIndex--) {
      dp[currentIndex] = Math.max(max, prefix[currentIndex]-dp[currentIndex+1]);
      max = dp[currentIndex];
    }
    return dp[1];
  }
}
