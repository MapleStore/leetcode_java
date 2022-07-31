package darren.gong.leetcode;

public class CanEat_1744 {
  public static void main(String[] args) {
    CanEat_1744 canEat_1744 = new CanEat_1744();
    canEat_1744.canEat(new int[]{5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114},
        new int[][]{{91,244597,840227137}});
  }
  public boolean[] canEat(int[] candiesCount, int[][] queries) {
    // [favoriteType, favoriteDay, dailyCap]
    int candiesLength = candiesCount.length;
    long[] candiesCountPrefix = new long[candiesLength];
    for (int i = 1; i < candiesLength; i++) {
      candiesCountPrefix[i] = candiesCountPrefix[i-1]+candiesCount[i-1];
    }

    int resultLength = queries.length;
    boolean[] answers = new boolean[resultLength];
    int index = 0;
    for (int[] query : queries) {
      long preEat = candiesCountPrefix[query[0]];
      long currentEat = candiesCount[query[0]];
      long minEat = query[1];
      answers[index++] = (preEat+currentEat > minEat && preEat < ((long)query[1]+1)*(long)query[2]);
    }
    return answers;
  }
}
