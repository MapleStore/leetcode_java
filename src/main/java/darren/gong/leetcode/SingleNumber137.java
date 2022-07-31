package darren.gong.leetcode;

public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        int x = 0;
        int y = 0;
        for (int num : nums) {
            int preX = x;
            int preY = y;
            x = ((~preX)&(~preY)&num)|((preX)&(~preY)&(~num));
            y = (preX&(~preY)&num) | ((~preX)&preY&(~num));
        }
        return x;
    }
}
