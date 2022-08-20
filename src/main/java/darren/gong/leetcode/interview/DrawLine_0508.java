package darren.gong.leetcode.interview;

public class DrawLine_0508 {
  public static void main(String[] args) {
    DrawLine_0508 drawLine_0508 = new DrawLine_0508();
    drawLine_0508.drawLine(15, 96, 81, 95, 1);
  }
  public int[] drawLine(int length, int w, int x1, int x2, int y) {
    int oneLineInt = w/32;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      int line = i/oneLineInt;
      if (line != y) {
        result[i] = 0;
        continue;
      }
      int current = 0;
      for (int j = 0; j < 32; j++) {
        int pos = (i-(y*oneLineInt))*32+j;
        if (pos >= x1 && pos <= x2) {
          current |= (1<<(31-j));
        }
      }
      result[i] = current;
    }
    return result;
  }
}
