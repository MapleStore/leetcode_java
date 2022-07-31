package darren.gong.leetcode;

public class NumComponents_817 {
  // 837. 新21点
  public int numComponents(ListNode head, int[] G) {
    boolean[] contains = new boolean[10000];
    for (int g : G) {
      contains[g] = true;
    }
    boolean is = false;
    int result = 0;
    while (head != null) {
      if (contains[head.val]) {
        is = true;
      } else {
        if (is) {
          result++;
          is = false;
        }
      }
      head = head.next;
    }
    return is ? result+1 : result;
  }
}
