package darren.gong.leetcode;
 class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
 }

public class LinkedListCycle1 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (one != null && two != null && two.next != null) {
            if (one == two) {
                return true;
            }
            one = one.next;
            two = two.next.next;
        }
        return false;
    }

}
