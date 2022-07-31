package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter362 {
    private class IntObject {
        int timeStamp;
        int val;
    }
    Deque<IntObject> queue;
    int count;
    /** Initialize your data structure here. */
    public HitCounter362() {
        queue = new ArrayDeque<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek().timeStamp >= 300) {
            IntObject intObject = queue.poll();
            count -= intObject.val;
        }
        if (queue.isEmpty() || queue.getLast().timeStamp != timestamp) {
            IntObject intObject = new IntObject();
            intObject.timeStamp = timestamp;
            intObject.val = 1;
            queue.add(intObject);
        } else {
            queue.getLast().val += 1;
        }
        count += 1;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek().timeStamp >= 300) {
            IntObject intObject = queue.poll();
            count -= intObject.val;
        }
        return count;
    }
}
