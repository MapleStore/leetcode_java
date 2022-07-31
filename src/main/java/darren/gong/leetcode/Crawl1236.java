package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Crawl1236 {
  public static void main(String[] args) {
    String startUrlPre = "http://news.yahoo.com/news/topics/".substring(7, "http://news.yahoo.com/news/topics/".indexOf("/", 7));
    System.out.println(startUrlPre);
  }
  private interface HtmlParser {
    public List<String> getUrls(String url);
  }

  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    Set<String> result = new HashSet<>();
    result.add(startUrl);
    String startUrlPre = startUrl.substring(7, startUrl.indexOf("/", 7) == -1 ? startUrl.length() : startUrl.indexOf("/", 7));
    Queue<String> queue = new LinkedList<>();
    queue.add(startUrl);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String url = queue.poll();
        List<String> nextUrls = htmlParser.getUrls(url);
        for (String nextUrl : nextUrls) {
          String nextUrlPre = nextUrl.substring(7, nextUrl.indexOf("/", 7) == -1 ? nextUrl.length() : nextUrl.indexOf("/", 7));
          if (nextUrlPre.equals(startUrlPre) && !result.contains(nextUrl)) {
            queue.add(nextUrl);
            result.add(nextUrl);
          }
        }
      }
    }
    return new LinkedList<>(result);
  }
}
