package darren.gong.leetcode;

public class WinnerSquareGame_1510 {
  public static void main(String[] args) {
    WinnerSquareGame_1510 winnerSquareGame_1510 = new WinnerSquareGame_1510();
    winnerSquareGame_1510.winnerSquareGame(1);
  }
  private boolean[] cache;
  private boolean[] visited;
  public boolean winnerSquareGame(int n) {
    cache = new boolean[n+1];
    visited = new boolean[n+1];
    return winnerSquareGameHelper(n);
  }
  public boolean winnerSquareGameHelper(int n) {
    if (n == 0) {
      return false;
    }
    if (visited[n]) {
      return cache[n];
    }
    visited[n] = true;
    for (int i = 1; i*i <= n; i++) {
      if (!winnerSquareGameHelper(n-i*i)) {
        cache[n] = true;
        return true;
      }
    }
    cache[n] = false;
    return false;
  }

}
