package darren.gong.leetcode;

public class PeakIndexInMountainArray852 {
    public static void main(String[] args) {
        PeakIndexInMountainArray852 peakIndexInMountainArray852 = new PeakIndexInMountainArray852();
        peakIndexInMountainArray852.peakIndexInMountainArray(new int[]{3,5,3,2,0});
    }
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            int leftValue = mid-1 < 0 ? Integer.MIN_VALUE : arr[mid-1];
            int rightValue = mid+1 >= arr.length ? Integer.MIN_VALUE : arr[mid+1];
            if (arr[mid] > leftValue && arr[mid] > rightValue) {
                return mid;
            } else if (arr[mid] > leftValue) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
