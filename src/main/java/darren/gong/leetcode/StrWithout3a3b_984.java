package darren.gong.leetcode;

public class StrWithout3a3b_984 {
  public String strWithout3a3b(int a, int b) {
    int count = 0;
    char currentChar = ' ';
    StringBuilder sb = new StringBuilder();
    while (a > 0 || b > 0) {
      if (count >= 2) {
        if (currentChar == 'a') {
          sb.append('b');
          currentChar = 'b';
          b--;
        } else {
          sb.append('a');
          currentChar = 'a';
          a--;
        }
        count = 1;
        continue;
      }
      if (a > b) {
        sb.append('a');
        if (currentChar == 'a') {
          count++;
        } else {
          count = 1;
        }
        currentChar = 'a';
        a--;
      } else {
        sb.append('b');
        if (currentChar == 'b') {
          count++;
        } else {
          count = 1;
        }
        currentChar = 'b';
        b--;
      }
    }
    return sb.toString();
  }
}
