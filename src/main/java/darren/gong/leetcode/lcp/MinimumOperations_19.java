package darren.gong.leetcode.lcp;

public class MinimumOperations_19 {
  // LCP 19. 秋叶收藏集
  public static void main(String[] args) {
    MinimumOperations_19 minimumOperations_19 = new MinimumOperations_19();
    minimumOperations_19.minimumOperations("yyy");
  }
  public int minimumOperations(String leaves) {
    int length = leaves.length();
    char[] leavesChar = leaves.toCharArray();
    int[] redCount = new int[length];
    redCount[0] = leavesChar[0] == 'r' ? 1 : 0;
    for (int i = 1; i < length; i++) {
      redCount[i] = redCount[i-1];
      if (leavesChar[i] == 'r') {
        redCount[i]++;
      }
    }
    // j+1-(2*j前红叶个数)
    int maxTwo = Integer.MIN_VALUE;
    int[] maxRight = new int[length];
    for (int i = length-2; i >= 0; i--) {
      maxTwo = Math.max(maxTwo, i+1-2*redCount[i]);
      maxRight[i] = maxTwo;
    }

    // i+1-(2*i前红叶个数)
    int minOne = Integer.MAX_VALUE;
    int result = 9999999;
    for (int i = 0; i < length-2; i++) {
      minOne = Math.min(minOne, i+1-2*redCount[i]);
      result = Math.min(result, minOne-maxRight[i+1]);
    }
    return result+length-redCount[length-1];
  }
}
