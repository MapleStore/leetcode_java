package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    //my result
    public int[] myTwoSum(int[] nums, int target) {
        int []result = new int[2];
        boolean flag = false;
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    flag = true;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    public int[] twoSum(int[] nums, int target) {
        int []result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int theOtherNumber = target - nums[i];
            if (map.containsKey(theOtherNumber)){
                result[0] = map.get(theOtherNumber);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("没有对应数字");
    }
    public static void main(String[] args){
        TwoSum solution = new TwoSum();
        System.out.println(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}