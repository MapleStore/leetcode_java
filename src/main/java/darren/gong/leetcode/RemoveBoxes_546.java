package darren.gong.leetcode;

public class RemoveBoxes_546 {
  public static void main(String[] args) {
    RemoveBoxes_546 removeBoxes_546 = new RemoveBoxes_546();
    removeBoxes_546.removeBoxes(new int[]{1,3,2,2,2,3,4,3,1});
  }
  public int removeBoxes(int[] boxes) {
    int length = boxes.length;
    int[][] dp = new int[length][length];
    for (int distance = 1; distance <= length; distance++) {
      for (int left = 0; left < length; left++) {
        int right = left+distance-1;
        if (right >= length) {
          break;
        }
        if (distance == 1) {
          dp[left][right] = 1;
          continue;
        }
        for (int split = left; split < right; split++) {
          int leftRange = getLeftLimit(boxes, split, left);
          int rightRange = getRightLimit(boxes, split, right);
          int leftValue = leftRange <= left ? 0 : dp[left][leftRange-1];
          int rightValue = rightRange >= right ? 0 : dp[rightRange+1][right];
          dp[left][right] = Math.max(dp[left][right],
              Math.max(dp[left][split]+dp[split+1][right],
                  leftValue+rightValue+(rightRange-leftRange+1)*(rightRange-leftRange+1)));
        }
      }
    }
    return dp[0][length-1];
  }
  private int getLeftLimit(int[] boxes, int index, int left) {
    int result = index;
    while (result >= left && boxes[result] == boxes[index]) result--;
    return result+1;
  }
  private int getRightLimit(int[] boxes, int index, int right) {
    int result = index;
    while (result <= right && boxes[result] == boxes[index]) result++;
    return result-1;
  }
}
