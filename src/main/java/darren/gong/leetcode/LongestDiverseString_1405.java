package darren.gong.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class LongestDiverseString_1405 {
  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((e1, e2)->e2[1]-e1[1]);
    if (a > 0) {
      priorityQueue.add(new int[]{'a', a});
    }
    if (b > 0) {
      priorityQueue.add(new int[]{'b', b});
    }
    if (c > 0) {
      priorityQueue.add(new int[]{'c', c});
    }
    StringBuilder sb = new StringBuilder();
    int count = 0;
    char currentChar = ' ';
    while (true) {
      PriorityQueue<int[]> next = new PriorityQueue<>((e1, e2)->e2[1]-e1[1]);
      int[] current = null;
      while (!priorityQueue.isEmpty()) {
        int[] temp = priorityQueue.poll();
        if (temp[0] != currentChar) {
          count = 1;
          current = temp;
          break;
        }
        if (count < 2) {
          count++;
          current = temp;
          break;
        }
        next.add(temp);
      }
      if (current == null) {
        break;
      }
      currentChar = (char)current[0];
      sb.append(currentChar);
      if (current[1] > 1) {
        next.add(new int[]{current[0], current[1]-1});
      }
      next.addAll(priorityQueue);
      priorityQueue = next;
    }
    return sb.toString();
  }
}
