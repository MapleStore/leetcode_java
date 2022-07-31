package darren.gong.leetcode;

public class ThirdMax414 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        long one = Long.MIN_VALUE;
        long two = Long.MIN_VALUE;
        long three = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == one || num == two || num == three) {
                continue;
            }
            if (num > one) {
                three = two;
                two = one;
                one = num;
            } else if (num > two) {
                three = two;
                two = num;
            } else if (num > three) {
                three = num;
            }
        }
        return (int)(three == Long.MIN_VALUE ? one : three);
    }
}
