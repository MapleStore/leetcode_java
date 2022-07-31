package darren.gong.leetcode;

public class MinWindow727 {
  //"njlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzk"
  public static void main(String[] args) {
    MinWindow727 minWindow727 = new MinWindow727();
    minWindow727.minWindow("ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl",
        "ntimcimzah");
  }
  public String minWindow(String S, String T) {
    int left = 0;
    int right = 0;
    int matchIndex = 0;
    int tLength = T.length();
    int start = 0;
    int end = Integer.MAX_VALUE;
    while (right < S.length()) {
      if (S.charAt(right) == T.charAt(matchIndex)) {
        matchIndex++;
      }
      if (matchIndex == tLength) {
        left = right;
        while (matchIndex != 0) {
          if (T.charAt(matchIndex-1) == S.charAt(left--)) {
            matchIndex--;
          }
        }
        left++;
        if (right-left < end-start) {
          start = left;
          end = right;
        }
        matchIndex = 0;
        right = left;
      }
      right++;
    }
    if (end == Integer.MAX_VALUE) {
      return "";
    }
    return S.substring(start, end+1);
  }
}
