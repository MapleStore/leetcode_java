package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(nums.length);
        backTracking(result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }
    public void backTracking(List<List<Integer>> result, List<Integer> oneResult, boolean[] visited, int[] nums) {
        if (oneResult.size() == nums.length) {
            result.add(new ArrayList<>(oneResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i-1 >= 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            visited[i] = true;
            oneResult.add(nums[i]);
            backTracking(result, oneResult, visited, nums);
            visited[i] = false;
            oneResult.remove(oneResult.size()-1);

        }
        return;
    }
}
