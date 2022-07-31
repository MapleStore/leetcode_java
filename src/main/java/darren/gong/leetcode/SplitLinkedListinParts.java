package darren.gong.leetcode;

public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        ListNode now = root;
        while (now != null) {
            length++;
            now = now.next;
        }
        int nodeArraySize = length/k;
        int mod = length%k;
        now = root;
        for (int i = 0; now != null && i < k; i++) {
            result[i] = now;
            int size = nodeArraySize + (mod-- > 0 ? 1 : 0);
            while (--size > 0) {
                now = now.next;
            }
            ListNode temp = now;
            now = now.next;
            temp.next = null;
        }
        return result;
    }
}
