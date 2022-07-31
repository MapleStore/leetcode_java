package darren.gong.leetcode;

public class MinSwaps_1864 {
  public int minSwaps(String s) {
    char[] chars = s.toCharArray();
    int num1 = 0;
    for (char oneChar : chars) {
      num1 += oneChar-'0';
    }
    int num0 = chars.length-num1;
    if (Math.abs(num0-num1) > 1) {
      return -1;
    }
    int startWith0Diff = 0;
    int currentNum = 0;
    for (char oneChar : chars) {
      if (currentNum != oneChar-'0') {
        startWith0Diff++;
      }
      currentNum = 1-currentNum;
    }
    int startWith1Diff = 0;
    currentNum = 1;
    for (char oneChar : chars) {
      if (currentNum != oneChar-'0') {
        startWith1Diff++;
      }
      currentNum = 1-currentNum;
    }
    int result = Integer.MAX_VALUE;
    if (startWith0Diff % 2 == 0) {
      result = (startWith0Diff>>>1);
    }
    if (startWith1Diff % 2 == 0) {
      result = Math.min(result, (startWith1Diff>>>1));
    }
    return result;
  }
}
