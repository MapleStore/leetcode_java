package darren.gong.leetcode;

public class MaxDepthAfterSplit_1111 {
  public int[] maxDepthAfterSplit(String seq) {
    int maxDep = 0;
    int count = 0;
    for (char oneChar : seq.toCharArray()) {
      if (oneChar == '(') {
        count++;
        maxDep = Math.max(maxDep, count);
      } else {
        count--;
      }
    }

    int groupCount = maxDep/2;
    count = 0;
    int length = seq.length();
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      if (seq.charAt(i) == '(') {
        count++;
        if (count > groupCount) {
          result[i] = 1;
        }
      } else {
        if (count > groupCount) {
          result[i] = 1;
        }
        count--;
      }
    }
    return result;
  }
}
