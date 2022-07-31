package darren.gong.leetcode;

public class PourWater_755 {
  public int[] pourWater(int[] heights, int V, int K) {
    while (V-- > 0) {
      int currentIndex = K;
      int fillIndex = K;
      while (currentIndex > 0 && heights[currentIndex-1] <= heights[currentIndex]) {
        if (heights[currentIndex-1] < heights[currentIndex]) {
          fillIndex = currentIndex-1;
        }
        currentIndex--;
      }
      if (fillIndex != K) {
        heights[fillIndex]++;
        continue;
      }

      currentIndex = K;
      fillIndex = K;
      while (currentIndex < heights.length-1 && heights[currentIndex+1] <= heights[currentIndex]) {
        if (heights[currentIndex+1] < heights[currentIndex]) {
          fillIndex = currentIndex+1;
        }
        currentIndex++;
      }
      heights[fillIndex]++;
    }
    return heights;
  }
}
