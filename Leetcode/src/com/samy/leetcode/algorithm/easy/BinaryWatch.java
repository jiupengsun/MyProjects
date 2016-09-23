package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by samy on 9/23/16.
 */
public class BinaryWatch {

  /**
   * https://leetcode.com/problems/binary-watch/
   * @param num
   * @return
   */
  public List<String> readBinaryWatch(int num) {

    List<Boolean[]> time = getTime(10, num);
    List<String> l = new ArrayList<>();
    for (Boolean[] b : time) {
      String s = transform(b);
      if (!s.equals(""))
        l.add(s);
    }

    return l;
  }

  private List<Boolean[]> getTime(int length, int n) {
    List<Boolean[]> list = new ArrayList();
    if (length < 0 || n < 0)
      return list;
    if (n == 0) {
      if (length == 0)
        return list;
      Boolean[] b = new Boolean[length];
      list.add(b);
      return list;
    } else if (n > length)
      return list;
    else if (n == length) {
      Boolean[] b = new Boolean[length];
      Arrays.fill(b, true);
      list.add(b);
      return list;
    }
    else {
      List<Boolean[]> l1 = getTime(length-1, n);
      for (Boolean[] b : l1) {
        Boolean[] b0 = new Boolean[length];
        for (int i=1; i<length; ++i)
          b0[i] = b[i-1];
        list.add(b0);
      }
      List<Boolean[]> l2 = getTime(length-1, n-1);
      for (Boolean[] b : l2) {
        Boolean[] b0 = new Boolean[length];
        b0[0] = true;
        for (int i=1; i<length; ++i)
          b0[i] = b[i-1];
        list.add(b0);
      }
      return list;
    }
  }


  private String transform(Boolean[] time) {

    int hour = 0;
    int minute = 0;
    for (int i=0; i<4; hour<<=1, ++i)
      if (time[i] != null && time[i])
        hour |= 1;
    hour >>= 1;
    for (int i=4; i<10; minute<<=1, ++i)
      if (time[i] != null && time[i])
        minute |= 1;
    minute >>= 1;
    if (hour > 11 || minute > 59)
      return "";
    StringBuilder sb = new StringBuilder(hour + ":");
    if (minute < 10)
      sb.append("0");
    sb.append(minute);
    return sb.toString();
  }

  public static void main(String[] args) {
    BinaryWatch bw = new BinaryWatch();
    List<String> l1 = bw.readBinaryWatch(10);
    for (String s : l1)
      System.out.println(s);
  }
}
