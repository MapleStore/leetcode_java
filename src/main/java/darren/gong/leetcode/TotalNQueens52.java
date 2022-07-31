package darren.gong.leetcode;

public class TotalNQueens52 {
  public static void main(String[] args) {
    TotalNQueens52 totalNQueens52 = new TotalNQueens52();
    int result = totalNQueens52.totalNQueens(4);
    return;
  }
  private boolean[] cols;
  private boolean[] up;
  private boolean[] down;
  private int result = 0;
  public int totalNQueens(int n) {
    cols = new boolean[n];
    up = new boolean[2*n+1];
    down = new boolean[2*n+1];
    dfs(n, 0);
    return result;
  }
  private void dfs(int n, int line) {
    if (line >= n) {
      result++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (cols[i] || upVisited(n, line, i) || downVisited(n, line, i)) {
        continue;
      }
      cols[i] = true;
      upVisit(n, line, i);
      downVisit(n, line, i);

      dfs(n, line+1);

      cols[i] = false;
      upUnVisit(n, line, i);
      downUnVisit(n, line, i);
    }
  }
  private boolean upVisited(int n, int line, int col) {
    return up[col+n-line];
  }
  private void upVisit(int n, int line, int col) {
    up[col+n-line] = true;
  }
  private void upUnVisit(int n, int line, int col) {
    up[col+n-line] = false;
  }

  private boolean downVisited(int n, int line, int col) {
    return down[line+col];
  }
  private void downVisit(int n, int line, int col) {
    down[line+col] = true;
  }
  private void downUnVisit(int n, int line, int col) {
    down[line+col] = false;
  }

}
