package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumBusesToDestination_815 {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    Map<Integer, Set<Integer>> station2Lines = new HashMap<>();
    int length = routes.length;
    for (int line = 0; line < length; line++) {
      for (int station : routes[line]) {
        Set<Integer> lines = station2Lines.computeIfAbsent(station, k->new HashSet<>());
        lines.add(line);
      }
    }
    Set<Integer>[] line2Lines = new Set[length];
    for (int line = 0; line < length; line++) {
      line2Lines[line] = new HashSet<>();
      for (int station : routes[line]) {
        line2Lines[line].addAll(station2Lines.computeIfAbsent(station, k->new HashSet<>()));
      }
    }
    Set<Integer> targetLines = station2Lines.get(target);
    if (targetLines == null) {
      return -1;
    }
    boolean[] visited = new boolean[length];
    Queue<Integer> queue = new LinkedList<>(station2Lines.get(source));
    for (int line : station2Lines.get(source)) {
      visited[line] = true;
    }
    int distance = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int currentLine = queue.poll();
        if (targetLines.contains(currentLine)) {
          return distance;
        }
        for (int nextLine : line2Lines[currentLine]) {
          if (visited[nextLine]) {
            continue;
          }
          visited[nextLine] = true;
          queue.add(nextLine);
        }
      }
      distance++;
    }
    return -1;
  }
}
