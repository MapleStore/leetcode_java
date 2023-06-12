package darren.gong.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformance_1383 {
  public static void main(String[] args) {
    MaxPerformance_1383 maxPerformance_1383 = new MaxPerformance_1383();
    maxPerformance_1383.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 3);
  }
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    int[][] workers = new int[n][2];
    for (int i = 0; i < n; i++) {
      workers[i][0] = speed[i];
      workers[i][1] = efficiency[i];
    }
    Arrays.sort(workers, (a,b)->b[1]-a[1]);
    PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    long value = 0;
    long speeds = 0;
    for (int i = 0; i < n; i++) {
      long e = workers[i][1];
      long currentSpeed = workers[i][0];
      value = Math.max(value, (currentSpeed+speeds)*e);
      priorityQueue.add(currentSpeed);
      speeds += currentSpeed;
      if (priorityQueue.size() > k-1) {
        speeds -= priorityQueue.poll();
      }
    }
    return (int) (value%1000000007);
  }
}
