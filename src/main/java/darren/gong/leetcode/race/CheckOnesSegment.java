package darren.gong.leetcode.race;

public class CheckOnesSegment {
  public boolean checkOnesSegment(String s) {
    int times = 0;
    int appear = 0;
    for (char oneChar : s.toCharArray()) {
      if (oneChar == '1') {
        appear++;
      } else {
        if (appear >= 1) {
          times++;
        }
        appear = 0;
      }
      if (times >= 2) {
        return false;
      }
    }
    if (appear >= 1) {
      times++;
    }
    if (times != 1) {
      return false;
    }
    return true;
  }
}
