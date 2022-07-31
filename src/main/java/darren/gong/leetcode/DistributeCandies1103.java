package darren.gong.leetcode;

public class DistributeCandies1103 {
  public static void main(String[] args) {
    DistributeCandies1103 distributeCandies1103 = new DistributeCandies1103();
    distributeCandies1103.distributeCandies((int)Math.pow(10, 9), 3);
  }
  public int[] distributeCandies(int candies, int num_people) {
    int num = (int)(Math.sqrt(0.25+2*candies)-0.5); // 轮流几人次
    int remaining = candies-(1+num)*num/2; // 最后多少加到最后一个

    int loopOneNum = num/num_people; // 全部人能分几轮
    int loopTwoRemaining = num%num_people;

    int[] result = new int[num_people];
    for (int i = 0; i < num_people; i++) {
      result[i] = (i+1+i+1+num_people*(loopOneNum-1))*loopOneNum/2;
    }
    int base = loopOneNum*num_people;
    for (int i = 0; i < loopTwoRemaining; i++) {
      result[i] += base+i+1;
    }
    result[loopTwoRemaining] += remaining;
    return result;
  }
}
