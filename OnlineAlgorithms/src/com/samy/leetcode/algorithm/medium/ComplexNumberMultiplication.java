package com.samy.leetcode.algorithm.medium;

public class ComplexNumberMultiplication {

  /**
   * https://leetcode.com/submissions/detail/115554886/
   * @param a
   * @param b
   * @return
   */
  public String complexNumberMultiply(String a, String b) {
    int i_a=0, i_b=0;
    int c_a=0, c_b=0;
    int pos_a = a.indexOf("+"), pos_b = b.indexOf("+");
    String constant = a.substring(0, pos_a);
    String coefficient = a.substring(pos_a+1, a.length()-1);
    c_a = Integer.parseInt(constant);
    i_a = Integer.parseInt(coefficient);
    constant = b.substring(0, pos_b);
    coefficient = b.substring(pos_b+1, b.length()-1);
    c_b = Integer.parseInt(constant);
    i_b = Integer.parseInt(coefficient);
    int c = c_a*c_b - i_a*i_b;
    int i = i_a*c_b + i_b*c_a;
    return "" + c + "+" + i + "i";
  }
}
