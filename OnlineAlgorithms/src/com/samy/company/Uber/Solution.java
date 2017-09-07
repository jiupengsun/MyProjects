package com.samy.company.Uber;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

  /**
   * http://www.1point3acres.com/bbs/thread-192483-1-1.html
   * @param loginTime
   */
  public static void countLoginUsers(float[][] loginTime) {
    TreeMap<Float, Integer> map = new TreeMap<>();
    for(int i=0; i<loginTime.length; ++i) {
      map.put(loginTime[i][0], map.getOrDefault(loginTime[i][0], 0) + 1);
      map.put(loginTime[i][1], map.getOrDefault(loginTime[i][1], 0) - 1);
    }
    int count = 0;
    for(Map.Entry<Float, Integer> m: map.entrySet()) {
      count += m.getValue();
      System.out.println(m.getKey() + " " + count);
    }
  }

  public static void main(String[] args) {
    float[][] loginTime = new float[][]{
      {1.1f, 2.3f}, {1.3f, 3.4f}
    };
    countLoginUsers(loginTime);
  }
}
