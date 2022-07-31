package darren.gong.leetcode;

import java.util.Arrays;

public class MaxArea_1465 {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);

    int preHorizontal = 0;
    int maxH = 0;
    for (int horizontal : horizontalCuts) {
      maxH = Math.max(maxH, horizontal-preHorizontal);
      preHorizontal = horizontal;
    }
    maxH = Math.max(maxH, h-preHorizontal);

    int preVertical = 0;
    int maxWidth = 0;
    for (int vertical : verticalCuts) {
      maxWidth = Math.max(maxWidth, vertical-preVertical);
      preVertical = vertical;
    }
    maxWidth = Math.max(maxWidth, w-preVertical);
    return (int)(((long)maxH*(long)maxWidth)%(1000000000L+7));
  }
}
