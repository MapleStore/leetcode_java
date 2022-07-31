package darren.gong.leetcode;

public class CountArrangement_526 {
  // 526. 优美的排列
  private int result = 0;
  private int n;
  public int countArrangement(int n) {
    this.n = n;
    backTracking(new boolean[n+1], 1);
    return result;
  }
  private void backTracking(boolean[] visited, int index) {
    if (index > n) {
      result++;
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (visited[i]) {
        continue;
      }
      if (i%index != 0 && index%i != 0) {
        continue;
      }
      visited[i] = true;
      backTracking(visited, index+1);
      visited[i] = false;
    }
  }
}
