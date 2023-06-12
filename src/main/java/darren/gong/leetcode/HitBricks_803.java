package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HitBricks_803 {
  public static void main(String[] args) {
    HitBricks_803 hitBricks_803 = new HitBricks_803();
    hitBricks_803.hitBricks(new int[][]{{1,0,0,0},{1,1,1,0}}, new int[][]{{1,0}});
  }
  private int length;
  private int maxX;
  private int maxY;
  private int[][] grid;
  private int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
  private int[] parents;
  public int[] hitBricks(int[][] grid, int[][] hits) {
    this.grid = grid;
    length = hits.length;
    maxX = grid.length;
    maxY = grid[0].length;
    int[] result = new int[length];
    Arrays.fill(result, -1);
    int group = 3;
    Map<Integer, Integer> groupSum = new HashMap<>();
    for (int i = 0; i < length; i++) {
      int[] hit = hits[i];
      if (grid[hit[0]][hit[1]] == 0) {
        result[i] = 0;
      } else {
        groupSum.put(group, 1);
        grid[hit[0]][hit[1]] = group++;
      }
    }

    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] != 1) {
          continue;
        }
        if (i == 0) {
          dfs(0, j, 2);
        } else {
          groupSum.put(group, groupSum.getOrDefault(group, 0)+dfs(i, j, group));
          group++;
        }
      }
    }
    parents = new int[group];
    for (int i = 0; i < group; i++) {
      parents[i] = i;
    }
    for (int i = length-1; i >= 0; i--) {
      if (result[i] == 0) {
        continue;
      }
      int[] hit = hits[i];
      int hitParent = getParent(grid[hit[0]][hit[1]]);
      boolean canTouch = false;
      for (int[] direction : directions) {
        int x = hit[0]+direction[0];
        int y = hit[1]+direction[1];
        if (x < 0 || x >= maxX || y < 0 || y >= maxY || grid[x][y] == 0) {
          continue;
        }
        int currentParent = getParent(grid[x][y]);
        if (currentParent == 2) {
          canTouch = true;
          continue;
        }
        if (currentParent > hitParent) {
          merge(currentParent, hitParent);
          groupSum.put(hitParent, groupSum.get(hitParent)+groupSum.get(currentParent));
        }
      }
      result[i] = 0;
      if (canTouch || hit[0] == 0) {
        result[i] = groupSum.get(hitParent)-1;
        merge(hitParent, 2);
      }
    }
    return result;
  }

  private int dfs(int x, int y, int val) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    grid[x][y] = val;
    int count = 0;
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      count++;
      for (int[] direction : directions) {
        int nextX = current[0]+direction[0];
        int nextY = current[1]+direction[1];
        if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || grid[nextX][nextY] != 1) {
          continue;
        }
        grid[nextX][nextY] = val;
        queue.add(new int[]{nextX, nextY});
      }
    }
    return count;
  }
  private int getParent(int current) {
    if (parents[current] == current) {
      return current;
    }
    parents[current] = getParent(parents[current]);
    return parents[current];
  }
  private void merge(int x1, int x2) {
    if (parents[x1] == parents[x2]) {
      return;
    }
    parents[getParent(x1)] = parents[getParent(x2)];
  }
}
