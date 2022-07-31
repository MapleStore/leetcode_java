package darren.gong.leetcode;

import java.util.PriorityQueue;

public class SeatManager_1845 {
  private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
  private int currentIndex = 1;
  public SeatManager_1845(int n) {

  }

  public int reserve() {
    if (priorityQueue.isEmpty()) {
      return currentIndex++;
    }
    return priorityQueue.poll();
  }

  public void unreserve(int seatNumber) {
    priorityQueue.add(seatNumber);
  }
}
