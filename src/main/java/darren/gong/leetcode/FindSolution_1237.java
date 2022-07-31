package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindSolution_1237 {
  // 1237. 找出给定方程的正整数解
  interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y);
  };
  // 二分法
  public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
    List<List<Integer>> result = new LinkedList<>();
    for (int i = 1; i <= 1000; i++) {
      int left = 1;
      int right = 1000;
      while (left <= right) {
        int mid = left+((right-left)>>>1);
        int value = customfunction.f(i, mid);
        if (value == z) {
          result.add(Arrays.asList(i, mid));
          break;
        } else if (value > z) {
          right = mid-1;
        } else {
          left = mid+1;
        }
      }
    }
    return result;
  }
  // 双指针
  public List<List<Integer>> findSolution2(CustomFunction customfunction, int z) {
    List<List<Integer>> result = new LinkedList<>();
    int left = 1;
    int right = 1000;
    while (left <= 1000 && right >= 1) {
      int value = customfunction.f(left, right);
      if (value == z) {
        result.add(Arrays.asList(left, right));
        left++;
        right--;
      } else if (value > z) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }
}
