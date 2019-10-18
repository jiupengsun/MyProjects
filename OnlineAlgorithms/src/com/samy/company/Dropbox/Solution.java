package com.samy.company.Dropbox;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {

  /**
   * Given a byte array and file, judge if the byte array exists in the file
   *
   * @param f
   * @param array
   * @return
   */
  public boolean exist(File f, byte[] array) {
    return false;
  }

  /**
   * bfs version
   *
   * @param url
   * @return
   */
  public List<String> getUrl(String url) {
    Set<String> visit = new HashSet<>();
    // bfs
    // modified multiple-thread version
    BlockingQueue<String> que = new LinkedBlockingQueue<>();

    que.add(url);
    while (!que.isEmpty()) {
      String u = que.poll();
      visit.add(u);
      List<String> next = getNextUrl(u);
      for (String s : next) {
        if (!visit.contains(s))
          que.add(s);
      }
    }
    return new ArrayList<>(visit);
  }

  /**
   * IDS version
   *
   * @param url
   * @return
   */
  public void DFS(String url, int depth, Set<String> visit) {
    if (depth == 0)
      return;
    visit.add(url);
    List<String> next = getNextUrl(url);
    for (String s : next) {
      if (!visit.contains(s))
        DFS(s, depth - 1, visit);
    }
  }

  private List<String> getNextUrl(String url) {
    return null;
  }
}
