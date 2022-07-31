package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindSubsequences_491 {
  public static void main(String[] args) {
    FindSubsequences_491 findSubsequences_491 = new FindSubsequences_491();
    findSubsequences_491.findSubsequences(new int[]{1,1,1});
  }
  public List<List<Integer>> findSubsequences(int[] nums) {
    int length = nums.length;
    List<List<Integer>>[] subsequences = new List[length];
    boolean[] visited = new boolean[201];
    for (int i = 0; i < length; i++) {
      subsequences[i] = new ArrayList<>();
      if (!visited[nums[i]+100]) {
        visited[nums[i]+100] = true;
        subsequences[i].add(Collections.singletonList(nums[i]));
      }
      for (int j = i-1; j >= 0; j--) {
        if (nums[i] >= nums[j]) {
          for (List<Integer> list : subsequences[j]) {
            List<Integer> oneResult = new ArrayList<>(list);
            oneResult.add(nums[i]);
            subsequences[i].add(oneResult);
          }
          if (nums[i] == nums[j]) {
            break;
          }
        }
      }
    }
    List<List<Integer>> result = new LinkedList<>();
    for (List<List<Integer>> temp : subsequences) {
      for (List<Integer> oneResult : temp) {
        if (oneResult.size() > 1) {
          result.add(oneResult);
        }
      }
    }
    return result;
  }
}
