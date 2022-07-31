package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUnique1429 {
  private Set<Integer> removed = new HashSet<>();
  private LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
  public FirstUnique1429(int[] nums) {
    for (int num : nums) {
      if (removed.contains(num)) {
        continue;
      }
      if (linkedHashSet.contains(num)) {
        linkedHashSet.remove(num);
        removed.add(num);
      } else {
        linkedHashSet.add(num);
      }
    }
  }

  public int showFirstUnique() {
    if (linkedHashSet.isEmpty()) {
      return -1;
    }
    return linkedHashSet.iterator().next();
  }

  public void add(int value) {
    if (removed.contains(value)) {
      return;
    }
    if (linkedHashSet.contains(value)) {
      linkedHashSet.remove(value);
      removed.add(value);
    } else {
      linkedHashSet.add(value);
    }
  }
}
