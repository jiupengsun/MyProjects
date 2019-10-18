package com.samy.leetcode.algorithm.medium;

public class ReverseWordsinaString {

  /**
   * https://leetcode.com/problems/reverse-words-in-a-string/description/
   *
   * @param s
   * @return
   */
  public String reverseWords(String s) {
    s = s.trim();
    if (s.equals(""))
      return "";
    s = reverse(s, 0, s.length() - 1);
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while (j < s.length()) {
      while (j < s.length() && s.charAt(j) != ' ')
        ++j;
      if (j < s.length()) {
        String tmp = reverse(s, i, j - 1);
        sb.append(tmp + " ");
      }
      while (j < s.length() && s.charAt(j) == ' ')
        ++j;
      if (j < s.length())
        i = j;
    }
    if (i <= j - 1)
      sb.append(reverse(s, i, j - 1));
    else
      sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  private String reverse(String s, int i, int j) {
    if (i == j)
      return s.charAt(i) + "";
    char[] array = s.substring(i, j + 1).toCharArray();
    for (int m = 0, n = array.length - 1; m < n; ++m, --n) {
      char tmp = array[m];
      array[m] = array[n];
      array[n] = tmp;
    }
    return String.valueOf(array);
  }
}
