package darren.gong.leetcode;

public class NumSplits_1525 {
  public int numSplits(String s) {
    int length = s.length();
    int[] preCount = new int[length];
    int[] postCount = new int[length];
    int[] count = new int[26];
    int diffCount = 0;
    for (int i = 0; i < length; i++) {
      int index = s.charAt(i)-'a';
      if (count[index] == 0) {
        diffCount++;
      }
      count[index]++;
      preCount[i] = diffCount;
    }
    count = new int[26];
    diffCount = 0;
    for (int i = length-1; i >= 0; i--) {
      int index = s.charAt(i)-'a';
      if (count[index] == 0) {
        diffCount++;
      }
      count[index]++;
      postCount[i] = diffCount;
    }
    int result = 0;
    for (int i = 0; i < length-1; i++) {
      if (preCount[i] == postCount[i+1]) {
        result++;
      }
    }
    return result;
  }
}
