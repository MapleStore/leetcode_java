package darren.gong.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray1146 {
  private TreeMap<Integer, Integer>[] cache;
  private int snap = 0;
  public SnapshotArray1146(int length) {
    cache = new TreeMap[length];
    for (int i = 0; i < length; i++) {
      cache[i] = new TreeMap<>();
    }
  }

  public void set(int index, int val) {
    cache[index].put(snap, val);
  }

  public int snap() {
    return snap++;
  }

  public int get(int index, int snap_id) {
    Map.Entry<Integer, Integer> entry = cache[index].floorEntry(snap_id);
    return entry == null ? 0 : entry.getValue();
  }
}
