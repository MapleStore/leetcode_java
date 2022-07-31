package darren.gong.leetcode;

public class SortColors {
    public static void main (String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length-1;
        for (int i = 0; i < nums.length;) {
            if (i > two) {
                break;
            }
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            } else {
                i++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
