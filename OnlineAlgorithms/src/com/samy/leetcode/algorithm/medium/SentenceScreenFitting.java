package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class SentenceScreenFitting {

  /**
   * https://leetcode.com/problems/sentence-screen-fitting/description/
   *
   * @param sentence
   * @param rows
   * @param cols
   * @return too slow, beats 1.5% only
   */
  public int wordsTyping(String[] sentence, int rows, int cols) {
    int last = 0, index = 0, count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < rows; ) {
      if (index == 0 && last == 0 && count > 0) {
        // find repeat
        return (rows / i) * count + map.getOrDefault(rows % i, 0);
      }
      int length = sentence[index].length();
      if (last + length > cols) {
        last = 0;
        ++i;
        map.put(i, count);
      } else {
        if (last + length == cols) {
          last = 0;
          ++i;
          map.put(i, count);
        } else {
          last += length + 1;
        }
        ++index;
        if (index == sentence.length) {
          index = 0;
          ++count;
        }
      }
    }
    return count;
  }
}
