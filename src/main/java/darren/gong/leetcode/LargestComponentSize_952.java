package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSize_952 {
  public static void main(String[] args) {
    LargestComponentSize_952 largestComponentSize_952 = new LargestComponentSize_952();
    largestComponentSize_952.largestComponentSize(new int[]{2,3,6,7,4,12,21,39});
  }
  private int[] parents;
  private int[] numParents;
  public int largestComponentSize(int[] nums) {
    int length = nums.length;
    // factor merge
    parents = new int[Arrays.stream(nums).max().getAsInt()+1];
    // num index merge
    numParents = new int[length];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }
    for (int i = 0; i < length; i++) {
      numParents[i] = i;
    }

    for (int index = 0; index < length; index++) {
      int currentNum = nums[index];
      for (int factor = 2; factor*factor <= currentNum; factor++) {
        if (nums[index] % factor == 0) {
          merge(factor, currentNum);
          merge(nums[index]/factor, currentNum);
        }
      }
      numParents[index] = currentNum;
    }

    Map<Integer, Integer> results = new HashMap<>();
    for (int i = 0; i < length; i++) {
      results.put(getParent(numParents[i]), results.getOrDefault(getParent(numParents[i]), 0)+1);
    }
    int result = Integer.MIN_VALUE;
    for (int val : results.values()) {
      result = Math.max(result, val);
    }
    return result;
  }
  private void merge(int num1, int num2) {
    if (parents[num1] == parents[num2]) {
      return;
    }
    parents[getParent(num1)] = getParent(num2);
  }
  private int getParent(int num) {
    if (parents[num] == num) {
      return num;
    }
    parents[num] = getParent(parents[num]);
    return parents[num];
  }
}
