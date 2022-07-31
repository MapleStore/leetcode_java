package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KillProcess582 {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    for (int i = 0; i < pid.size(); i++) {
      int child = pid.get(i);
      int parent = ppid.get(i);
      Set<Integer> children = parentToChildren.get(parent);
      if (children == null) {
        children = new HashSet<>();
        parentToChildren.put(parent, children);
      }
      children.add(child);
    }
    Set<Integer> result = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(kill);
    result.add(kill);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int parent = queue.poll();
        Set<Integer> children = parentToChildren.get(parent);
        if (children == null) {
          continue;
        }
        for (Integer child : children) {
          if (result.contains(child)) {
            continue;
          }
          result.add(child);
          queue.add(child);
        }
      }
    }
    return new ArrayList<>(result);
  }
}
