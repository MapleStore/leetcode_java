package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddOperators282 {
  private int length = 0;
  private String num = "";
  private int targetValue = 0;
  private int intLength = (Integer.MAX_VALUE+"").length();
  public List<String> addOperators(String num, int target) {
    length = num.length();
    targetValue = target;
    this.num = num;
    List<String> result = new LinkedList<>();
    for (int i = 1; i <= length && i <= intLength; i++) {
      String currentNumString = num.substring(0, i);
      if (currentNumString.length() > 1 && currentNumString.startsWith("0")) {
        break;
      }
      long currentNum = Long.parseLong(currentNumString);
      if (currentNum > Integer.MAX_VALUE) {
        break;
      }
      backTracking(i, (int) currentNum, (int) currentNum, ' ', new StringBuilder().append(currentNumString), result);
    }
    return result;
  }
  private void backTracking(int currentIndex, int currentValue, int lastNum, char lastOp, StringBuilder oneResult, List<String> result) {
    if (currentIndex == length) {
      if (currentValue == targetValue) {
        result.add(oneResult.toString());
      }
      return;
    }

    for (int i = currentIndex+1; i <= length && i <= intLength; i++) {
      String currentNumString = num.substring(currentIndex, i);
      if (currentNumString.length() > 1 && currentNumString.startsWith("0")) {
        break;
      }
      long currentNum = Long.parseLong(currentNumString);
      if (currentNum > Integer.MAX_VALUE) {
        break;
      }
      // +
      if ((long)currentValue+currentNum <= Integer.MAX_VALUE) {
        backTracking(i, (int) (currentValue+currentNum), (int) currentNum, '+', oneResult.append('+').append(currentNumString), result);
        oneResult.delete(oneResult.length()-currentNumString.length()-1, oneResult.length());
      }
      // -
      if (currentValue-currentNum >= Integer.MIN_VALUE) {
        backTracking(i, (int) (currentValue-currentNum), (int) currentNum, '-', oneResult.append('-').append(currentNumString), result);
        oneResult.delete(oneResult.length()-currentNumString.length()-1, oneResult.length());
      }
      // *
      long newLastNum = (long)lastNum*currentNum;
      long nextValue;
      if (lastOp == '-') {
        nextValue = (long)currentValue+(long)lastNum-newLastNum;
      } else if (lastOp == '+') {
        nextValue = (long)currentValue-(long)lastNum+newLastNum;
      } else {
        nextValue = newLastNum;
      }
      if (nextValue >= Integer.MIN_VALUE && nextValue <= Integer.MAX_VALUE) {
        backTracking(i, (int)nextValue, (int) newLastNum, lastOp, oneResult.append('*').append(currentNumString), result);
        oneResult.delete(oneResult.length()-currentNumString.length()-1, oneResult.length());
      }
    }
  }
}
