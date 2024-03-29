package darren.gong.leetcode;

public class CanMeasureWater365 {
  public boolean canMeasureWater(int x, int y, int z) {
    if (x+y < z) {
      return false;
    }
    if (x == 0 && y == 0) {
      return z == 0;
    }
    if (x == 0) {
      return z%y == 0;
    }
    if (y == 0) {
      return z%x == 0;
    }

    return z%gcd(x, y) == 0;
  }
  private int gcd(int x, int y) {
    int remainder = x%y;
    while (remainder != 0) {
      x = y;
      y = remainder;
      remainder = x%y;
    }
    return y;
  }
}
