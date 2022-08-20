package darren.gong.leetcode;

public class PrisonAfterNDays_957 {
  public static void main(String[] args) {
    PrisonAfterNDays_957 prisonAfterNDays_957 = new PrisonAfterNDays_957();
    prisonAfterNDays_957.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 1);
  }
  public int[] prisonAfterNDays(int[] cells, int n) {
    int[] nextPrison = new int[256];
    int[] statusPos = new int[256];
    int count = 1;
    int startLoopStatus = -1;
    int loopNum = 0;
    int temp = n;
    while (temp-- >= 0) {
      int value = getStatus(cells);
      if (statusPos[value] != 0) {
        startLoopStatus = value;
        loopNum = count-statusPos[value];
        break;
      }
      if (temp < 0) {
        return cells;
      }
      statusPos[value] = count;
      count++;

      int[] nextPrisonStatus = nextPrison(cells);
      cells = nextPrisonStatus;
      int nextValue = getStatus(nextPrisonStatus);
      nextPrison[value] = nextValue;
    }
    n -= count;
    n = n%loopNum;
    int result = startLoopStatus;
    while (n-- >= 0) {
      result = nextPrison[result];
    }
    return getPrison(result);
  }
  private int[] nextPrison(int[] current) {
    int[] next = new int[8];
    for (int i = 1; i < 7; i++) {
      if (current[i-1] == current[i+1]) {
        next[i] = 1;
      }
    }
    return next;
  }
  private int getStatus(int[] cells) {
    int result = 0;
    for (int cell : cells) {
      result = (result<<1)|cell;
    }
    return result;
  }
  private int[] getPrison(int status) {
    int[] result = new int[8];
    for (int i = 7; i >= 0; i--) {
      result[i] = status%2;
      status = (status>>>1);
    }
    return result;
  }
}
