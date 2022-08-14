package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MinCut_132 {
  public static void main(String[] args) {
    MinCut_132 minCut_132 = new MinCut_132();
    minCut_132.minCut("aadsaa");
    System.out.println("aadsasdfdsaagggweelkdsjhfoiejaaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhaadsasdfdsaagggweelkdsjhfoiejaaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaawmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaajnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaaaadsasdfdsaagggweelkdsaadsasdfdsaagnfosiadhnpoooooosnslkndhihhnaknikfjlweaadsasdfdsaagggweelkdsjhfoiejaaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaadsasdfdsaagggweelkdsjhfoiejwmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaawmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaaknoihlklslkiujjfaaawmfmlksdhjnfosiadhnpoooooosnslkndhihhnaknikfjlweknoihlklslkiujjfaaa".length());
  }
  public int minCut(String s) {
    char[] chars = s.toCharArray();
    int length = s.length();
    boolean[][] isP = new boolean[length][length];
    for (int i = 0; i < length; i++) {
      isP[i][i] = true;
    }
    for (int distance = 2; distance <= length; distance++) {
      for (int left = 0;; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        boolean midIsP = left == right - 1 || isP[left+1][right-1];
        isP[left][right] = midIsP && (chars[left] == chars[right]);
      }
    }
    int[] dp = new int[length];
    for (int i = 0; i < length; i++) {
      if (isP[0][i]) {
        dp[i] = 0;
        continue;
      }
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (isP[j+1][i]) {
          dp[i] = Math.min(dp[i], dp[j]+1);
        }
      }
    }
    return dp[length-1];
  }

  public int minCut2(String s) {
    char[]  chars = s.toCharArray();
    int length = s.length();
    boolean[][] isP = new boolean[length][length];
    List<Integer>[] pEnd = new List[length];
    for (int i = 0; i < length; i++) {
      pEnd[i] = new LinkedList<>();
    }
    for (int i = 0; i < length; i++) {
      isP[i][i] = true;
      pEnd[i].add(i);
    }
    for (int distance = 2; distance <= length; distance++) {
      for (int left = 0;; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        boolean midIsP = left == right - 1 || isP[left+1][right-1];
        isP[left][right] = midIsP && (chars[left] == chars[right]);
        if (isP[left][right]) {
          pEnd[left].add(right);
        }
      }
    }
    int[][] dp = new int[length][length];
    for (int distance = 2; distance <= length; distance++) {
      for (int left = 0;; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        if (isP[left][right]) {
          continue;
        }
        dp[left][right] = Integer.MAX_VALUE;
        for (int i : pEnd[left]) {
          if (i > right) {
            break;
          }
          dp[left][right] = Math.min(dp[left][right], dp[left][i]+dp[i+1][right]+1);
        }
      }
    }
    return dp[0][length-1];
  }
}
