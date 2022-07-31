package darren.gong.leetcode;

public class MaxFont_1618 {
  // 1618. 找出适应屏幕的最大字号
  private interface FontInfo {
    // Return the width of char ch when fontSize is used.
    public int getWidth(int fontSize, char ch);
    // Return Height of any char when fontSize is used.
    public int getHeight(int fontSize);
  }

  public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
    int left = 0;
    int right = fonts.length-1;
    while (left <= right) {
      int mid = left+((right-left)>>>1);
      boolean canPrint = canPrint(text, fonts[mid], fontInfo, w, h);
      if (canPrint) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    return right < 0 ? -1 :fonts[right];
  }
  private boolean canPrint(String text, int font, FontInfo fontInfo, int maxWidth, int maxHeight) {
    if (fontInfo.getHeight(font) > maxHeight) {
      return false;
    }
    int width = 0;
    for (char oneChar : text.toCharArray()) {
      width += fontInfo.getWidth(font, oneChar);
      if (width > maxWidth) {
        return false;
      }
    }
    return true;
  }
}
