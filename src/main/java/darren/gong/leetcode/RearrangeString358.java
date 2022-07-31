package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeString358 {
  public static void main(String[] args) {
    RearrangeString358 rearrangeString358 = new RearrangeString358();
    rearrangeString358.rearrangeString("aaabc", 2);
  }
  public String rearrangeString(String s, int k) {
    Queue<int[]> queue = new LinkedList<>();
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{
      return b[0]-a[0];
    });
    // 26个字母, 对应 出现次数 字母对应num
    int[][] map = new int[26][2];
    char[] charArr = s.toCharArray();
    int length = charArr.length;
    for (int i = 0; i < length; i++) {
      map[charArr[i]-'a'][0]++;
    }
    for (int i = 0; i < 26; i++) {
      map[i][1] = 'a'+i;
      if (map[i][0] != 0) {
        priorityQueue.add(map[i]);
      }
    }
    StringBuilder result = new StringBuilder();
    while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] != 0) {
      int[] current = priorityQueue.poll();
      result.append((char)current[1]);
      current[0]--;
      queue.add(current);
      if (queue.size() >= k) {
        priorityQueue.add(queue.poll());
      }
    }
    if (result.length() != s.length()) {
      return "";
    }
    return result.toString();
  }
}
