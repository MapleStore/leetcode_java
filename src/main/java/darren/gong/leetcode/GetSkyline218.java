package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetSkyline218 {
    public static void main (String[] args) {
        getSkyline(new int[][]{{0,2,3},{2,5,3}});
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> allLines = new ArrayList<>();
        for (int[] oneBuilding : buildings) {
            allLines.add(new int[]{oneBuilding[0], oneBuilding[2]});
            allLines.add(new int[]{oneBuilding[1], -oneBuilding[2]});
        }
        allLines.sort((entry1, entry2)->{
            if (entry1[0] != entry2[0]) {
                return entry1[0] - entry2[0];
            } else {
                return entry2[1] - entry1[1];
            }
        });
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        int preHigh = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int[] line : allLines) {
            if (line[1] < 0) {
                if (treeMap.getOrDefault(-line[1], 0) <= 1) {
                    treeMap.remove(-line[1]);
                } else {
                    treeMap.put(-line[1], treeMap.getOrDefault(-line[1], 0) - 1);
                }
            } else {
                treeMap.put(line[1], treeMap.getOrDefault(line[1], 0) + 1);
            }
            int maxHigh;
            if (treeMap.size() == 0) {
                maxHigh = 0;
            } else {
                maxHigh = treeMap.lastKey();
            }
            if (maxHigh != preHigh) {
                preHigh = maxHigh;
                List oneResult = new ArrayList();
                oneResult.add(line[0]);
                oneResult.add(maxHigh);
                result.add(oneResult);
            }
        }
        return result;
    }
}
