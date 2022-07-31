package darren.gong.leetcode;

import java.util.TreeSet;

public class KEmptySlots683 {
  public static void main(String[] args) {
    KEmptySlots683 kEmptySlots683 = new KEmptySlots683();
    kEmptySlots683.kEmptySlots(new int[]{10,1,9,3,5,7,6,4,8,2
    }, 8);
  }
  public int kEmptySlots(int[] bulbs, int k) {
    int length = bulbs.length;
    if (length == 1) {
      return -1;
    }
    int[] bulbsToOpenDay = new int[length+1];
    // bulbsToOpenDay 下标1~length是有效值 0不表示灯泡
    for (int i = 0; i < length; i++) {
      bulbsToOpenDay[bulbs[i]] = i+1;
    }

    int left = 1;
    int right = left;
    int[] minDay = new int[length+1];
    for (int i = 1; i <= length; i++) {
      minDay[i] = Integer.MAX_VALUE;
    }
    TreeSet<Integer> treeSet = new TreeSet<>();
    while (k != 0 && right <= length) {
      treeSet.add(bulbsToOpenDay[right]);
      if (left+k-1 < right) {
        treeSet.remove(bulbsToOpenDay[left]);
        left++;
      }
      if (left+k-1 == right) {
        minDay[left] = treeSet.isEmpty() ? Integer.MAX_VALUE : treeSet.first();
      }
      right++;
    }

    for (int i = 0; i < length; i++) {
      int bulb = bulbs[i];
      int leftBulb = bulb-k-1;
      int rightBulb = bulb+k+1;
      if (leftBulb >= 1 && bulbsToOpenDay[leftBulb] < i+1 && minDay[leftBulb+1] > i+1 && minDay[leftBulb+1] > bulbsToOpenDay[leftBulb]) {
        return i+1;
      }
      if (rightBulb <= length && bulbsToOpenDay[rightBulb] < i+1 && minDay[bulb+1] > i+1 && minDay[bulb+1] > bulbsToOpenDay[rightBulb]) {
        return i+1;
      }
    }
    return -1;
  }
}
