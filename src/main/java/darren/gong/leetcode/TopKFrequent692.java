package darren.gong.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>((a, b)->{
            int countA = count.get(a);
            int countB = count.get(b);
            if (countA == countB) {
                return b.compareTo(a);
            } else {
                return countA - countB;
            }
        });
        for (String word : count.keySet()) {
            priorityQueue.add(word);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<String> result = new LinkedList<>();
        result.addAll(priorityQueue);
        Collections.reverse(result);
        return result;
    }
}
