package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Calculate772 {
  public static void main(String[] args) {
    Calculate772 calculate772 = new Calculate772();
    calculate772.calculate1("2*(5+5*2)/3+(6/2+8)");
    //calculate772.calculate("-2147483648+2147483647");
  }

  public int calculate1(String s) {
    List<String> suffix = new ArrayList<>();
    Stack<Character> ops = new Stack<>();
    int index = 0;
    while (index < s.length()) {
      char current = s.charAt(index);
      if (current >= '0' && current <= '9') {
        String num = readNum(index, s);
        suffix.add(num);
        index += num.length();
      } else if (current == '(') {
        ops.push(current);
        index++;
      } else if (current == ')') {
        while (ops.peek() != '(') {
          suffix.add(ops.pop()+"");
        }
        ops.pop();
        index++;
      } else if (current == '+' || current == '-') {
        while (!ops.isEmpty() && ops.peek() != '(') {
          suffix.add(ops.pop()+"");
        }
        ops.push(current);
        index++;
      } else {
        while (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
          suffix.add(ops.pop()+"");
        }
        ops.push(current);
        index++;
      }
    }
    while (!ops.isEmpty()) {
      suffix.add(ops.pop()+"");
    }
    Stack<Integer> nums = new Stack<>();
    for (String current : suffix) {
      if (current.equals("*")) {
        int num2 = nums.pop();
        int num1 = nums.isEmpty() ? 0 : nums.pop();
        nums.push(num1*num2);
      } else if (current.equals("/")) {
        int num2 = nums.pop();
        int num1 = nums.isEmpty() ? 0 : nums.pop();
        nums.push(num1/num2);
      } else if (current.equals("+")) {
        int num2 = nums.pop();
        int num1 = nums.isEmpty() ? 0 : nums.pop();
        nums.push(num1+num2);
      } else if (current.equals("-")) {
        int num2 = nums.pop();
        int num1 = nums.isEmpty() ? 0 : nums.pop();
        nums.push(num1-num2);
      } else {
        nums.push(Integer.parseInt(current));
      }
    }
    return nums.pop();
  }
  private String readNum(int index, String s) {
    StringBuilder sb = new StringBuilder();
    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
      sb.append(s.charAt(index++));
    }
    return sb.toString();
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
