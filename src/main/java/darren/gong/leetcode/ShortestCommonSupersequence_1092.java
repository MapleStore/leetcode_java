package darren.gong.leetcode;

public class ShortestCommonSupersequence_1092 {
  public static void main(String[] args) {
    ShortestCommonSupersequence_1092 shortestCommonSupersequence_1092 = new ShortestCommonSupersequence_1092();
    shortestCommonSupersequence_1092.shortestCommonSupersequence("abac", "cab");
  }
  public String shortestCommonSupersequence(String str1, String str2) {
    int length1 = str1.length();
    int length2 = str2.length();
    int[][] dp = new int[length1+1][length2+1];
    int[][][] match = new int[length1+1][length2+1][2];
    for (int i = 0; i < length1; i++) {
      for (int j = 0; j < length2; j++) {
        if (str1.charAt(i) == str2.charAt(j)) {
          dp[i+1][j+1] = dp[i][j]+1;
          match[i+1][j+1] = new int[]{i, j};
        } else {
          if (dp[i][j+1] >= dp[i+1][j]) {
            dp[i+1][j+1] = dp[i][j+1];
            match[i+1][j+1] = new int[]{i, j+1};
          } else {
            dp[i+1][j+1] = dp[i+1][j];
            match[i+1][j+1] = new int[]{i+1, j};
          }
        }

      }
    }
    if (dp[length1][length2] == 0) {
      return str1+str2;
    }
    StringBuilder sb = new StringBuilder();
    int i = length1;
    int j = length2;
    while (i > 0 && j > 0) {
      if (match[i][j][0] == i-1 && match[i][j][1] == j-1) {
        sb.append(str1.charAt(i-1));
      }
      int tempI = match[i][j][0];
      int tempJ = match[i][j][1];
      i = tempI;
      j = tempJ;
    }
    sb.reverse();
    StringBuilder result = new StringBuilder();
    int index1 = 0;
    int index2 = 0;
    for (char oneChar : sb.toString().toCharArray()) {
      while (index1 < length1 && str1.charAt(index1) != oneChar) {
        result.append(str1.charAt(index1++));
      }
      while (index2 < length2 && str2.charAt(index2) != oneChar) {
        result.append(str2.charAt(index2++));
      }
      result.append(oneChar);
      index1++;
      index2++;
    }
    result.append(str1, index1, length1);
    result.append(str2, index2, length2);
    return result.toString();
  }
}
