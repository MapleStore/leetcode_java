package darren.gong.leetcode;

import java.util.TreeMap;

public class CarFleet_853 {
    public static void main(String[] args) {
        CarFleet_853 carFleet_853 = new CarFleet_853();
        carFleet_853.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
    }
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int length = position.length;
        for (int i = 0; i < length; i++) {
            treeMap.put(position[i], speed[i]);
        }

        int result = 0;
        double speedTime = Double.MIN_VALUE;
        for (Integer key : treeMap.descendingKeySet()) {
            double tempSpendTime = (double)(target-key)/(double)treeMap.get(key);
            if (tempSpendTime > speedTime) {
                result++;
                speedTime = tempSpendTime;
            }
        }
        return result;
    }
}
