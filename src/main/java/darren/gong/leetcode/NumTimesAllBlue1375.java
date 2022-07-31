package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumTimesAllBlue1375 {
    public static void main(String[] args) {
        NumTimesAllBlue1375 numTimesAllBlue1375 = new NumTimesAllBlue1375();
        numTimesAllBlue1375.numTimesAllBlue(new int[]{4,1,2,3});
    }
    public int numTimesAllBlue(int[] light) {
        int max = 0;
        int result = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (i == max-1) {
                result++;
            }
        }
        return result;
    }
}
