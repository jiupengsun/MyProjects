package com.samy.leetcode.algorithm.medium;

public class StringtoInteger {

  /**
   * https://leetcode.com/problems/string-to-integer-atoi/description/
   * @param str
   * @return
   */
  public int myAtoi(String str) {
    if(str.length() == 0)
      return 0;
    str = str.trim();
    boolean pos = true;
    boolean digit = false;
    int i=0;
    if(str.charAt(0) == '-') {
      pos = false;
      ++i;
      digit = true;
    } else if(str.charAt(0) == '+') {
      ++i;
      digit = true;
    }
    long d = 0;
    while(i < str.length()) {
      int c = str.charAt(i) - '0';
      if(c < 0 || c > 9) {
        if(digit || str.charAt(i)!=' ')
          return pos ? (int) d : (int) -d;
        else
          c = 0;
      } else
        digit = true;
      d = d*10 + c;
      if(pos && d>Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
      else if(!pos && -d < Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      ++i;
    }
    return pos ? (int) d : (int) -d;
  }
}
