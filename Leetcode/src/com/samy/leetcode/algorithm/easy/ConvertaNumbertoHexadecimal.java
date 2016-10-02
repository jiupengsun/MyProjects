package com.samy.leetcode.algorithm.easy;

/**
 * Created by samy on 10/2/16.
 */
public class ConvertaNumbertoHexadecimal {

  /**
   * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
   * @param num
   * @return
   */
  public static String toHex(int num) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<=28; i+=4) {
      int j = num >>> i;
      if (j == 0)
        break;
      j &= 0xF;
      char c;
      if (j < 10) {
        c = '0';
        c += j;
      } else {
        c = 'a';
        c += (j - 10);
      }
      sb.append(c);
    }
    if (sb.length() == 0)
      sb.append('0');
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    int a = 26;
    System.out.println(ConvertaNumbertoHexadecimal.toHex(a));
  }
}
