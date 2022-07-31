package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>(candidates.length);
        Arrays.sort(candidates);
        backTracking(result, new ArrayList<>(candidates.length), target, candidates, new boolean[candidates.length], 0);
        return result;
    }
    public void backTracking(List<List<Integer>> result, List<Integer> oneResult, int target, int[] candidates, boolean[] visited, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(oneResult));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (visited[i] || (i != 0 && candidates[i] == candidates[i-1] && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            oneResult.add(candidates[i]);
            backTracking(result, oneResult, target-candidates[i], candidates, visited, i+1);
            oneResult.remove(oneResult.size()-1);
            visited[i] = false;
        }
        return;
    }
}
