package darren.gong.leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1});
    }
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int pre = nums[i]-1;
            while (pre >= 0 && pre < nums.length) {
                int index = pre;
                pre = nums[pre]-1;
                nums[index] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
