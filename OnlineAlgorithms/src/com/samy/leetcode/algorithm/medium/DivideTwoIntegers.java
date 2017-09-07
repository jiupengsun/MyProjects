package com.samy.leetcode.algorithm.medium;

public class DivideTwoIntegers {

  /**
   * https://leetcode.com/problems/divide-two-integers/description/
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {
    if(divisor == 0)
      return Integer.MAX_VALUE;
    int sign = (dividend ^ divisor) & 0x80000000;
    long dd = dividend;
    dd = Math.abs(dd);
    long dv = divisor;
    dv = Math.abs(dv);
    long res = 0;
    while(dd >= dv) {
      long tmp = dv, exp = 0l;
      while(dd >= (tmp << 1)) {
        tmp <<= 1;
        exp++;
      }
      res += 1 << exp;
      dd -= tmp;
    }
    res = sign==0 ? Math.min(res, Integer.MAX_VALUE) : Math.max(-res, Integer.MIN_VALUE);
    return (int)res;
  }

  public static void main(String[] args) {
    int dd = Integer.MAX_VALUE, dv = 1;
    DivideTwoIntegers dti = new DivideTwoIntegers();
    dti.divide(dd, dv);
  }
}
