package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntervalIntersection986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new LinkedList<>();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < A.length && bIndex < B.length) {
            int[] currentA = A[aIndex];
            int[] currentB = B[bIndex];
            if (currentA[0] < currentB[0]) {
                if (currentB[0] <= currentA[1]) {
                    if (currentA[1] >= currentB[1]) {
                        result.add(new int[]{currentB[0], currentB[1]});
                        bIndex++;
                    } else {
                        result.add(new int[]{currentB[0], currentA[1]});
                        aIndex++;
                    }
                } else {
                    aIndex++;
                }
            } else {
                if (currentA[0] <= currentB[1]) {
                    if (currentA[1] <= currentB[1]) {
                        result.add(new int[]{currentA[0], currentA[1]});
                        aIndex++;
                    } else {
                        result.add(new int[]{currentA[0], currentB[1]});
                        bIndex++;
                    }
                } else {
                    bIndex++;
                }
            }
        }
        int[][] realResult = new int[result.size()][];
        int index = 0;
        for (int[] one : result) {
            realResult[index++] = one;
        }
        return realResult;
    }
}
