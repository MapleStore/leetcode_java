package darren.gong.leetcode;

import java.util.Arrays;

public class MaxBoxesInWarehouse_1564 {
  // 1564. 把箱子放进仓库里 I
  public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
    Arrays.sort(boxes);
    int houseLength = warehouse.length;
    int boxLength = boxes.length;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < houseLength; i++) {
      if (warehouse[i] < min) {
        min = warehouse[i];
      }
      warehouse[i] = min;
    }
    int boxIndex = 0;
    for (int fillIndex = houseLength-1; fillIndex >= 0 && boxIndex < boxLength; fillIndex--) {
      int currentHeight = warehouse[fillIndex];
      if (boxes[boxIndex] <= currentHeight) {
        boxIndex++;
      }
    }
    return boxIndex;
  }
}
