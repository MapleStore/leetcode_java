package darren.gong.leetcode;

public class Calculate224 {
  public static void main(String[] args) {
    Calculate224 calculate224 = new Calculate224();
    calculate224.calculate("2147483647");
  }
  int currentIndex = 0;
  public int calculate(String s) {
    int preNum = 0;
    char preOperate = '+';
    while (currentIndex <= s.length()-1) {
      if (s.charAt(currentIndex) == ' ') {
        currentIndex++;
        continue;
      }

      char currentChar = s.charAt(currentIndex);
      if (currentChar == '+' || currentChar == '-') {
        preOperate = currentChar;
        currentIndex++;
      } else if (currentChar == '(') {
        currentIndex++;
        if (preOperate == '+') {
          preNum += calculate(s);
        } else if (preOperate == '-') {
          preNum -= calculate(s);
        }
        currentIndex++;
      } else if (currentChar == ')') {
        return preNum;
      } else {
        int numIndex = currentIndex;
        StringBuilder sb = new StringBuilder();
        while (numIndex <= s.length()-1) {
          char numChar = s.charAt(numIndex);
          if (numChar <= '9' && numChar >= '0') {
            sb.append(numChar);
            numIndex++;
          } else {
            break;
          }
        }
        if (preOperate == '+') {
          preNum += Integer.parseInt(sb.toString());
        } else if (preOperate == '-') {
          preNum -= Integer.parseInt(sb.toString());
        }
        currentIndex = numIndex;
      }
    }
    return preNum;
  }
}
