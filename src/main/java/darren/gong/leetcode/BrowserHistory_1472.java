package darren.gong.leetcode;

public class BrowserHistory_1472 {
  public static void main(String[] args) {
    BrowserHistory_1472 browserHistory_1472 = new BrowserHistory_1472("leetcode.com");
    browserHistory_1472.visit("google.com");
    browserHistory_1472.visit("facebook.com");
    browserHistory_1472.visit("youtube.com");
    browserHistory_1472.back(1);
    browserHistory_1472.back(1);
    browserHistory_1472.forward(1);
  }
  private int currentIndex = 0;
  private int endIndex = 0;
  private String[] webs = new String[5001];
  public BrowserHistory_1472(String homepage) {
    webs[currentIndex] = homepage;
  }

  public void visit(String url) {
    webs[++currentIndex] = url;
    endIndex = currentIndex;
  }

  public String back(int steps) {
    currentIndex = Math.max(currentIndex-steps, 0);
    return webs[currentIndex];
  }

  public String forward(int steps) {
    currentIndex = Math.min(endIndex, currentIndex+steps);
    return webs[currentIndex];
  }
}
