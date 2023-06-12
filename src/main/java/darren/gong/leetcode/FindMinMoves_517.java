package darren.gong.leetcode;

public class FindMinMoves_517 {
  public int findMinMoves(int[] machines) {
    long sum = 0;
    for (int machine : machines) sum += machine;

    int length = machines.length;
    if (sum%length != 0) return -1;

    int each = (int) (sum/length);
    int result = 0;
    int prefix = 0;
    for (int machine : machines) {
      int num = machine-each;
      prefix += num;
      result = Math.max(result, Math.max(num, Math.abs(prefix)));
    }
    return result;
  }
}
