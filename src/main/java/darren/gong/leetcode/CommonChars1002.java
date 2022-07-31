package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CommonChars1002 {
  public static void main(String[] args) {
    CommonChars1002 commonChars1002 = new CommonChars1002();
    commonChars1002.commonChars(new String[]{"bella","label","roller"});
  }
  public List<String> commonChars(String[] A) {
    if (A == null || A.length == 0) {
      return new ArrayList<>();
    }
    int length = A.length;
    int[] nums = count(A[0]);
    for (int i = 1; i < length; i++) {
      int[] temp = count(A[i]);
      for (int j = 0; j < 26; j++) {
        nums[j] = Math.min(nums[j], temp[j]);
      }
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      while (nums[i]-- > 0) {
        result.add((char)(i+'a')+"");
      }
    }
    return result;
  }
  private int[] count(String s) {
    char[] arr = s.toCharArray();
    int[] result = new int[26];
    for (char oneChar : arr) {
      result[oneChar-'a']++;
    }
    return result;
  }
}
