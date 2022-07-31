package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SequentialDigits_1291 {
  public static void main(String[] args) {
    SequentialDigits_1291 sequentialDigits_1291 = new SequentialDigits_1291();
    sequentialDigits_1291.sequentialDigits(100, 300);
  }
  private static List<Integer> result = new LinkedList<>();
  static {
    for (int i = 0; i <= 9; i++) {
      result.add(i);
    }

    // length
    for (int i = 2; i <= 10; i++) {
      for (int startNum = 1; startNum < 9; startNum++) {
        long oneResult = startNum;
        boolean invalid = false;
        for (int pos = 1; pos < i; pos++) {
          long current = startNum+pos;
          if (current > 9) {
            invalid = true;
            break;
          }
          oneResult = oneResult*10+current;
        }
        if (invalid) {
          break;
        }
        result.add((int)oneResult);
      }
    }

  }
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> realResult = new LinkedList<>();
    for (int value : result) {
      if (value > high) {
        break;
      }
      if (value >= low) {
        realResult.add(value);
      }
    }
    return realResult;
  }
}
