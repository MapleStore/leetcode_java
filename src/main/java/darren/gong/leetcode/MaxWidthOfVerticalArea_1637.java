package darren.gong.leetcode;

public class MaxWidthOfVerticalArea_1637 {
  public static void main(String[] args) {
    MaxWidthOfVerticalArea_1637 maxWidthOfVerticalArea_1637 = new MaxWidthOfVerticalArea_1637();
    maxWidthOfVerticalArea_1637.maxWidthOfVerticalArea(new int[][]{{8,7},{9,9},{7,4},{9,7}});
  }
  // 1637. 两点之间不包含任何点的最宽垂直面积
  public int maxWidthOfVerticalArea(int[][] points) {
    int length = points.length;
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      array[i] = points[i][0];
    }
    int mask = 1;
    while (mask < 1000000000) {
      int[] count = new int[10];
      for (int num : array) {
        int numInPos = (num/mask)%10;
        count[numInPos]++;
      }
      for (int i = 1; i < 10; i++) {
        count[i] += count[i-1];
      }
      int[] tempArr = new int[length];
      for (int i = length-1; i >= 0; i--) {
        int numInPos = (array[i]/mask)%10;
        tempArr[--count[numInPos]] = array[i];
      }
      array = tempArr;
      mask *= 10;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < length; i++) {
      max = Math.max(max, array[i]-array[i-1]);
    }
    return max;
  }
}
