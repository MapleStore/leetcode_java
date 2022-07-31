package darren.gong.leetcode;

public class StoneGameVII_1690 {
  // 1690. 石子游戏 VII
  public static void main(String[] args) {
    StoneGameVII_1690 stoneGameVII_1690 = new StoneGameVII_1690();
    stoneGameVII_1690.stoneGameVII(new int[]{5,3,1,4,2});
  }
  public int stoneGameVII(int[] stones) {
    int length = stones.length;
    for (int i = 1; i < length; i++) {
      stones[i] += stones[i-1];
    }
    int[][] dp = new int[length][length];
    for (int distance = 1; distance <= length; distance++) {
      for (int left = 0; left+distance-1 < length; left++) {
        int right = left+distance-1;
        if (distance == 1) {
          continue;
        }
        int removeLeft = stones[right]-stones[left]-dp[left+1][right];
        int removeRight = stones[right-1]-(left == 0 ? 0 : stones[left-1])-dp[left][right-1];
        dp[left][right] = Math.max(removeLeft, removeRight);
      }
    }
    return dp[0][length-1];
  }
}
