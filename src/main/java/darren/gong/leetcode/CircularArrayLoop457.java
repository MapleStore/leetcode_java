package darren.gong.leetcode;

public class CircularArrayLoop457 {
    public static void main(String[] args) {
        CircularArrayLoop457 circularArrayLoop457 = new CircularArrayLoop457();
        circularArrayLoop457.circularArrayLoop(new int[]{-2,1,-1,-2,-2});
    }
    public boolean circularArrayLoop(int[] nums) {
        int notLoop = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == notLoop) {
                continue;
            }
            int index = i;
            boolean forward = nums[index] > 0 ? true : false;
            while (true) {
                int nextIndex = (index+nums[index]+5000*nums.length)%nums.length;
                if (nums[nextIndex] > 1000 && nums[nextIndex] != notLoop) {
                    return true;
                }
                // visited
                nums[index] = nums[index]+5000*nums.length;
                // 判断自身循环
                if (nextIndex == index) {
                    nums[index] = notLoop;
                }
                // 判断方向
                if (nums[nextIndex] == notLoop || ((nums[nextIndex] > 0) ^ forward)) {
                    // 置为notloop
                    int setIndex = i;
                    while (setIndex != nextIndex) {
                        int nextSetIndex = (setIndex+nums[setIndex]+5000*nums.length)%nums.length;
                        nums[setIndex] = notLoop;
                        setIndex = nextSetIndex;
                    }
                    break;
                }
                index = nextIndex;
            }
        }
        return false;
    }
}
