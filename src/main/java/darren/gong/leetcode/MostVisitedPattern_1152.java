package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MostVisitedPattern_1152 {
  private Set<String> currentDfs;
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    int length = username.length;
    for (int i = 0; i < length; i++) {
      TreeMap<Integer, String> timeToWeb = map.computeIfAbsent(username[i], k->new TreeMap<>());
      timeToWeb.put(timestamp[i], website[i]);
    }
    Map<String, Integer> resultToTimes = new HashMap<>();
    for (Map.Entry<String, TreeMap<Integer, String>> entry : map.entrySet()) {
      currentDfs = new HashSet<>();
      dfs(entry.getValue(), 0, 3, new String[3], 0);

      for (String oneResult : currentDfs) {
        resultToTimes.put(oneResult, resultToTimes.getOrDefault(oneResult, 0)+1);
      }
      currentDfs = null;
    }
    int max = Integer.MIN_VALUE;
    for (int times : resultToTimes.values()) {
      max = Math.max(max, times);
    }
    TreeSet<String> resultTree = new TreeSet<>();
    for (Map.Entry<String, Integer> entry : resultToTimes.entrySet()) {
      if (entry.getValue() == max) {
        resultTree.add(entry.getKey());
      }
    }
    return Arrays.asList(resultTree.first().split("@"));
  }

  private void dfs(TreeMap<Integer, String> timeToWeb, int startTime, int need, String[] oneResult, int currentIndex) {
    if (currentIndex == 3) {
      currentDfs.add(oneResult[0]+"@"+oneResult[1]+"@"+oneResult[2]);
      return;
    }
    for (Map.Entry<Integer, String> entry : timeToWeb.tailMap(startTime).entrySet()) {
      oneResult[currentIndex] = entry.getValue();
      dfs(timeToWeb, entry.getKey()+1, need-1, oneResult, currentIndex+1);
      oneResult[currentIndex] = null;
    }
  }
}
