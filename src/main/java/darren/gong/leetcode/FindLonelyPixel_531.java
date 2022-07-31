package darren.gong.leetcode;

public class FindLonelyPixel_531 {
  // 531. 孤独像素 I
  public int findLonelyPixel(char[][] picture) {
    int maxX = picture.length;
    int maxY = picture[0].length;
    int[] lines = new int[maxX];
    int[] cols = new int[maxY];

    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (picture[i][j] == 'B') {
          lines[i]++;
          cols[j]++;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (picture[i][j] == 'B' && lines[i] == 1 && cols[j] == 1) {
          result++;
        }
      }
    }
    return result;
  }
}
