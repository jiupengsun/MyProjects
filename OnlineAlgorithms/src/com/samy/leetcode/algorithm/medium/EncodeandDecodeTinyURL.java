package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL {
  private Map<String, String> urlToTiny = new HashMap<>();
  private Map<String, String> tinyToUrl = new HashMap<>();
  private long seq = 0;

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    if(urlToTiny.containsKey(longUrl))
      return urlToTiny.get(longUrl);
    String s = String.valueOf(seq++);
    urlToTiny.put(longUrl, s);
    tinyToUrl.put(s, longUrl);
    return s;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return tinyToUrl.get(shortUrl);
  }
}
