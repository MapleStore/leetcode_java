package darren.gong.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetRow119 {
    public List<Integer> getRow(int rowIndex) {
        int[] result = new int[rowIndex+1];
        int[] change = new int[rowIndex+1];
        result[0] = 1;
        if (rowIndex == 0) {
            return Arrays.stream(result).boxed().collect(Collectors.toList());
        }
        for (int i = 1; i <= rowIndex; i++) {
            int[] temp = change;
            change = result;
            result = temp;
            for (int j = 0; j <= i; j++) {
                int left = j-1 == -1 ? 0 : change[j-1];
                int right = change[j];
                result[j] = left+right;
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
