package darren.gong.leetcode;

public class KthElement {
    public static void main(String[] args) {
        /*TestService service = new TestServiceImpl();*/
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
    public static int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int index = partition(nums, start, end);
            if (k == nums.length - index) {
                return nums[index];
            } else if (k > nums.length - index) {
                end = index-1;
            } else {
                start = index+1;
            }
        }
        return end;
    }
    public static int partition(int[] arr, int start, int end) {
        if (end <= start) {
            return end;
        }
        int smallIndex = start;
        int index = start;
        for (; index < end; index++) {
            if (arr[index] < arr[end]) {
                int temp = arr[smallIndex];
                arr[smallIndex] = arr[index];
                arr[index] = temp;
                smallIndex++;
            }
        }
        int temp = arr[smallIndex];
        arr[smallIndex] = arr[end];
        arr[end] = temp;
        return smallIndex;
    }
}
