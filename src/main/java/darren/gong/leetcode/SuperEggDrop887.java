package darren.gong.leetcode;

import java.util.Arrays;

public class SuperEggDrop887 {
  public static void main(String[] args) {
    SuperEggDrop887 superEggDrop887 = new SuperEggDrop887();
    superEggDrop887.superEggDrop(8, 5000);
  }
  // 原始dp解法
  public int superEggDrop(int K, int N) {
    int[][] dp = new int[K+1][N+1];
    // dp[i[j
    for (int i = 0; i <= K; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    // i个鸡蛋, j层, 需要尝试次数
    for (int i = 0; i <= K; i++) {
      for (int j = 0; j <= N; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (i == 1) {
          dp[i][j] = j;
        } else if (j == 1) {
          dp[i][j] = 1;
        } else {
          for (int k = 1; k <= j; k++) {
            dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k-1], dp[i][j-k])+1);
          }
        }
      }
    }
    return dp[K][N];
  }

  // 用二分查找优化后的dp解法
  public int superEggDropImprove(int K, int N) {
    int[][] dp = new int[K+1][N+1];
    // dp[i[j
    for (int i = 0; i <= K; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    // i个鸡蛋, j层, 需要尝试次数
    for (int i = 0; i <= K; i++) {
      for (int j = 0; j <= N; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (i == 1) {
          dp[i][j] = j;
        } else if (j == 1) {
          dp[i][j] = 1;
        } else {
          // dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k-1], dp[i][j-k])+1);
          // dp[i-1][k-1] 随k增大递增  dp[i][j-k]随k增大递减
          int left = 1;
          int right = j;
          while (left <= right) {
            int mid = left+((right-left)>>>1);
            if (dp[i-1][mid-1] < dp[i][j-mid]) {
              left = mid+1;
            } else if (dp[i-1][mid-1] > dp[i][j-mid]) {
              right = mid-1;
            } else {
              right = mid;
              break;
            }
          }
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][right-1], dp[i][j-right])+1);
        }
      }
    }
    return dp[K][N];
  }
  // 递归解法
  public int superEggDropRecursion(int K, int N) {
    int[][] mem = new int[K+1][N+1];
    // dp[i[j
    for (int i = 0; i <= K; i++) {
      Arrays.fill(mem[i], Integer.MAX_VALUE);
    }
    return superEggDropHelper(K, N, mem);
  }

  public int superEggDropHelper(int K, int N, int[][] mem) {
    if (K == 0 || N == 0) {
      return 0;
    }
    if (K == 1) {
      return N;
    }
    if (N == 1) {
      return 1;
    }

    if (mem[K][N] != Integer.MAX_VALUE) {
      return mem[K][N];
    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      result = Math.min(result, Math.max(superEggDropHelper(K-1, i-1, mem), superEggDropHelper(K, N-i, mem))+1);
    }
    mem[K][N] = result;
    return result;
  }

}
