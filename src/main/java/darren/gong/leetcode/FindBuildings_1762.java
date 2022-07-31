package darren.gong.leetcode;

public class FindBuildings_1762 {
  // 1762. 能看到海景的建筑物
  public int[] findBuildings(int[] heights) {
    int length = heights.length;
    boolean[] canSee = new boolean[length];
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (int i = length-1; i >= 0; i--) {
      if (heights[i] > max) {
        canSee[i] = true;
        count++;
        max = heights[i];
      }
    }
    int[] result = new int[count];
    int resultIndex = 0;
    for (int i = 0; i < length; i++) {
      if (canSee[i]) {
        result[resultIndex++] = i;
      }
    }
    return result;
  }
}
