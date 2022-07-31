package darren.gong.leetcode;

import java.util.Arrays;

public class OriginalDigits_423 {
  // 423. 从英文中重建数字
  public static void main(String[] args) {
    OriginalDigits_423 originalDigits_423 = new OriginalDigits_423();
    originalDigits_423.originalDigits("nnei");
  }
  private int[] order = new int[]{'z', 'w', 'x', 'u', 'r', 'f', 'v', 'g', 'o', 'e'};
  private String[][] nums = new String[][]{{"zero", "0"}, {"two", "2"}, {"six", "6"}, {"four", "4"}, {"three", "3"},
          {"five", "5"}, {"seven", "7"}, {"eight", "8"}, {"one", "1"}, {"nine", "9"}};
  public String originalDigits(String s) {
    // zero:z
    // two:w
    // six:x
    // four:u
    // three:r
    // five:f
    // seven:v
    // eight:g
    // one:o
    // nine:e
    int[] all = count(s);
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      int times = all[order[i]-'a'];
      int[] currentCount = count(nums[i][0]);
      for (int j = 0; j < 26; j++) {
        all[j] -= currentCount[j]*times;
      }
      while (times-- > 0) {
        result.append(nums[i][1]);
      }
    }
    char[] resultArr = result.toString().toCharArray();
    Arrays.sort(resultArr);
    return new String(resultArr);
  }
  private int[] count(String s) {
    int[] count = new int[26];
    for (char oneChar : s.toCharArray()) {
      count[oneChar-'a']++;
    }
    return count;
  }
}
