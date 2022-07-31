package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeBarcodes1054 {
  public int[] rearrangeBarcodes(int[] barcodes) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->b[1]-a[1]);
    Map<Integer, Integer> map = new HashMap<>();
    for (int barcode : barcodes) {
      map.put(barcode, map.getOrDefault(barcode, 0)+1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
    }
    int length = barcodes.length;
    for (int i = 0; i < length; i++) {
      int[] current = priorityQueue.poll();
      if (i == 0 || current[0] != barcodes[i-1]) {
        barcodes[i] = current[0];
        current[1]--;
      } else {
        int[] pre = priorityQueue.poll();
        barcodes[i] = pre[0];
        pre[1]--;
        priorityQueue.add(pre);
      }
      priorityQueue.add(current);
    }
    return barcodes;
  }
}
