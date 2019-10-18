package com.samy.company.chinalife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samy on 11/9/16.
 */
public class Test {

  public static void main(String[] args) {
    Test t = new Test();
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> list = t.subsets(nums);
    for (List<Integer> l : list) {
      for (int i : l)
        System.out.print(i);
      System.out.println();
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(new ArrayList<>());
    for (int i : nums) {
      int length = list.size();
      for (int j = 0; j < length; ++j) {
        List<Integer> l = new ArrayList<>(list.get(j));
        l.add(i);
        list.add(l);
      }
    }
    return list;
  }
}
