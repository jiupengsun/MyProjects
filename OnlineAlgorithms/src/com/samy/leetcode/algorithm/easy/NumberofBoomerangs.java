package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 * Created by samy on 11/19/16.
 */
public class NumberofBoomerangs {

  public int numberOfBoomerangs(int[][] points) {
    int count = 0;
    for(int i=0, l=points.length; i<l; ++i) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int j = 0; j < l; ++j) {
        if(i == j)
          continue;
        int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                           + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
        Integer num = map.get(distance);
        if(num == null) {
          map.put(distance, 1);
        } else {
          map.put(distance, num+1);
          count += num << 1;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] points = new int[][] {
        {0,0}, {1,0}, {2,0}
    };
    NumberofBoomerangs nb = new NumberofBoomerangs();
    System.out.println(nb.numberOfBoomerangs(points));
  }
}
