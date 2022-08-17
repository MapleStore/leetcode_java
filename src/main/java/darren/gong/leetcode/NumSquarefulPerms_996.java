package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquarefulPerms_996 {
  public static void main(String[] args) {
    NumSquarefulPerms_996 numSquarefulPerms_996 = new NumSquarefulPerms_996();
    numSquarefulPerms_996.numSquarefulPerms(new int[]{2,2,2});
  }
  private int result = 0;
  public int numSquarefulPerms(int[] nums) {
    int length = nums.length;
    Arrays.sort(nums);
    List<Integer>[] lists = new List[length];
    for (int i = 0; i < length; i++) {
      lists[i] = new ArrayList();
    }
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        if (i == j) {
          continue;
        }
        long sum = (long)nums[i]+(long)nums[j];
        long sqrt = (long) Math.sqrt((long)nums[i]+(long)nums[j]);
        if (sqrt*sqrt == sum) {
          lists[i].add(j);
          lists[j].add(i);
        }
      }
    }
    for (int i = 0; i < length; i++) {
      List<Integer> oneResult = new ArrayList<>();
      oneResult.add(i);
      boolean[] visited = new boolean[length];
      visited[i] = true;
      if (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
        continue;
      }
      dfs(oneResult, lists, i, nums, visited);
    }
    return result;
  }
  private void dfs(List<Integer> oneResult, List<Integer>[] lists, int currentIndex, int[] nums, boolean[] visited) {
    if (oneResult.size() == visited.length) {
      result++;
      return;
    }
    for (int nextIndex : lists[currentIndex]) {
      if (visited[nextIndex]) {
        continue;
      }
      if (nextIndex > 0 && nums[nextIndex-1] == nums[nextIndex] && !visited[nextIndex-1]) {
        continue;
      }
      oneResult.add(nextIndex);
      visited[nextIndex] = true;
      dfs(oneResult, lists, nextIndex, nums, visited);
      oneResult.remove(oneResult.size()-1);
      visited[nextIndex] = false;
    }
  }
}
