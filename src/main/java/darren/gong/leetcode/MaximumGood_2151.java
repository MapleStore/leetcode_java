package darren.gong.leetcode;

public class MaximumGood_2151 {
  public int maximumGood(int[][] statements) {
    int length = statements.length;
    int result = 0;
    for (int mask = 1; mask < (1<<length); mask++) {
      if (valid(statements, mask)) {
        result = Math.max(result, countGoodPeople(mask));
      }
    }
    return result;
  }
  private boolean valid(int[][] statement, int mask) {
    int length = statement.length;
    for (int i = 0; i < length; i++) {
      int currentPeople = (1<<i);
      if ((mask & currentPeople) == 0) {
        // current people bad
        for (int people = 0; people < length; people++) {
          if (statement[people][i] == 1 && ((1<<people)&mask) != 0) {
            return false;
          }
        }
      } else {
        // current people good
        for (int people = 0; people < length; people++) {
          if (statement[people][i] == 0 && ((1<<people)&mask) != 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
  private int countGoodPeople(int mask) {
    return Integer.bitCount(mask);
  }
}
