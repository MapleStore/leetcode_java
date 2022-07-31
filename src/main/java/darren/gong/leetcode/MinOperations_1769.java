package darren.gong.leetcode;

public class MinOperations_1769 {
  public int[] minOperations(String boxes) {
    int length = boxes.length();
    int[] left = new int[length];
    int[] right = new int[length];
    char[] charArr = boxes.toCharArray();
    int num = 0;
    int operation = 0;
    for (int i = 0; i < length; i++) {
      char box = charArr[i];
      operation += num;
      num += box-'0';
      left[i] = operation;
    }
    num = 0;
    operation = 0;
    for (int i = length-1; i >= 0; i--) {
      char box = charArr[i];
      operation += num;
      right[i] = operation;
      num += box-'0';
    }
    for (int i = 0; i < length; i++) {
      left[i] += right[i];
    }
    return left;
  }
}
