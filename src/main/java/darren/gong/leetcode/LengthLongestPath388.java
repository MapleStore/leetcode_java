package darren.gong.leetcode;

import java.util.Stack;

public class LengthLongestPath388 {
  public static void main(String[] args) {
    LengthLongestPath388 lengthLongestPath388 = new LengthLongestPath388();
    lengthLongestPath388.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
  }
  private int result = 0;
  public int lengthLongestPath(String input) {
    dfs(new Stack<>(), 0, input, 0);
    return result;
  }
  private void dfs(Stack<Integer> stack, int currentLength, String input, int index) {
    if (index >= input.length()) {
      return;
    }
    int indexOfPoint = input.indexOf('.', index);
    if (indexOfPoint == -1) {
      return;
    }
    int indexOfNextLine = input.indexOf("\n", index);
    if (indexOfNextLine == -1 || indexOfPoint < indexOfNextLine) {
      indexOfNextLine = indexOfNextLine == -1 ? input.length() : indexOfNextLine;
      result = Math.max(result, currentLength+indexOfNextLine-index+stack.size());
      dfs(stack, currentLength, input, indexOfNextLine);
    } else {
      stack.push(indexOfNextLine-index);
      currentLength += indexOfNextLine-index;

      index = indexOfNextLine;
      index += 1;
      int subNum = 0;
      while (input.charAt(index) == '\t') {
        subNum++;
        index += 1;
      }
      while (stack.size() > subNum) {
        currentLength -= stack.pop();
      }
      dfs(stack, currentLength, input, index);
    }
  }
}
