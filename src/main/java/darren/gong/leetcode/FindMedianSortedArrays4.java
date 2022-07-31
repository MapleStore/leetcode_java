package darren.gong.leetcode;

public class FindMedianSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0;
        }
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int mid1Index = -1;
        int mid2Index = -1;
        if ((num1Length+num2Length) % 2 == 0) {
            mid1Index = (num1Length+num2Length) / 2 - 1;
            mid2Index = mid1Index + 1;
        } else {
            mid1Index = (num1Length+num2Length) / 2;
            mid2Index = mid1Index;
        }
        int nums1Index = 0;
        int nums2Index = 0;
        int resultIndex = 0;
        double result = 0;
        while (true) {
            int curNum1 = nums1Index >= num1Length ? Integer.MAX_VALUE : nums1[nums1Index];
            int curNum2 = nums2Index >= num2Length ? Integer.MAX_VALUE : nums2[nums2Index];
            if (curNum1 > curNum2) {
                if (mid1Index == resultIndex) {
                    result += curNum2;
                }
                if (mid2Index == resultIndex) {
                    result += curNum2;
                }
                nums2Index++;
            } else {
                if (mid1Index == resultIndex) {
                    result += curNum1;
                }
                if (mid2Index == resultIndex) {
                    result += curNum1;
                }
                nums1Index++;
            }
            if (resultIndex >= mid1Index && resultIndex >= mid2Index) {
                return result / 2;
            }
            resultIndex++;
        }
    }
}
