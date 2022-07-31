package darren.gong.leetcode;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        wiggleSort(new int[]{4,5,5,6});
    }
    public static void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int minLength = (nums.length % 2 == 0) ? (nums.length / 2 - 1) : (nums.length / 2);//包括的话 此下标为正中间
        int[] result = new int[nums.length];
        int index1 = 0;
        int index2 = minLength+1;
        rever(nums, 0, minLength);
        rever(nums, minLength+1, nums.length-1);
        int resultIndex = 0;
        while (resultIndex < nums.length) {
            if (index1 <= minLength) {
                result[resultIndex++] = nums[index1++];
            }

            if (index2 < nums.length) {
                result[resultIndex++] = nums[index2++];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
        return;
    }
    public static void rever(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
