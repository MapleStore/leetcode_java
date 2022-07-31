package darren.gong.leetcode;

import java.util.Arrays;

public class SuperPow372 {
  public int superPow(int a, int[] b) {
    int length = b.length;
    a = a%1337;
    int[] mod = new int[length];
    Arrays.fill(mod, 1);
    mod[length-1] = a;
    for (int i = 2; i <= length; i++) {
      int currentIndex = length-i;
      int preMod = mod[currentIndex+1];
      for (int j = 0; j < 10; j++) {
        mod[currentIndex] = mod[currentIndex]*preMod%1337;
      }
    }

    int result = 1;
    for (int i = length-1; i >= 0; i--) {
      while (b[i]-- > 0) {
        result = result*mod[i]%1337;
      }
    }
    return result;
  }
}
