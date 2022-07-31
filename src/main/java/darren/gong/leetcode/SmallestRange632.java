package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SmallestRange632 {
  public static void main(String[] args) {
    SmallestRange632 smallestRange632 = new SmallestRange632();
    List<List<Integer>> nums = new ArrayList<>();
    nums.add(new ArrayList<>(Arrays.asList(4,10,15,24,26)));
    nums.add(new ArrayList<>(Arrays.asList(0,9,12,20)));
    nums.add(new ArrayList<>(Arrays.asList(5,18,22,30)));
    smallestRange632.smallestRange(nums);
  }
  public int[] smallestRange(List<List<Integer>> nums) {
    if (nums == null || nums.size() == 0) {
      return null;
    }
    int size = nums.size();
    // 数字对应，数字所在的所有list id的集合
    Map<Integer, Set<Integer>> numToListIds = new HashMap<>();
    for (int i = 0; i < size; i++) {
      List<Integer> list = nums.get(i);
      for (Integer num : list) {
        Set<Integer> ids = numToListIds.get(num);
        if (ids == null) {
          ids = new HashSet<>();
          numToListIds.put(num, ids);
        }
        ids.add(i);
      }
    }

    List<Integer> allNum = new ArrayList<>(numToListIds.keySet());
    Collections.sort(allNum);
    int left = 0;
    int right = 0;
    int bigResult = Integer.MAX_VALUE;
    int smallResult = 0;
    // list id及这个list id出现的次数
    Map<Integer, Integer> map = new HashMap<>();
    while (right < allNum.size()) {
      int rightValue = allNum.get(right);
      Set<Integer> ids = numToListIds.get(rightValue);
      for (int listId : ids) {
        map.put(listId, map.getOrDefault(listId, 0)+1);
      }
      while (map.size() >= size) {
        int leftValue = allNum.get(left);
        if (rightValue-leftValue < bigResult-smallResult) {
          bigResult = rightValue;
          smallResult = leftValue;
        }
        ids = numToListIds.get(leftValue);
        for (int listId : ids) {
          int appearTimes = map.get(listId);
          if (appearTimes == 1) {
            map.remove(listId);
          } else {
            map.put(listId, appearTimes-1);
          }
        }
        left++;
      }
      right++;
    }
    return new int[]{smallResult, bigResult};
  }
}
