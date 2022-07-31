package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime743 {
  public static void main(String[] args) {
    NetworkDelayTime743 networkDelayTime743 = new NetworkDelayTime743();
    networkDelayTime743.networkDelayTimeDijkstraOptimizeByQueue(new int[][]{{1,2,1}}, 2, 2);
  }
  public int networkDelayTimeSPFA(int[][] times, int N, int K) {
    int[] cost = new int[N+1];
    for (int i = 1; i <= N; i++) {
      cost[i] = 9999999;
    }
    int[][] distances = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        distances[i][j] = 9999999;
      }
    }

    for (int[] time : times) {
      distances[time[0]][time[1]] = time[2];
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{K, 0});
    cost[K] = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        // 0 node, 1 time
        int[] current = queue.poll();
        int currentNode = current[0];
        int currentDis = current[1];
        int[] allNext = distances[currentNode];
        for (int nextNode = 1; nextNode <= N; nextNode++) {
          int nextDis = currentDis+allNext[nextNode];
          if (nextDis < cost[nextNode]) {
            cost[nextNode] = nextDis;
            queue.add(new int[]{nextNode, nextDis});
          }
        }
      }
    }
    int result = 0;
    for (int oneCost : cost) {
      if (oneCost == 9999999) {
        return -1;
      }
      result = Math.max(result, oneCost);
    }
    return result;
  }

  public int networkDelayTimeDijkstra(int[][] times, int N, int K) {
    // init minCosts
    int[] minCosts = new int[N+1];
    for (int i = 1; i <= N; i++) {
      minCosts[i] = 9999999;
    }
    minCosts[K] = 0;
    // init graph
    int[][] distances = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        distances[i][j] = 9999999;
      }
    }
    for (int[] time : times) {
      distances[time[0]][time[1]] = time[2];
    }
    // find all min path
    boolean[] visited = new boolean[N+1];
    for (int i = 1; i <= N; i++) {
      int minCostNode = 0;
      int minCost = 9999999;
      for (int j = 1; j <= N; j++) {
        if (!visited[j] && minCosts[j] < minCost) {
          minCost = minCosts[j];
          minCostNode = j;
        }
      }
      if (minCostNode == 0) { // or minCost == 9999999, all node are min distance
        break;
      }
      visited[minCostNode] = true;
      for (int j = 1; j <= N; j++) {
        minCosts[j] = Math.min(minCosts[j], minCosts[minCostNode]+distances[minCostNode][j]);
      }
    }

    // get result
    int result = 0;
    for (int oneCost : minCosts) {
      if (oneCost == 9999999) {
        return -1;
      }
      result = Math.max(result, oneCost);
    }
    return result;
  }

  public int networkDelayTimeDijkstraOptimizeByQueue(int[][] times, int N, int K) {
    // init minCosts
    int[] minCosts = new int[N+1];
    for (int i = 1; i <= N; i++) {
      minCosts[i] = 9999999;
    }
    minCosts[K] = 0;
    // init graph
    int[][] distances = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        distances[i][j] = 9999999;
      }
    }
    for (int[] time : times) {
      distances[time[0]][time[1]] = time[2];
    }
    // find all min path
    boolean[] visited = new boolean[N+1];
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
    priorityQueue.add(new int[]{0, K});
    while (!priorityQueue.isEmpty()) {
      int[] currentMin = priorityQueue.poll();
      int currentNode = currentMin[1];
      int currentDis = currentMin[0];
      if (visited[currentNode]) {
        continue;
      }
      visited[currentNode] = true;
      for (int i = 1; i <= N; i++) {
        int nextDis = currentDis+distances[currentNode][i];
        if (!visited[i] && nextDis < minCosts[i]) {
          minCosts[i] = nextDis;
          priorityQueue.add(new int[]{nextDis, i});
        }
      }
    }
    // get result
    int result = 0;
    for (int oneCost : minCosts) {
      if (oneCost == 9999999) {
        return -1;
      }
      result = Math.max(result, oneCost);
    }
    return result;
  }


  public int networkDelayTimeFord(int[][] times, int N, int K) {
    // init graph
    int[][] distances = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        distances[i][j] = 9999999;
      }
    }
    for (int i = 1; i <= N; i++) {
      distances[i][i] = 0;
    }
    for (int[] time : times) {
      distances[time[0]][time[1]] = time[2];
    }
    // find all min path
    boolean[] visited = new boolean[N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        for (int k = 1; k <= N; k++) {
          distances[j][k] = Math.min(distances[j][k], distances[j][i]+distances[i][k]);
        }
      }
    }

    // get result
    int result = 0;
    for (int i = 1; i <= N; i++) {
      if (distances[K][i] > 9999999/2) {
        return -1;
      }
      result = Math.max(result, distances[K][i]);
    }
    return result;
  }

  public int networkDelayTimeBellmanFord(int[][] times, int N, int K) {
    // init minCosts
    int[] minCosts = new int[N+1];
    for (int i = 1; i <= N; i++) {
      minCosts[i] = 9999999;
    }
    minCosts[K] = 0;
    // init graph
    int[][] distances = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        distances[i][j] = 9999999;
      }
    }
    for (int[] time : times) {
      distances[time[0]][time[1]] = time[2];
    }
    // find all min path
    boolean[] visited = new boolean[N+1];
    for (int i = 1; i <= N; i++) {
      for (int[] time : times) {
        minCosts[time[1]] = Math.min(minCosts[time[0]]+time[2], minCosts[time[1]]);
      }
    }
    // get result
    int result = 0;
    for (int oneCost : minCosts) {
      if (oneCost > 9999999/2) {
        return -1;
      }
      result = Math.max(result, oneCost);
    }
    return result;
  }

}
