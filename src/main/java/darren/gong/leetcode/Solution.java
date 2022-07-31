package darren.gong.leetcode;

import java.util.Random;

public class Solution {
    private int[] origin;
    private int[] array;
    Random random = new Random(17);
    public Solution(int[] nums) {
        origin = nums.clone();
        array = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = origin.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length-1; i++) {
            int index = random.nextInt(array.length-i)+i;
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }

}
