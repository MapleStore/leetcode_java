package darren.gong.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Candy135 {
  public int candyGreed(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    int length = ratings.length;
    int[] candy = new int[length];
    Arrays.fill(candy, 1);
    for (int i = 1; i < length; i++) {
      if (ratings[i] > ratings[i-1]) {
        candy[i] = candy[i-1]+1;
      }
    }
    for (int i = length-2; i >= 0; i--) {
      if (ratings[i] > ratings[i+1]) {
        candy[i] = Math.max(candy[i], candy[i+1]+1);
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      result += candy[i];
    }
    return result;
  }

  private class Entry {
    private int index;
    private int value;
    private Entry(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    int length = ratings.length;
    PriorityQueue<Entry> queue = new PriorityQueue<>((a, b)->{
      return a.value-b.value;
    });
    int[] candy = new int[length];
    for (int i = 0; i < length; i++) {
      queue.add(new Entry(i, ratings[i]));
    }
    while (!queue.isEmpty()) {
      Entry entry = queue.poll();
      int index = entry.index;
      int value = entry.value;
      int leftValue = index-1 < 0 ? Integer.MIN_VALUE : ratings[index-1];
      int rightValue = index+1 >= length ? Integer.MIN_VALUE : ratings[index+1];
      int leftCandy = index-1 < 0 ? 0 : candy[index-1];
      int rightCandy = index+1 >= length ? 0 : candy[index+1];

      if (value > Math.max(leftValue, rightValue)) {
        candy[index] = Math.max(leftCandy, rightCandy)+1;
      } else if (value > leftValue) {
        candy[index] = leftCandy+1;
      } else if (value > rightValue) {
        candy[index] = rightCandy+1;
      } else {
        candy[index] = 1;
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      result += candy[i];
    }
    return result;
  }
}
