package darren.gong.leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = height.length-1;
        while (right > left) {
            if (height[right] < height[left]) {
                result = Math.max(height[right]*(right-left), result);
                right--;
            } else {
                result = Math.max(height[left]*(right-left), result);
                left++;
            }
        }
        return result;
    }
}
