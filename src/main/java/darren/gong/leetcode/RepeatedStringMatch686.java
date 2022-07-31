package darren.gong.leetcode;

public class RepeatedStringMatch686 {
  public int repeatedStringMatch(String a, String b) {
    StringBuilder bigger = new StringBuilder();
    int num = 0;
    while (bigger.length() < b.length()) {
      bigger.append(a);
      num++;
    }
    if (bigger.indexOf(b) != -1) {
      return num;
    }
    if (bigger.append(a).indexOf(b) != -1) {
      return num+1;
    }
    return -1;
  }
}
