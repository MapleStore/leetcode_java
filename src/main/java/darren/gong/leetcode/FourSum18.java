package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, target, 0, 4, visited, new ArrayList<>(), result);
        return result;
    }
    private void dfs(int[] nums, int target, int start, int need, boolean[] visited, List<Integer> oneResult, List<List<Integer>> result) {
        if (need == 0) {
            if (target == 0) {
                result.add(new LinkedList<>(oneResult));
            }
            return;
        }
        for (int i = start; i <= nums.length-need; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i-1 >= 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            oneResult.add(nums[i]);
            visited[i] = true;
            dfs(nums, target-nums[i], i+1, need-1, visited, oneResult, result);
            visited[i] = false;
            oneResult.remove(oneResult.size()-1);
        }
        return;
    }
}
