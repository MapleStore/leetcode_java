package darren.gong.leetcode;

public class PossibleBipartition_886 {
  // 886. 可能的二分法
  private int N;
  private int[] groupOfPeople;
  public boolean possibleBipartition(int N, int[][] dislikes) {
    this.N = N;
    groupOfPeople = new int[N+1];
    int[][] friend = new int[N+1][N+1];
    for (int[] dislike : dislikes) {
      friend[dislike[0]][dislike[1]] = 1;
      friend[dislike[1]][dislike[0]] = 1;
    }
    for (int i = 1; i <= N; i++) {
      if (groupOfPeople[i] == 0 && !dfs(friend, i, 1)) {
        return false;
      }
    }
    return true;
  }
  private boolean dfs(int[][] friend, int x, int group) {
    if (groupOfPeople[x] == group) {
      return true;
    }
    if (groupOfPeople[x] != 0) {
      return false;
    }
    groupOfPeople[x] = group;
    for (int j = 1; j <= N; j++) {
      if (friend[x][j] == 1 && !dfs(friend, j, 3-group)) {
        return false;
      }
    }
    return true;
  }
}
