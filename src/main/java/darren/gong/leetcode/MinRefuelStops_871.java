package darren.gong.leetcode;

import java.util.PriorityQueue;

public class MinRefuelStops_871 {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    if (startFuel >= target) {
      return 0;
    }
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
    int[][] newStations = new int[stations.length+1][];
    for (int i = 0; i < stations.length; i++) {
      newStations[i] = stations[i];
    }
    newStations[newStations.length-1] = new int[]{target, 0};
    stations = newStations;
    int result = 0;
    for (int[] station : stations) {
      while (station[0] > startFuel) {
        if (priorityQueue.isEmpty()) {
          return -1;
        }
        startFuel += priorityQueue.poll();
        result++;
        if (startFuel >= target) {
          return result;
        }
      }
      priorityQueue.add(station[1]);
    }
    return -1;
  }
}
