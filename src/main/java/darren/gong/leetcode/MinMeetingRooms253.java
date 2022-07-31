package darren.gong.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms253 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0) return 0;
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int result = 0;
        for (int[] interval : intervals) {
            while (!priorityQueue.isEmpty()) {
                int[] removeRoom = priorityQueue.peek();
                if (removeRoom[1] <= interval[0]) {
                    priorityQueue.poll();
                } else {
                    break;
                }
            }
            priorityQueue.add(interval);
            result = Math.max(result, priorityQueue.size());
        }
        return result;
    }
}
