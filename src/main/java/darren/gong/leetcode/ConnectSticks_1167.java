package darren.gong.leetcode;

import java.util.PriorityQueue;

public class ConnectSticks_1167 {
  // 1167. 连接棒材的最低费用
  public int connectSticks(int[] sticks) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int stick : sticks) {
      priorityQueue.add(stick);
    }
    int result = 0;
    while (priorityQueue.size() >= 2) {
      int current = priorityQueue.poll()+priorityQueue.poll();
      result += current;
      priorityQueue.add(current);
    }
    return result;
  }
}
