package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers_970 {
  public static void main(String[] args) {
    PowerfulIntegers_970 powerfulIntegers_970 = new PowerfulIntegers_970();
    powerfulIntegers_970.powerfulIntegers(2,3,10);
  }
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    Set<Integer> tempResult = new HashSet<>();
    for (int i = 0; (long)Math.pow(x, i) < bound; i++) {
      for (int j = 0;;j++) {
        long val = (long)Math.pow(x, i)+(long)Math.pow(y, j);
        if (val > bound) {
          break;
        }
        tempResult.add((int)val);
        if (y == 1) {
          break;
        }
      }
      if (x == 1) {
        break;
      }
    }
    return new LinkedList<>(tempResult);
  }
}
