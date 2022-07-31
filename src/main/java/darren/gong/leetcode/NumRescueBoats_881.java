package darren.gong.leetcode;

import java.util.Arrays;

public class NumRescueBoats_881 {
  // 881. 救生艇
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int length = people.length;
    int left = 0;
    int right = length-1;
    int result = 0;
    while (left <= right) {
      result++;
      int remain = limit-people[right];
      right--;
      if (left <= right && remain >= people[left]) {
        left++;
      }
    }
    return result;
  }
}
