package darren.gong.leetcode;

public class ValidUtf8_393 {
  public static void main(String[] args) {
    ValidUtf8_393 validUtf8_393 = new ValidUtf8_393();
    validUtf8_393.validUtf8(new int[]{197, 130, 1});
  }
  private static int[][] masks =
      new int[][]{new int[]{0x000000000, 0x00007F}, new int[]{0x000000C0, 0x000000DF}, new int[]{0x000000E0, 0x000000EF}, new int[]{0x000000F0, 0x000000F7}};
  public boolean validUtf8(int[] data) {
    int index = 0;
    int length = data.length;
    while (index < length) {
      int i;
      for (i = 0; i < 4; i++) {
        if (data[index] >= masks[i][0] && data[index] <= masks[i][1]) {
          break;
        }
        if (i == 3) return false;
      }
      int end = index+i;
      for (index = index+1; index <= end; index++) {
        if (index >= length || (data[index]&0x00000080) != 0x00000080) {
          return false;
        }
      }
    }
    return true;
  }
}
