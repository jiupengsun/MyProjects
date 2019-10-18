package com.samy.leetcode.algorithm.medium;

public class MultiplyStrings {
  /**
   * https://leetcode.com/problems/multiply-strings/description/
   *
   * @param num1
   * @param num2
   * @return
   */
  public String multiply(String num1, String num2) {
    int l1 = num1.length(), l2 = num2.length();
    int[] r = new int[l1 + l2];
    for (int j = l2 - 1, k = r.length - 1; j >= 0; --j, --k) {
      int b = num2.charAt(j) - '0';
      if (b == 0)
        continue;
      for (int i = 0; i < l1; ++i) {
        int a = num1.charAt(l1 - i - 1) - '0';
        r[k - i] += a * b;
      }
    }
    int carry = 0;
    for (int k = r.length - 1; k >= 0; --k) {
      r[k] += carry;
      carry = r[k] / 10;
      r[k] %= 10;
    }
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < r.length - 1 && r[i] == 0)
      ++i;
    while (i < r.length)
      sb.append(String.valueOf(r[i++]));
    return sb.toString();
  }
}
