package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindTheCity_1334 {
  public static void main(String[] args) {
    FindTheCity_1334 findTheCity_1334 = new FindTheCity_1334();
    findTheCity_1334.findTheCityDijkstra(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 8);
  }
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    Map<Integer, Integer>[] neighbors = new Map[n];
    for (int i = 0; i < n; i++) {
      neighbors[i] = new HashMap<>();
    }
    for (int[] edge : edges) {
      neighbors[edge[0]].put(edge[1], edge[2]);
      neighbors[edge[1]].put(edge[0], edge[2]);
    }

    Queue<int[]> queue = new LinkedList<>();
    int minCanReach = Integer.MAX_VALUE;
    int result = -1;
    for (int i = 0; i < n; i++) {
      queue.add(new int[]{i, distanceThreshold});
      int[] canGo = new int[n];
      Arrays.fill(canGo, -1);
      canGo[i] = distanceThreshold;
      while (!queue.isEmpty()) {
        int[] current = queue.poll();
        for (Map.Entry<Integer, Integer> entry : neighbors[current[0]].entrySet()) {
          int[] next = new int[]{entry.getKey(), current[1]-entry.getValue()};
          if (next[1] > canGo[next[0]]) {
            queue.add(next);
            canGo[next[0]] = next[1];
          }
        }
      }
      int canReachNum = 0;
      for (int canGoValue : canGo) {
        if (canGoValue >= 0) {
          canReachNum++;
        }
      }
      if (canReachNum <= minCanReach) {
        result = i;
        minCanReach = canReachNum;
      }
    }
    return result;
  }

  public int findTheCityDijkstra(int n, int[][] edges, int distanceThreshold) {
    int[][] map = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(map[i], 999999);
      map[i][i] = 0;
    }
    for (int[] edge : edges) {
      map[edge[0]][edge[1]] = edge[2];
      map[edge[1]][edge[0]] = edge[2];
    }
    int minCanReach = Integer.MAX_VALUE;
    int result = -1;
    for (int i = 0; i < n; i++) {
      int currentCanReach = 0;
      int[] distances = new int[n];
      Arrays.fill(distances, 999999);
      distances[i] = 0;
      boolean[] visited = new boolean[n];

      while (true) {
        int target = -1;
        int minDis = Integer.MAX_VALUE;
        for (int point = 0; point < n; point++) {
          if (!visited[point] && distances[point] < minDis) {
            minDis = distances[point];
            target = point;
          }
        }
        if (minDis > distanceThreshold) {
          break;
        }
        visited[target] = true;
        currentCanReach++;
        for (int point = 0; point < n; point++) {
          if (distances[target]+map[target][point] < distances[point]) {
            distances[point] = distances[target]+map[target][point];
          }
        }
      }
      if (currentCanReach <= minCanReach) {
        result = i;
        minCanReach = currentCanReach;
      }
    }
    return result;
  }
}
