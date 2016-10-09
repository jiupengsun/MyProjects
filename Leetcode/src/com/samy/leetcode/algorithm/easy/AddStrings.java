package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/add-strings/
 * Created by samy on 10/9/16.
 */
public class AddStrings {

  public String addStrings(String num1, String num2) {
    int l1 = num1.length(), l2=num2.length();
    char[] sum = new char[Math.max(l1, l2) + 1];

    int carry = 0, i=l1-1, j=l2-1, k=sum.length-1;
    for (; i>-1 & j>-1; --i, --j, --k) {
      int n1 = num1.charAt(i) - '0';
      int n2 = num2.charAt(j) - '0';
      int s = n1 + n2 + carry;
      carry = s / 10;
      sum[k] = (char)(s - carry * 10 + '0');
    }

    int m = -1;
    String num = "";

    if (i > -1) {
      m = i;
      num = num1;
    } else if (j > -1) {
      m = j;
      num = num2;
    }

    for (; m > -1; --m, --k) {
      int n = num.charAt(m) - '0';
      int s = n + carry;
      carry = s / 10;
      sum[k] = (char)(s - carry * 10 + '0');
    }

    StringBuilder sb = new StringBuilder();
    k = 0;
    if (sum[0] == 0) {
      if (carry > 0)
        sum[0] = (char)(carry + '0');
      else
        ++k;
    }

    for (; k<sum.length; ++k) {
      sb.append(sum[k]);
    }
    return sb.toString();
  }
}
