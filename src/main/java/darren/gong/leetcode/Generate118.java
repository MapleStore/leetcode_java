package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(0, 1);
        result.add(0, firstRow);
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; i++) { // 行
            List<Integer> row = new ArrayList<Integer>(i+1);
            result.add(i, row);
            for (int j = 0; j <= i; j++) { // 列
                int pre = j-1;
                int next = j;
                pre = pre < 0 ? 0 : result.get(i-1).get(pre);
                next = next >= i ? 0 : result.get(i-1).get(next);
                row.add(j, pre + next);
            }
        }
        return result;
    }
}
