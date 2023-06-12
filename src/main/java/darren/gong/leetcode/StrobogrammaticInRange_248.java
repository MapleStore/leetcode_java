package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticInRange_248 {
  public static void main(String[] args) {
    StrobogrammaticInRange_248 strobogrammaticInRange_248 = new StrobogrammaticInRange_248();
    strobogrammaticInRange_248.strobogrammaticInRange("11", "69");
  }
  private static char[][] nums = new char[][]{{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
  private static Map<Character, Character> map = new HashMap<>();
  static {
    map.put('0', '0');
    map.put('1', '1');
    map.put('6', '9');
    map.put('8', '8');
    map.put('9', '6');
  }
  public int strobogrammaticInRange(String low, String high) {
    if (high.equals("0")) {
      return 1;
    }
    if (low.equals("0")) {
      return strobogrammaticInRange(high);
    }
    return strobogrammaticInRange(high)-strobogrammaticInRange(String.valueOf(Integer.parseInt(low)-1));
  }
  private int strobogrammaticInRange(String high) {
    int result = 0;
    for (int count = 1; count < high.length(); count++) {
      result += count(get9(count), true);
    }
    result += count(high, true);
    return result;
  }
  private int count(String high, boolean start) {
    if (high.length() == 1) {
      int result = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i][0] <= high.charAt(0) && nums[i][0] == nums[i][1]) {
          result++;
        }
      }
      return result;
    }
    int result = 0;
    for (char[] num : nums) {
      if (num[0] == '0' && start) {
        continue;
      }
      String mid = high.substring(1, high.length()-1);
      if (num[0] < high.charAt(0)) {
        result += mid.length() == 0 ? 1 : count(get9(mid.length()), false);
      } else if (num[0] == high.charAt(0)) {
        result += mid.length() == 0 ? 1 : count(mid, false);
        if (num[1] > high.charAt(high.length()-1) && valid(mid)) {
          result -= 1;
        }
      }
    }
    return result;
  }
  private String get9(int num) {
    StringBuilder sb = new StringBuilder();
    while (num-- > 0) {
      sb.append("9");
    }
    return sb.toString();
  }
  private boolean valid(String value) {
    if (value.length() == 0) {
      return true;
    }
    int left = 0;
    int right = value.length()-1;
    while (left <= right) {
      if (!map.containsKey(value.charAt(left)) || map.get(value.charAt(left)) != value.charAt(right)) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }
}
