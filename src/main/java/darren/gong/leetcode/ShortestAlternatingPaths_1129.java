package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestAlternatingPaths_1129 {
  // 1129. 颜色交替的最短路径
  public static void main(String[] args) {
    ShortestAlternatingPaths_1129 shortestAlternatingPaths_1129 = new ShortestAlternatingPaths_1129();
    shortestAlternatingPaths_1129.shortestAlternatingPaths(4, new int[][]{{0,1},{1,2},{2,3}}, new int[][]{{1,2},{2,3}});
  }
  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    boolean[][][] graph = new boolean[2][n][n];
    int[][] result = new int[2][n];
    Arrays.fill(result[0], 9999999);
    Arrays.fill(result[1], 9999999);
    // 1: 红边 2：绿边
    for (int[] red : red_edges) {
      graph[0][red[0]][red[1]] = true;
    }
    for (int[] blue : blue_edges) {
      graph[1][blue[0]][blue[1]] = true;
    }
    result[1][0] = 0;
    result[0][0] = 0;
    Queue<int[]> queue = new LinkedList<>();
    int distance = 1;
    queue.add(new int[]{0,0});
    queue.add(new int[]{0,1});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        for (int i = 0; i < n; i++) {
          int nextColor = 1-current[1];
          if (!graph[nextColor][current[0]][i]) {
            continue;
          }
          if (distance > result[nextColor][i]) {
            continue;
          }
          queue.add(new int[]{i, nextColor});
          result[nextColor][i] = distance;
        }
      }
      distance++;
    }
    int[] realResult = new int[n];
    for (int i = 0; i < n; i++) {
      realResult[i] = Math.min(result[0][i], result[1][i]);
      if (realResult[i] == 9999999) {
        realResult[i] = -1;
      }
    }
    return realResult;
  }
}
