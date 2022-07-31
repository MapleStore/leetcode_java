package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSmallestRegion_1257 {
  // 1257. 最小公共区域
  private Map<String, String> map = new HashMap<>();
  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    for (List<String> region : regions) {
      String head = null;
      for (String oneRegion : region) {
        if (head == null) {
          head = oneRegion;
        } else {
          map.put(oneRegion, head);
        }
      }
    }
    List<String> region1Parents = findParents(region1);
    List<String> region2Parents = findParents(region2);
    int parent1Index = region1Parents.size()-1;
    int parent2Index = region2Parents.size()-1;
    String result = "";
    while (parent1Index >= 0 && parent2Index >= 0 && region1Parents.get(parent1Index).equals(region2Parents.get(parent2Index))) {
      result = region1Parents.get(parent1Index);
      parent1Index--;
      parent2Index--;
    }
    return result;
  }
  private List<String> findParents(String region) {
    List<String> result = new ArrayList<>();
    result.add(region);
    while ((region = map.get(region)) != null) {
      result.add(region);
    }
    return result;
  }
}
