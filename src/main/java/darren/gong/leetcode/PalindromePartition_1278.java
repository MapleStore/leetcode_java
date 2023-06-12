package darren.gong.leetcode;

public class PalindromePartition_1278 {
  public static void main(String[] args) {
    PalindromePartition_1278 palindromePartition_1278 = new PalindromePartition_1278();
    palindromePartition_1278.palindromePartition("aabbc", 5);
  }
  public int palindromePartition(String s, int k) {
    int length = s.length();
    int[][] preWork = new int[length][length];
    for (int distance = 1; distance <= length; distance++) {
      for (int left = 0; left < length; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        preWork[left][right] = count(s, left, right);
      }
    }

    int[][] dp = new int[length+1][k+1];
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= i && j <= k; j++) {
        if (i == 1) {
          dp[i][j] = 0;
          continue;
        }
        if (j == 1) {
          dp[i][j] = preWork[0][i-1];
          continue;
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int mid = i-1; mid >= j-1; mid--) {
          dp[i][j] = Math.min(dp[i][j], dp[mid][j-1]+preWork[mid][i-1]);
        }
      }
    }
    return dp[length][k];
  }
  private int count(String s, int left, int right) {
    int result = 0;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        result++;
      }
      left++;
      right--;
    }
    return result;
  }
}
