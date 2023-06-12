package darren.gong.leetcode.lcp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimalSteps_13 {
  public static void main(String[] args) {
    MinimalSteps_13 minimalSteps_13 = new MinimalSteps_13();
    minimalSteps_13.minimalSteps(new String[]{"S#O",
                                              "M..",
                                              "M.T"});
  }
  private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
  Map<Integer, Map<Integer, Integer>> minDistanceTo = new HashMap<>();
  Map<Integer, Map<String, Integer>> to = new HashMap<>();
  Map<Integer, Integer> toTarget = new HashMap<>();
  public int minimalSteps(String[] maze) {
    int maxX = maze.length;
    int maxY = maze[0].length();

    int num = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (maze[i].charAt(j) == '.' || maze[i].charAt(j) == '#' || maze[i].charAt(j) == 'O' || maze[i].charAt(j) == 'T') {
          continue;
        }
        int currentIndex;
        if (maze[i].charAt(j) == 'S') {
          currentIndex = -1;
        } else {
          currentIndex = num++;
        }
        boolean[][] visited = new boolean[maxX][maxY];
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int distance = 1;
        while (!queue.isEmpty()) {
          int size = queue.size();
          while (size-- > 0) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
              int nextX = current[0]+direction[0];
              int nextY = current[1]+direction[1];
              if (nextX >= maxX || nextX < 0 || nextY >= maxY || nextY < 0 || visited[nextX][nextY]) {
                continue;
              }
              visited[nextX][nextY] = true;
              char nextChar = maze[nextX].charAt(nextY);
              if (nextChar == '#') {
                continue;
              }
              if (nextChar == 'O') {
                to.computeIfAbsent(currentIndex, k->new HashMap<>()).put(nextX+"@"+nextY, distance);
              }
              if (nextChar == 'T') {
                toTarget.put(currentIndex, distance);
              }
              queue.add(new int[]{nextX, nextY});
            }
          }
          distance++;
        }
      }
    }
    if (num == 0) {
      return toTarget.getOrDefault(-1, -1);
    }
    for (int i = -1; i < num; i++) {
      for (int j = -1; j < num; j++) {
        // same
        if (i == j) {
          continue;
        }
        minDistanceTo.computeIfAbsent(i, k->new HashMap<>()).put(j, minDistance(i, j));
      }
    }

    int all = 1<<num;
    int[][] dp = new int[all][num];
    for (int mask = 1; mask < all; mask++) {
      for (int pos = 0; pos < num; pos++) {
        if ((mask&(1<<pos)) == 0) {
          continue;
        }
        dp[mask][pos] = 99999;

        int preMask = mask^(1<<pos);
        if (preMask == 0) {
          dp[mask][pos] = minDistanceTo.getOrDefault(-1, new HashMap<>()).getOrDefault(pos, 99999);
        }
        for (int prePos = 0; prePos < num; prePos++) {
          if ((preMask&(1<<prePos)) == 0) {
            continue;
          }
          dp[mask][pos] = Math.min(dp[mask][pos], dp[preMask][prePos]+
              minDistanceTo.getOrDefault(prePos, new HashMap<>()).getOrDefault(pos, 99999));
        }
      }
    }
    int result = Integer.MAX_VALUE;
    for (int pos = 0; pos < num; pos++) {
      if (((all-1)&(1<<pos)) == 0) {
        continue;
      }
      result = Math.min(result, dp[all-1][pos]+toTarget.getOrDefault(pos, 99999));
    }
    return result >= 99999 ? -1 : result;
  }
  private int minDistance(int pos1, int pos2) {
    int result = 99999;
    for (Map.Entry<String, Integer> entry : to.getOrDefault(pos1, new HashMap<>()).entrySet()) {
      Integer pos2Distance = to.getOrDefault(pos2, new HashMap<>()).get(entry.getKey());
      if (pos2Distance != null) {
        result = Math.min(result, entry.getValue()+pos2Distance);
      }
    }
    return result;
  }
}
