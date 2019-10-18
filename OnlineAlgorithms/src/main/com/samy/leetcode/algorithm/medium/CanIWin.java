package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

  public static void main(String[] args) {
    CanIWin ciw = new CanIWin();
    System.out.println(ciw.canIWin(19, 132));
  }

  /**
   * @param maxChoosableInteger
   * @param desiredTotal
   * @return
   */
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal == 0)
      return true;
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
      return false;
    return helper(0, maxChoosableInteger, desiredTotal, new HashMap<>());
  }

  /**
   * @param nums         contains available numbers
   * @param b            true means A choose, otherwise B
   * @param desiredTotal
   * @return
   */
  private boolean helper(int nums, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> map) {
    if (desiredTotal <= 0)
      return false;
    int key = nums;
    Boolean r = map.get(key);
    if (r != null)
      return r;
    for (int i = 0; i < maxChoosableInteger; ++i) {
      int mask = 1 << i, unmask = ~mask;
      if ((nums & mask) == 0) {
        // available number
        nums |= mask;
        if (!helper(nums, maxChoosableInteger, desiredTotal - i - 1, map)) {
          // opponent loses
          map.put(key, true);
          return true;
        }
        nums &= unmask;
      }
    }
    map.put(key, false);
    return false;
  }
}
