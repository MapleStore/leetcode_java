package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Codec535 {
    Map<String, String> numToSourceUrl = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long time = System.currentTimeMillis();
        numToSourceUrl.put(time+"", longUrl);
        return "http://tinyurl.com/" + time;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String search = shortUrl.replace("http://tinyurl.com/", "");
        return numToSourceUrl.get(search);
    }
}
