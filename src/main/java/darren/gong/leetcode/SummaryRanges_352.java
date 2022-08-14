package darren.gong.leetcode;

import java.util.Comparator;
import java.util.TreeSet;

public class SummaryRanges_352 {
  private TreeSet<int[]> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
  public SummaryRanges_352() {

  }

  public void addNum(int val) {
    add(new int[]{val, val});
  }

  public int[][] getIntervals() {
    return treeSet.toArray(new int[treeSet.size()][]);
  }

  private void add(int[] val) {
    int[] lower = treeSet.floor(val);
    if (lower != null && lower[1] >= val[0]-1) {
      treeSet.remove(lower);
      add(new int[]{lower[0], Math.max(lower[1], val[1])});
      return;
    }
    int[] higher = treeSet.ceiling(val);
    if (higher != null && higher[0] <= val[1]+1) {
      treeSet.remove(higher);
      add(new int[]{val[0], Math.max(higher[1], val[1])});
      return;
    }
    treeSet.add(val);
  }
}
