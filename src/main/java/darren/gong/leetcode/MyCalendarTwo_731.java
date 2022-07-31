package darren.gong.leetcode;

import java.util.TreeMap;

public class MyCalendarTwo_731 {
  private TreeMap<Integer, Integer> count = new TreeMap<>();
  // 731. 我的日程安排表 II
  public MyCalendarTwo_731() {

  }

  public boolean book(int start, int end) {
    count.put(start, count.getOrDefault(start, 0)+1);
    count.put(end, count.getOrDefault(end, 0)-1);

    int num = 0;
    for (int value : count.values()) {
      num += value;
      if (num >= 3) {
        count.put(start, count.get(start)-1);
        count.put(end, count.get(end)+1);
        if (count.get(start) == 0) {
          count.remove(start);
        }
        if (count.get(end) == 0) {
          count.remove(end);
        }
        return false;
      }
    }
    return true;
  }
}
