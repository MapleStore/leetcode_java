package darren.gong.leetcode;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] A) {
        int changeIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[changeIndex];
                A[changeIndex] = A[i];
                A[i] = temp;
                changeIndex++;
            }
        }
        return A;
    }
}
