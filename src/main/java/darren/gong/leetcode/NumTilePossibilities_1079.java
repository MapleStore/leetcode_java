package darren.gong.leetcode;

import java.util.Arrays;

public class NumTilePossibilities_1079 {
  public static void main(String[] args) {
    NumTilePossibilities_1079 numTilePossibilities_1079 = new NumTilePossibilities_1079();
    numTilePossibilities_1079.numTilePossibilities("AAB");
  }
  private int length;
  private char[] arr;
  private int num;
  public int numTilePossibilities(String tiles) {
    arr = tiles.toCharArray();
    length = tiles.length();
    Arrays.sort(arr);
    dfs(new boolean[length], 0);
    return num;
  }
  private void dfs(boolean[] visited, int size) {
    if (size == length) {
      return;
    }
    for (int i = 0; i < length; i++) {
      if (i != 0 && (arr[i] == arr[i-1] && !visited[i-1])) {
        continue;
      }
      if (!visited[i]) {
        visited[i] = true;
        num++;
        dfs(visited, size+1);
        visited[i] = false;
      }
    }
  }
}
