package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode89 {
    public static void main(String[] args) {
        GrayCode89 grayCode89 = new GrayCode89();
        grayCode89.grayCode(2);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = list.size()-1; j >= 0; j--) {
                list.add(list.get(j) | add);
            }
        }
        return list;

    }
}
