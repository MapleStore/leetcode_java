package darren.gong.leetcode;

import java.util.PriorityQueue;

public class CarPooling_1094 {
  // 1094. 拼车
  public boolean carPooling(int[][] trips, int capacity) {
    PriorityQueue<int[]> up = new PriorityQueue<>((a,b)->a[0]-b[0]);
    PriorityQueue<int[]> down = new PriorityQueue<>((a,b)->a[0]-b[0]);
    for (int[] trip : trips) {
      up.add(new int[]{trip[1], trip[0]});
      down.add(new int[]{trip[2], trip[0]});
    }
    int peopleInCar = 0;
    while (!up.isEmpty()) {
      int[] oneUp = up.poll();
      while (!down.isEmpty() && down.peek()[0] <= oneUp[0]) {
        int[] currentDown = down.poll();
        peopleInCar -= currentDown[1];
      }
      if (peopleInCar+oneUp[1] > capacity) {
        return false;
      }
      peopleInCar += oneUp[1];
    }
    return true;
  }
}
