package darren.gong.leetcode;

public class Solution157 {
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  public int read(char[] buf, int n) {
    char[] temp = new char[4];
    int index = 0;
    int num = 0;
    do {
      num = read4(temp);
      for (int i = 0; i < num && index < n; i++) {
        buf[index++] = temp[i];
      }
    } while (index < n && num == 4);
    return index;
  }
  private int read4(char[] buf4) {
    return 0;
  }
}
