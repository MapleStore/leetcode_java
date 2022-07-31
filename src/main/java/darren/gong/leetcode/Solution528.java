package darren.gong.leetcode;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Solution528 {
    public static void main(String[] args) {
        Solution528 solution528 = new Solution528(new int[]{1,1});
        System.out.println(solution528.pickIndex());
        System.out.println(solution528.pickIndex());
        System.out.println(solution528.pickIndex());
        System.out.println(solution528.pickIndex());
        System.out.println(solution528.pickIndex());
        System.out.println(solution528.pickIndex());
        System.out.println(solution528.pickIndex());
    }

    private int[] weight;
    private TreeMap<Integer, Integer> map;
    private Random random = new Random();
    private int size;
    public Solution528(int[] w) {
        map = new TreeMap<>();
        map.put(w[0], 0);
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i-1];
            map.put(w[i], i);
        }
        weight = w;
        this.size = weight[weight.length-1];
    }

    public int pickIndex() {
        int index = random.nextInt(size);
        System.out.println(index);
        return map.higherEntry(index).getValue();
    }
}
