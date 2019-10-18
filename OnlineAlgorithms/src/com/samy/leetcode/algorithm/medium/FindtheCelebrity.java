package com.samy.leetcode.algorithm.medium;

public class FindtheCelebrity {
  /**
   * https://leetcode.com/problems/find-the-celebrity/description/
   *
   * @param n
   * @return
   */
  public int findCelebrity(int n) {
    int celebrity = 0;
    for (int i = 1; i < n; ++i) {
      if (knows(celebrity, i))
        celebrity = i;
    }
    for (int i = 0; i < n; ++i) {
      if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) {
        celebrity = -1;
        break;
      }
    }
    return celebrity;
  }

  private boolean knows(int i, int j) {
    return false;
  }
}
