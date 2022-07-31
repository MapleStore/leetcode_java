package darren.gong.leetcode;

import java.util.TreeMap;

public class IsNStraightHand_846 {
  public static void main(String[] args) {
    IsNStraightHand_846 isNStraightHand_846 = new IsNStraightHand_846();
    isNStraightHand_846.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3);
  }
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int length = hand.length;
    if (length%groupSize != 0) {
      return false;
    }
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int val : hand) {
      treeMap.put(val, treeMap.getOrDefault(val, 0)+1);
    }
    int num = length/groupSize;
    while (num-- > 0) {
      int min = treeMap.firstKey();
      for (int i = 0; i < groupSize; i++) {
        int val = min+i;
        int count = treeMap.getOrDefault(val, 0);
        if (count == 0) {
          return false;
        }
        count--;
        if (count == 0) {
          treeMap.remove(val);
        } else {
          treeMap.put(val, count);
        }
      }
    }
    return true;
  }
}
