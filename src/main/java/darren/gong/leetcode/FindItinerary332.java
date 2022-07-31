package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class FindItinerary332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(map, "JFK", result);
        Collections.reverse(result);
        return result;
    }
    private void dfs(Map<String, Queue<String>> map, String current, List<String> result) {
        while (map.containsKey(current) && map.get(current).size() != 0) {
            String next = map.get(current).poll();
            dfs(map, next, result);
        }
        result.add(current);
    }

}
