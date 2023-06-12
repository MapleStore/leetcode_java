package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleCourse_630 {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->b[0]-a[0]);
    int cost = 0;
    int num = 0;
    for (int[] course : courses) {
      int deadline = course[1];
      if (deadline-cost < course[0]) {
        if (priorityQueue.size() > 0 && priorityQueue.peek()[0] > course[0]) {
          int[] remove = priorityQueue.poll();
          cost -= remove[0];
          num--;
        }
      }
      if (deadline-cost >= course[0]) {
        priorityQueue.add(course);
        cost += course[0];
        num++;
      }
    }
    return num;
  }
}
