package darren.gong.leetcode;

import java.util.PriorityQueue;

public class KthLargest703 {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private int k;
    public KthLargest703(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
