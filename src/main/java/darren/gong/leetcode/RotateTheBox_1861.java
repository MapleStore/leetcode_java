package darren.gong.leetcode;

public class RotateTheBox_1861 {
  public static void main(String[] args) {
    RotateTheBox_1861 rotateTheBox_1861 = new RotateTheBox_1861();
    rotateTheBox_1861.rotateTheBox(new char[][]{{'#','.','*','.'},
        {'#','#','*','.'}});
  }
  public char[][] rotateTheBox(char[][] box) {
    int maxX = box.length;
    int maxY = box[0].length;
    for (int i = 0; i < maxX; i++) {
      char[] line = box[i];
      turnRight(line);
    }
    char[][] result = new char[maxY][maxX];
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        result[j][maxX-1-i] = box[i][j];
      }
    }
    return result;
  }

  private char[] turnRight(char[] line) {
    int fillPos = line.length;
    int count = 0;
    for (int i = line.length-1; i >= 0; i--) {
      if (line[i] == '#') {
        count++;
        continue;
      }
      if (line[i] == '*') {
        while (count > 0) {
          line[--fillPos] = '#';
          count--;
        }
        while (--fillPos > i) {
          line[fillPos] = '.';
        }
      }
    }
    while (count > 0) {
      line[--fillPos] = '#';
      count--;
    }
    while (--fillPos >= 0) {
      line[fillPos] = '.';
    }
    return line;
  }
}
