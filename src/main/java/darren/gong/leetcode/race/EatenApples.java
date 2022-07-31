package darren.gong.leetcode.race;

import java.util.PriorityQueue;

public class EatenApples {
  public static void main(String[] args) {
    EatenApples eatenApples = new EatenApples();
    eatenApples.eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2});
  }
  private class Entry {
    private int apples;
    private int overTime;
    private Entry(int apples, int overTime) {
      this.apples = apples;
      this.overTime = overTime;
    }
  }
  public int eatenApples(int[] apples, int[] days) {
    PriorityQueue<Entry> priorityQueue = new PriorityQueue<>((a, b)->{
      return a.overTime-b.overTime;
    });
    if (apples == null || apples.length == 0) {
      return 0;
    }
    int n = apples.length;
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (apples[i] != 0) {
        priorityQueue.add(new Entry(apples[i], i+days[i]));
      }

      while (!priorityQueue.isEmpty() && priorityQueue.peek().overTime <= i) {
        priorityQueue.poll();
      }
      if (priorityQueue.isEmpty()) {
        continue;
      }
      Entry current = priorityQueue.peek();
      current.apples -= 1;
      result++;
      if (current.apples == 0) {
        priorityQueue.poll();
      }
    }
    int i = n;
    while (!priorityQueue.isEmpty()) {
      while (!priorityQueue.isEmpty() && priorityQueue.peek().overTime <= i) {
        priorityQueue.poll();
      }
      if (priorityQueue.isEmpty()) {
        break;
      }
      Entry current = priorityQueue.peek();
      current.apples -= 1;
      result++;
      if (current.apples == 0) {
        priorityQueue.poll();
      }
      i++;
    }
    return result;
  }
}
