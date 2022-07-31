package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BraceExpansionII1096 {
  public static void main(String[] args) {
    BraceExpansionII1096 braceExpansionII1096 = new BraceExpansionII1096();
    braceExpansionII1096.braceExpansionII("{{a,z},a{b,c},{ab,z}}");
  }
  public List<String> braceExpansionII(String expression) {
    List<String> result = new ArrayList<>(braceExpansionHelper(expression));
    Collections.sort(result);
    return result;
  }

  public Set<String> braceExpansionHelper(String expression) {
    StringBuilder sb = new StringBuilder(expression);
    trimBrackets(sb);
    expression = sb.toString();

    Stack<Set<String>> splitResults = new Stack<>();
    char preOp = ',';

    int currentIndex = 0;
    String currentPiece;
    while ((currentPiece = getNextPiece(expression, currentIndex)) != null) {
      currentIndex = currentIndex + currentPiece.length();
      if (currentPiece.contains("{")) {
        Set<String> currentResult = braceExpansionHelper(currentPiece);
        if (preOp == ',') {
          splitResults.add(currentResult);
        } else {
          splitResults.add(merge(splitResults.pop(), currentResult));
        }
        preOp = ' ';
      } else if (currentPiece.equals(",")) {
        preOp = ',';
      } else {
        Set<String> currentResult = new HashSet<>();
        currentResult.add(currentPiece);
        if (preOp == ',') {
          splitResults.add(currentResult);
        } else {
          splitResults.add(merge(splitResults.pop(), currentResult));
        }
        preOp = ' ';
      }
    }
    Set<String> result = new HashSet<>();
    while (!splitResults.isEmpty()) {
      result.addAll(splitResults.pop());
    }
    return result;
  }

  private Set<String> merge(Set<String> pre, Set<String> current) {
    Set<String> merge = new HashSet<>(pre.size());
    for (String lastStr : pre) {
      for (String nextStr : current) {
        merge.add(lastStr+nextStr);
      }
    }
    return merge;
  }

  private void trimBrackets(StringBuilder sb) {
    int length = sb.length();
    int inBrackets = 0;
    if (sb.charAt(0) != '{' || sb.charAt(length-1) != '}') {
      return;
    }
    for (int i = 0; i < length; i++) {
      if (sb.charAt(i) == '{') inBrackets++;
      else if (sb.charAt(i) == '}') inBrackets--;

      if (inBrackets == 0 && i != length-1) {
        return;
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.deleteCharAt(0);
    trimBrackets(sb);
  }

  private String getNextPiece(String expression, int currentIndex) {
    if (currentIndex >= expression.length()) {
      return null;
    }
    char currentChar = expression.charAt(currentIndex);
    if (currentChar == ',') {
      currentIndex++;
      return ",";
    } else if (currentChar == '{') {
      int startIndex = currentIndex;
      int num = 1;
      currentIndex++;
      while (num != 0) {
        if (expression.charAt(currentIndex) == '{') {
          num++;
        } else if (expression.charAt(currentIndex) == '}') {
          num--;
        }
        currentIndex++;
      }
      return expression.substring(startIndex, currentIndex);
    } else {
      StringBuilder result = new StringBuilder();
      while (currentIndex < expression.length() && (currentChar = expression.charAt(currentIndex)) >= 'a' && currentChar <= 'z') {
        result.append(currentChar);
        currentIndex++;
      }
      return result.toString();
    }
  }
}
