package darren.gong.leetcode.interview;

public class PrintBin_0502 {
  public String printBin(double num) {
    StringBuilder sb = new StringBuilder("0.");
    double current = 0.5;
    for (int i = 0; i < 30; i++) {
      if (current == num) {
        sb.append(1);
        return sb.toString();
      } else if (current < num) {
        sb.append(1);
        num -= current;
      } else {
        sb.append(0);
      }
      current /= 2;
    }
    return "ERROR";
  }
}
