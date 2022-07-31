package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAvailableDuration1229 {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    int index1 = 0;
    int index2 = 0;
    int length1 = slots1.length;
    int length2 = slots2.length;
    Arrays.sort(slots1, (a, b)->a[0]-b[0]);
    Arrays.sort(slots2, (a, b)->a[0]-b[0]);
    while (index1 < length1 && index2 < length2) {
      int[] slot1 = slots1[index1];
      int[] slot2 = slots2[index2];
      if (slot1[1] < slot2[0]) {
        index1++;
        continue;
      }
      if (slot1[0] > slot2[1]) {
        index2++;
        continue;
      }
      int start = Math.max(slot1[0], slot2[0]);
      int end = Math.min(slot1[1], slot2[1]);
      if (end-start >= duration) {
        return Arrays.asList(start, start+duration);
      }
      if (end == slot1[1]) {
        index1++;
      } else {
        index2++;
      }
    }
    return new ArrayList<>();
  }
}
