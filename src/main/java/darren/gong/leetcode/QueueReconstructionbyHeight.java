package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 0 || people[0].length <= 0) {
            return new int[0][0];
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a1, a2) -> (a1[0]==a2[0] ? a1[1]-a2[1] : a2[0]-a1[0]));
        for (int[] temp : people) {
            result.add(temp[1], temp);
        }
        return result.toArray(new int[result.size()][]);
    }

}
