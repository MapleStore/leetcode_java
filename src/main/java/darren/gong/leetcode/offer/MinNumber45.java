package darren.gong.leetcode.offer;

import java.util.Arrays;

public class MinNumber45 {
  public String minNumber(int[] nums) {
    int length = nums.length;
    String[] strings = new String[length];
    for (int i = 0; i < length; i++) {
      strings[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strings, (a,b)->(a+b).compareTo(b+a));
    StringBuilder sb = new StringBuilder();
    for (String value : strings) {
      sb.append(value);
    }
    return sb.toString();
  }
}
