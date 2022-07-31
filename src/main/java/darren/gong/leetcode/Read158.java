package darren.gong.leetcode;

public class Read158 {
  private char[] buff = new char[4];
  private int currentIndex = 0;
  private int end = 0;
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  public int read(char[] buf, int n) {
    int fillIndex = 0;
    while (currentIndex < end && n > 0) {
      buf[fillIndex++] = buff[currentIndex++];
      n--;
    }
    if (n <= 0) {
      return fillIndex;
    }

    while (n > 0) {
      end = read4(buff);
      currentIndex = 0;
      if (currentIndex >= end) {
        break;
      }
      while (currentIndex < end && n > 0) {
        buf[fillIndex++] = buff[currentIndex++];
        n--;
      }
    }
    return fillIndex;
  }
  private int read4(char[] buf4) {
    return 0;
  }
}
