package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NumDistinctIslands694 {

  public static void main(String[] args) {
    NumDistinctIslands694 numDistinctIslands694 = new NumDistinctIslands694();
    int result = numDistinctIslands694.numDistinctIslands(new int[][]{
        {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
        {0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0},
        {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}}
        );
    System.out.println(result);
  }

  private int count = 0;
  public int numDistinctIslands(int[][] grid) {

    /*[0,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0],
    * [0,0,1,0,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,1,1,0,1,0,0,0],
    * [0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0],
    * [1,0,1,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1]
    */
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    List<List<int[]>> all = new LinkedList<>();
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] == 0) {
          continue;
        }
        List<int[]> one = new ArrayList<>();
        dfs(i, j, grid, maxX, maxY, directions, one);
        if (!contains(one, all)) {
          count++;
          all.add(one);
        }
      }
    }
    return count;
  }
  private void dfs(int x, int y, int[][] grid, int maxX, int maxY, int[][] directions, List<int[]> one) {
    grid[x][y] = 0;
    for (int[] direction : directions) {
      int nextX = x+direction[0];
      int nextY = y+direction[1];
      if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || grid[nextX][nextY] == 0) {
        continue;
      }
      one.add(direction);
      dfs(nextX, nextY, grid, maxX, maxY, directions, one);
      one.add(direction);
    }
  }
  private boolean contains(List<int[]> one, List<List<int[]>> all) {
    for (List<int[]> oneInAll : all) {
      if (equals(one, oneInAll)) {
        return true;
      }
    }
    return false;
  }
  private boolean equals(List<int[]> one, List<int[]> another) {
    if (another.size() != one.size()) {
      return false;
    }
    for (int i = 0; i < another.size(); i++) {
      if (another.get(i) != one.get(i)) {
        return false;
      }
    }
    return true;
  }
}
