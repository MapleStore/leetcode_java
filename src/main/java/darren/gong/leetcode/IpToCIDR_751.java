package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class IpToCIDR_751 {
  public static void main(String[] args) {
    System.out.println(Long.lowestOneBit(0));
    IpToCIDR_751 ipToCIDR_751 = new IpToCIDR_751();
    ipToCIDR_751.ipToCIDR("0.0.0.0", 1);
  }
  // 751. IP 到 CIDR
  public List<String> ipToCIDR(String ip, int n) {
    String[] ips = ip.split("\\.");
    long num = 0;
    for (String oneAreaOfIp : ips) {
      num = (num<<8)+Integer.parseInt(oneAreaOfIp);
    }
    List<String> result = new LinkedList<>();
    while (n > 0) {
      long lowestOneBitNum = num&(-num);
      if (lowestOneBitNum == 0) {
        lowestOneBitNum = countMaxN(n);
      }
      while (lowestOneBitNum > n) {
        lowestOneBitNum = lowestOneBitNum>>>1;
      }
      result.add(parseAddress(num, lowestOneBitNum));
      n -= lowestOneBitNum;
      num += lowestOneBitNum;
    }
    return result;
  }

  private int countMaxN(int n) {
    int i = 1;
    while ((1<<i) <= n) {
      i++;
    }
    return 1<<(i-1);
  }

  private int mask = 0x000000FF;
  private String parseAddress(long num, long add) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      sb.insert(0, (num&mask)+".");
      num = (num>>>8);
    }
    sb.deleteCharAt(sb.length()-1);
    int pos = 0;
    while (add > 0) {
      add = (add>>>1);
      pos++;
    }
    sb.append("/").append(33-pos);
    return sb.toString();
  }
}
