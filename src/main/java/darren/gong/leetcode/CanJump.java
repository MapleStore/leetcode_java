package darren.gong.leetcode;

public class CanJump {
    public boolean canJump(int[] nums) {
        int canReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (canReach >= nums.length-1) {
                return true;
            }
            if (i > canReach) {
                return false;
            }
            canReach = Math.max(canReach, i+nums[i]);
        }
        return true;
    }
}
