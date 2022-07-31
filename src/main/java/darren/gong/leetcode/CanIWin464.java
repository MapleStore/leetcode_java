package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanIWin464 {
  public static void main(String[] args) {
    CanIWin464 canIWin464 = new CanIWin464();
    canIWin464.canIWin(10, 40);
  }
  private Map<String, Boolean> remember = new HashMap<>();
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if(desiredTotal<=maxChoosableInteger) {
      return true;
    }
    if((1+maxChoosableInteger)*(maxChoosableInteger)/2<desiredTotal) {
      return false;
    }
    return canIWin(maxChoosableInteger, desiredTotal, 0);
  }
  private boolean canIWin(int maxChoosableInteger, int desiredTotal, long visited) {
    Boolean result = remember.get(desiredTotal+"@"+visited);
    if (result != null) {
      return result;
    }

    for (int i = 1; i <= maxChoosableInteger; i++) {
      if ((visited&(1<<i)) > 0) {
        continue;
      }
      if (i >= desiredTotal) {
        remember.put(desiredTotal+"@"+visited, true);
        return true;
      }
      if (!canIWin(maxChoosableInteger, desiredTotal-i, visited|(1<<i))) {
        remember.put(desiredTotal+"@"+visited, true);
        return true;
      }
    }
    remember.put(desiredTotal+"@"+visited, false);
    return false;
  }

}
