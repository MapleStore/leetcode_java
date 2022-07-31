package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSwap_670 {
  // 670. 最大交换
  public int maximumSwap(int num) {
    char[] arr = String.valueOf(num).toCharArray();
    int length = arr.length;
    // [0]:被交换的数下标 [1]:交换[0]的数下标
    Deque<int[]> deque = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      int[] current = new int[]{i, i};
      while (!deque.isEmpty() && (arr[deque.peekLast()[1]] < arr[current[1]] || (arr[deque.peekLast()[1]] == arr[current[1]] && deque.peekLast()[1] != deque.peekLast()[0]))) {
        current[0] = deque.pollLast()[0];
      }
      deque.addLast(current);
    }
    while (!deque.isEmpty()) {
      int[] current = deque.pollFirst();
      if (current[0] != current[1]) {
        char temp = arr[current[0]];
        arr[current[0]] = arr[current[1]];
        arr[current[1]] = temp;
        break;
      }
    }
    return Integer.parseInt(new String(arr));
  }
}
