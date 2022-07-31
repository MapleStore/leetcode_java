package darren.gong.leetcode;

public class MergeSortedArray1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexNum1 = m-1;
        int indexNum2 = n-1;
        for (int i = m+n-1; i >= 0; i--) {
            if (indexNum1 < 0) {
                nums1[i] = nums2[indexNum2--];
            } else if (indexNum2 < 0) {
                nums1[i] = nums1[indexNum1--];
            } else if (nums1[indexNum1] >= nums2[indexNum2]) {
                nums1[i] = nums1[indexNum1--];
            } else {
                nums1[i] = nums2[indexNum2--];
            }
        }
    }
}
