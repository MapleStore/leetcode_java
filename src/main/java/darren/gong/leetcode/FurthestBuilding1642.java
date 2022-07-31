package darren.gong.leetcode;

import java.util.PriorityQueue;

public class FurthestBuilding1642 {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 1; i < heights.length; i++) {
      int distance = heights[i]-heights[i-1];
      if (distance <= 0) {
        continue;
      }
      queue.add(distance);
      if (queue.size() > ladders) {
        int minDis = queue.poll();
        if (minDis > bricks) {
          return i-1;
        }
        bricks -= minDis;
      }
    }
    return heights.length-1;
  }
}
