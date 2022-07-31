package darren.gong.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountSteppingNumbers_1215 {
  // 1215. 步进数
  private LinkedList<Integer> result = new LinkedList<>();
  public List<Integer> countSteppingNumbers(int low, int high) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    while (!queue.isEmpty()) {
      long currentNum = queue.poll();

      long lastNum = currentNum%10;
      for (int i = 0; i <= 9; i++) {
        if (currentNum == 0 || i == lastNum-1 || i == lastNum+1) {
          long next = currentNum*10+i;
          if (next > high) {
            break;
          }
          result.add((int)next);
          if (i == 0 && currentNum == 0) {
            continue;
          }
          queue.add((int)next);
        }
      }
    }

    Iterator<Integer> iterator = result.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() < low) {
        iterator.remove();
      } else {
        break;
      }
    }
    return result;
  }
}
