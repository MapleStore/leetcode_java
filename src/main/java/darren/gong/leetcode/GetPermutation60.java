package darren.gong.leetcode;

public class GetPermutation60 {
  public static void main(String[] args) {
    GetPermutation60 getPermutation60 = new GetPermutation60();
    getPermutation60.getPermutation(3, 3);
  }
  public String getPermutation(int n, int k) {
    int[] factorial = new int[n];
    factorial[0] = 1;
    for (int i = 1; i < n; i++) {
      factorial[i] = i*factorial[i-1];
    }
    StringBuilder result = new StringBuilder();
    dfs(n, k, result, factorial, new boolean[n+1]);
    return result.toString();
  }

  private void dfs(int n, int k, StringBuilder result, int[] factorial, boolean[] visited) {
    if (result.length() == n) {
      return;
    }
    int jump = factorial[n-result.length()-1];
    for (int i = 1; i <= n; i++) {
      if (visited[i]) {
        continue;
      }
      if (jump < k) {
        k -= jump;
        continue;
      }
      result.append(i);
      visited[i] = true;
      dfs(n, k, result, factorial, visited);
    }
  }
}
