package darren.gong.leetcode;

public class NumSteps1404 {
  public int numSteps(String s) {
    char[] arr = s.toCharArray();
    int result = 0;
    int length = arr.length;
    boolean increase = false;
    for (int i = length-1; i >= 0; i--) {
      if (arr[i] == '0') {
        result += (increase ? 2 : 1);
      } else {
        if (!increase) {
          if (i != 0) {
            result += 2;
          }
          increase = true;
        } else {
          result++;
        }
      }
    }
    return result;
  }
}
