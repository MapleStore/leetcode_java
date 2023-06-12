package darren.gong.leetcode;

public class CaptureForts_2511 {
  public int captureForts(int[] forts) {
    int result = 0;
    int flag = 0, count = 0;
    for (int fort : forts) {
      if (fort == -1) {
        result = Math.max(result, count);
        flag = -1;
        count = 0;
      } else if (fort == 0) {
        if (flag == 1) {
          count++;
        }
      } else {
        flag = 1;
        count = 0;
      }
    }
    flag = 0;
    count = 0;
    for (int i = forts.length-1; i >= 0; i--) {
      int fort = forts[i];
      if (fort == -1) {
        result = Math.max(result, count);
        flag = -1;
        count = 0;
      } else if (fort == 0) {
        if (flag == 1) {
          count++;
        }
      } else {
        flag = 1;
        count = 0;
      }
    }
    return result;
  }
}
