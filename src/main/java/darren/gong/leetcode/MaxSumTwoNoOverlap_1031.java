package darren.gong.leetcode;

import java.util.Arrays;

public class MaxSumTwoNoOverlap_1031 {
  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    int length = A.length;
    int result = Integer.MIN_VALUE;
    for (int i = 1; i < length; i++) {
      A[i] += A[i-1];
    }
    for (int i = L-1; i < length; i++) {
      int valueL = A[i]-(i-L >= 0 ? A[i-L] : 0);
      int valueM = Integer.MIN_VALUE;
      for (int j = M-1; j <= i-L; j++) {
        valueM = Math.max(valueM, A[j]-(j-M >= 0 ? A[j-M] : 0));
      }
      for (int j = i+M; j < length; j++) {
        valueM = Math.max(valueM, A[j]-A[j-M]);
      }
      result = Math.max(result, valueL+valueM);
    }
    return result;
  }
  public int maxSumTwoNoOverlap2(int[] A, int L, int M) {
    int length = A.length;
    int result = Integer.MIN_VALUE;
    for (int i = 1; i < length; i++) {
      A[i] += A[i-1];
    }
    int[] dpL = new int[length];
    int lMax = 0;
    for (int i = L-1; i < length; i++) {
      lMax = Math.max(lMax, A[i]-(i-L >= 0 ? A[i-L] : 0));
      dpL[i] = lMax;
    }
    int[] dpM = new int[length];
    int mMax = 0;
    for (int i = M-1; i < length; i++) {
      mMax = Math.max(mMax, A[i]-(i-M >= 0 ? A[i-M] : 0));
      dpM[i] = mMax;
    }

    for (int i = L-1; i < length; i++) {
      int valueM = i-L >= 0 ? dpM[i-L] : 0;
      result = Math.max(result, valueM+A[i]-(i-L >= 0 ? A[i-L] : 0));
    }

    for (int i = M-1; i < length; i++) {
      int valueL = i-M >= 0 ? dpL[i-M] : 0;
      result = Math.max(result, valueL+A[i]-(i-M >= 0 ? A[i-M] : 0));
    }
    return result;
  }

}
