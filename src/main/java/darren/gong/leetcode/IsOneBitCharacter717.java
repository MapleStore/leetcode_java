package darren.gong.leetcode;

public class IsOneBitCharacter717 {
  public boolean isOneBitCharacter(int[] bits) {
    if (bits == null || bits.length == 0) {
      return false;
    }
    if (bits.length == 1) {
      return true;
    }
    int index  = 0;
    while (index < bits.length) {
      if (index == bits.length-1) {
        return true;
      }
      if (bits[index] == 1) {
        index += 2;
      } else {
        index += 1;
      }
    }
    return false;
  }
}
