package darren.gong.leetcode;

public class Vector2D251 {
  private int currentX;
  private int currentY;

  private int maxY;
  private int maxX;
  private int[][] v;
  public Vector2D251(int[][] v) {
    currentX = 0;
    currentY = 0;
    if (v == null || v.length == 0) {
      maxX = 0;
      maxY = 0;
    } else {
      maxX = v.length;
      maxY = v[0].length;
    }
    this.v = v;
  }

  public int next() {
    jumpEmpty();
    return v[currentX][currentY++];
  }

  public boolean hasNext() {
    jumpEmpty();
    return currentX < maxX && currentY < maxY;
  }

  private void jumpEmpty() {
    while (currentX < maxX && currentY >= maxY) {
      currentY = 0;
      currentX++;
      if (currentX < maxX) {
        maxY = v[currentX].length;
      }
    }
  }
}
