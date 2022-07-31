package darren.gong.leetcode;

import java.util.Random;

public class Solution382 {
  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  private Random random = new Random();
  ListNode head;
  public Solution382(ListNode head) {
    this.head = head;
  }

  /** Returns a random node's value. */
  public int getRandom() {
    int index = 1;
    ListNode current = head;
    int result = 0;
    while (current != null) {
      random.nextInt(index);
      int randomNum = random.nextInt(index);
      if (randomNum == 0) {
        result = current.val;
      }
      index++;
      current = current.next;
    }
    return result;
  }
}
