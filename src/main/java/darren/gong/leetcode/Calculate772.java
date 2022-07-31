package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculate772 {
  public static void main(String[] args) {
    Calculate772 calculate772 = new Calculate772();
    calculate772.calculate("-2147483648+2147483647");
  }
  private int startIndex = 0;
  private int length = 0;
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    length = s.length();
    String current = null;
    Deque<Integer> num = new ArrayDeque<>();
    Deque<Character> operation = new ArrayDeque<>();
    while ((current = getNextPiece(s)) != null) {
      if ("+".equals(current)) {
        operation.offerLast('+');
      } else if ("-".equals(current)) {
        operation.offerLast('-');
      } else if ("*".equals(current)) {
        operation.offerLast('*');
      } else if ("/".equals(current)) {
        operation.offerLast('/');
      } else if ("(".equals(current)) {
        int currentNum = calculate(s);
        if (num.isEmpty()) {
          num.offerLast(currentNum);
          continue;
        }
        if (operation.peekLast() == '*' || operation.peekLast() == '/') {
          char op = operation.pollLast();
          int pre = num.pollLast();
          if (op == '*') {
            num.offerLast(pre * currentNum);
          } else {
            num.offerLast(pre / currentNum);
          }
        } else {
          num.offerLast(currentNum);
        }
      } else if (")".equals(current)) {
        return countValue(num, operation);
      } else {
        int currentNum = Integer.parseInt(current);
        if (num.isEmpty()) {
          num.offerLast(currentNum);
          continue;
        }
        if (operation.peekLast() == '*' || operation.peekLast() == '/') {
          char op = operation.pollLast();
          int pre = num.pollLast();
          if (op == '*') {
            num.offerLast(pre * currentNum);
          } else {
            num.offerLast(pre / currentNum);
          }
        } else {
          num.offerLast(currentNum);
        }
      }
    }
    return (int)countValue(num, operation);
  }

  private int countValue(Deque<Integer> num, Deque<Character> operation) {
    if (num.isEmpty() && operation.isEmpty()) {
      return 0;
    }
    int pre = num.pollFirst();
    while (!num.isEmpty() && !operation.isEmpty()) {
      char op = operation.pollFirst();
      int nextNum = num.pollFirst();
      if (op == '+') {
        pre = pre + nextNum;
      } else if (op == '-') {
        pre = pre - nextNum;
      }
    }
    return pre;
  }

  private String getNextPiece(String s) {
    StringBuilder sb = new StringBuilder();
    char startChar = ' ';
    while (startIndex < length && (startChar = s.charAt(startIndex)) == ' ') {
      startIndex++;
    }
    if (startIndex == length) {
      return null;
    }
    startIndex++;
    if (startChar == '+') {
      return "+";
    } else if (startChar == '-') {
      return "-";
    } else if (startChar == '*') {
      return "*";
    } else if (startChar == '/') {
      return "/";
    } else if (startChar == '(') {
      return "(";
    } else if (startChar == ')') {
      return ")";
    }
    sb.append(startChar);
    while (startIndex < length && (startChar = s.charAt(startIndex)) <= '9' && startChar >= '0') {
      sb.append(startChar);
      startIndex++;
    }
    return sb.toString();
  }
}
