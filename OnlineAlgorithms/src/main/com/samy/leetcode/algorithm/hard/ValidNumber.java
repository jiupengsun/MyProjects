package com.samy.leetcode.algorithm.hard;

public class ValidNumber {

  /**
   * https://leetcode.com/problems/valid-number/description/
   *
   * @param s
   * @return
   */
  public boolean isNumber(String s) {
    s = s.trim();
    int i = 0, length = s.length();
    if (i == length)
      return false;
    boolean numericMode = false, digitMode = false,
      sciMode = false, plusMode = false;
    while (i < length) {
      char c = s.charAt(i);
      if (c == '+' || c == '-') {
        if (plusMode)
          return false;
        plusMode = true;
      } else {
        plusMode = true;
        if (c == '.' || c == 'e') {
          if (c == '.') {
            if (digitMode)
              return false;
            digitMode = true;
          } else {
            if (sciMode || !numericMode)
              return false;
            numericMode = false;
            digitMode = true;
            sciMode = true;
            plusMode = false;
          }
        } else if (c >= '0' && c <= '9') {
          numericMode = true;
        } else
          return false;
      }
      ++i;
    }
    return numericMode;
  }
}
