package darren.gong.leetcode;

public class TwoSum2 {
    public static void main(String[] args){
        TwoSum2 solution = new TwoSum2();
        System.out.println(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 1) {
            return new int[0];
        }
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                return new int[]{index1, index2};
            }
            if (numbers[index1] + numbers[index2] > target) {
                index2--;
            } else {
                index1++;
            }
        }

        return new int[0];
    }

}
