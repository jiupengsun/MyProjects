package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 * Created by samy on 10/24/16.
 */
public class FizzBuzz {

  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<>();
    String[] initial = new String[]{"1", "2", "Fizz", "4", "Buzz"};

    for (int i=0, j=Math.min(n, 5); i<j; ++i)
      list.add(initial[i]);

    for (int i=5; i<n; ++i) {
      StringBuilder sb = new StringBuilder("");
      if(list.get(i-3).contains("F"))
        sb.append("Fizz");
      if(list.get(i-5).contains("B"))
        sb.append("Buzz");
      if(sb.length() == 0)
        sb.append(i + 1);
      list.add(sb.toString());
    }

    return list;
  }
}
