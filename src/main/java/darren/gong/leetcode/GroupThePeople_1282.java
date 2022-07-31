package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GroupThePeople_1282 {
  // 1282. 用户分组
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<Integer>[] groups = new List[501];
    List<List<Integer>> result = new LinkedList<>();
    int length = groupSizes.length;
    for (int i = 0; i < length; i++) {
      int groupSize = groupSizes[i];
      List<Integer> group = groups[groupSize];
      if (group == null) {
        group = new LinkedList<>();
        groups[groupSize] = group;
      }
      group.add(i);
      if (group.size() == groupSize) {
        result.add(group);
        groups[groupSize] = null;
      }
    }
    return result;
  }
}
