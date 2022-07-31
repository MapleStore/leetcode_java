package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k > arr.length) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = 0;
        for (int i = -1; i < arr.length; i++) {
            if (i+1 == arr.length || arr[i+1] >= x) {
                left = i;
                right = i+1;
                break;
            }
        }
        while (right - left - 1 < k) {
            int leftValue = left < 0 ? -100000 : arr[left];
            int rightValue = right >= arr.length ? 100000 : arr[right];
            if (Math.abs(x-leftValue) > Math.abs(x-rightValue)) {
                right++;
            } else {
                left--;
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = left+1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
