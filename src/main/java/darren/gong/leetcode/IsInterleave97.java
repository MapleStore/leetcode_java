package darren.gong.leetcode;

public class IsInterleave97 {
  public static void main(String[] args) {
    IsInterleave97 isInterleave97 = new IsInterleave97();
    isInterleave97.isInterleaveDP2Optimize("ab",
        "bc",
        "babc");
  }
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.length() != s1.length()+s2.length()) {
      return false;
    }
    boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
    dp[0][0] = true;
    // s1的前i个字符 s2的前j个字符 能否组成s3的前i+j个字符
    for (int k = 1; k <= s3.length(); k++) {
      for (int i = 1; i <= k && i <= s1.length(); i++) {
        if (k-i > s2.length()) {
          continue;
        }
        if (s3.charAt(k-1) == s1.charAt(i-1)) {
          dp[i][k-i] |= dp[i-1][k-i];
        }
      }
      for (int j = 1; j <= k && j <= s2.length(); j++) {
        if (k-j > s1.length()) {
          continue;
        }
        if (s3.charAt(k-1) == s2.charAt(j-1)) {
          dp[k-j][j] |= dp[k-j][j-1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  public boolean isInterleaveDP2(String s1, String s2, String s3) {
    if (s3.length() != s1.length()+s2.length()) {
      return false;
    }
    boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
    dp[0][0] = true;
    // s1的前i个字符 s2的前j个字符 能否组成s3的前i+j个字符
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int s3Index = i+j-1;
        if (i-1 >= 0 && s3.charAt(s3Index) == s1.charAt(i-1)) {
          dp[i][j] |= dp[i-1][j];
        }
        if (j-1 >= 0 && s3.charAt(s3Index) == s2.charAt(j-1)) {
          dp[i][j] |= dp[i][j-1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  public boolean isInterleaveDP2Optimize(String s1, String s2, String s3) {
    if (s3.length() != s1.length()+s2.length()) {
      return false;
    }
    int s1Length = s1.length();
    int s2Length = s2.length();
    char[] s1Arr = s1.toCharArray();
    char[] s2Arr = s2.toCharArray();
    char[] s3Arr = s3.toCharArray();
    boolean[] dpj = new boolean[s2Length+1];
    dpj[0] = true;
    // s1的前i个字符 s2的前j个字符 能否组成s3的前i+j个字符
    for (int i = 0; i <= s1Length; i++) {
      for (int j = 0; j <= s2Length; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int s3Index = i+j-1;
        boolean temp = false;
        if (i-1 >= 0 && s3Arr[s3Index] == s1Arr[i-1]) {
          temp |= dpj[j];
        }
        if (j-1 >= 0 && s3Arr[s3Index] == s2Arr[j-1]) {
          temp |= dpj[j-1];
        }
        dpj[j] = temp;
      }
    }
    return dpj[s2Length];
  }

}
