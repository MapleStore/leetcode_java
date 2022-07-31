package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AssignBikes_1057 {
  // 1057. 校园自行车分配
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    int workerLength = workers.length;
    int bikeLength = bikes.length;
    int[] result = new int[workerLength];
    boolean[] workerVisited = new boolean[workerLength];
    boolean[] bikeVisited = new boolean[bikeLength];
    Queue<int[]>[] distances = new Queue[2002];

    for (int workerIndex = 0; workerIndex < workerLength; workerIndex++) {
      for (int bikeIndex = 0; bikeIndex < bikeLength; bikeIndex++) {
        int dis = countDis(workers[workerIndex], bikes[bikeIndex]);
        if (distances[dis] == null) {
          distances[dis] = new LinkedList<>();
        }
        distances[dis].add(new int[]{workerIndex, bikeIndex});
      }
    }

    for (Queue<int[]> oneDis : distances) {
      if (oneDis == null) {
        continue;
      }
      while (!oneDis.isEmpty()) {
        int[] pair = oneDis.poll();
        if (!bikeVisited[pair[1]] && !workerVisited[pair[0]]) {
          result[pair[0]] = pair[1];
          workerVisited[pair[0]] = true;
          bikeVisited[pair[1]] = true;
        }
      }
    }
    return result;
  }
  private int countDis(int[] worker, int[] bike) {
    return Math.abs(worker[0]-bike[0])+Math.abs(worker[1]-bike[1]);
  }
}
