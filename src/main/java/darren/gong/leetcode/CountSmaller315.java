package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class CountSmaller315 {
  public static void main(String[] args) {
    CountSmaller315 countSmaller315 = new CountSmaller315();
    countSmaller315.countSmaller(new int[]{2,0,1});
  }
  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    int length = nums.length;
    Node[] newNums = new Node[length];
    for (int i = 0; i < length; i++) {
      newNums[i] = new Node(i, nums[i], 0);
    }
    mergeSort(newNums, 0, length-1, new Node[length]);
    for (Node node : newNums) {
      nums[node.index] = node.value;
    }
    List<Integer> result = new ArrayList<>(length);
    for (int value : nums) {
      result.add(value);
    }
    return result;
  }
  private class Node {
    int index;
    int num;
    int value;
    private Node(int index, int num, int value) {
      this.index = index;
      this.value = value;
      this.num = num;
    }
  }
  private void mergeSort(Node[] nums, int start, int end, Node[] temp) {
    if (start >= end) {
      return;
    }
    if (start == end-1) {
      if (nums[start].num > nums[end].num) {
        nums[start].value++;
        Node tempNode = nums[start];
        nums[start] = nums[end];
        nums[end] = tempNode;
      }
      return;
    }

    int mid = start+((end-start)>>>1);
    mergeSort(nums, start, mid, temp);
    mergeSort(nums, mid+1, end, temp);
    if (nums[mid].num <= nums[mid+1].num) {
      return;
    }

    for (int i = start; i <= end; i++) {
      temp[i] = nums[i];
    }
    int index = start;
    int left = start;
    int right = mid+1;
    while (index <= end) {
      if (left > mid) {
        nums[index++] = temp[right];
        right++;
      } else if (right > end) {
        nums[index++] = temp[left];
        temp[left].value += right-mid-1;
        left++;
      } else if (temp[left].num > temp[right].num) {
        nums[index++] = temp[right];
        right++;
      } else {
        nums[index++] = temp[left];
        temp[left].value += right-mid-1;
        left++;
      }
    }
    return;
  }
}
