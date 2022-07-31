package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap981 {
  private Map<String, TreeMap<Integer, String>> map = new HashMap<>();
  /** Initialize your data structure here. */
  public TimeMap981() {

  }

  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> treeMap = map.get(key);
    if (treeMap == null) {
      treeMap = new TreeMap<>();
      map.put(key, treeMap);
    }
    treeMap.put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> treeMap = map.get(key);
    if (treeMap == null) {
      return "";
    }
    Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
    return entry == null ? "" : entry.getValue();
  }
}
