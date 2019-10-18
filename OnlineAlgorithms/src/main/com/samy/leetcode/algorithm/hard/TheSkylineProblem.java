package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class TheSkylineProblem {
  /**
   * https://leetcode.com/problems/the-skyline-problem/description/
   *
   * @param buildings
   * @return This method needs O^2 running time, which may TTL
   */
  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> sky = new ArrayList<>();
    if (buildings == null || buildings.length == 0)
      return sky;
    Map<Integer, Integer> points = new HashMap<>();
    // add all critic points
    for (int[] b : buildings) {
      int left = b[0], right = b[1], height = b[2];
      points.put(left, Math.max(height, points.getOrDefault(left, 0)));
      points.put(right, points.getOrDefault(right, 0));
    }
    // traverse all the critical points update those points
    // that was covered by higher building
    for (int[] b : buildings) {
      int left = b[0], right = b[1], height = b[2];
      for (Integer x : points.keySet()) {
        int y = points.get(x);
        if (left <= x && x < right)
          points.put(x, Math.max(y, height));
      }
    }
    // put map to array
    int[][] lines = new int[points.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> e : points.entrySet()) {
      int x = e.getKey(), y = e.getValue();
      lines[i++] = (new int[]{x, y});
    }
    // sort
    Arrays.sort(lines, new Comparator<int[]>() {
      @Override
      public int compare(int[] p1, int[] p2) {
        return Integer.compare(p1[0], p2[0]);
      }
    });
    // merge
    int[] p = lines[0];
    for (i = 1; i < lines.length; ++i) {
      // same height, then merge
      if (p[1] == lines[i][1])
        continue;
      sky.add(p);
      p = lines[i];
    }
    sky.add(p);
    return sky;
  }

  /**
   * O(n) time complexity solution
   *
   * @param buildings
   * @return
   */
  public List<int[]> getSkyline2(int[][] buildings) {
    List<int[]> sky = new ArrayList<>();
    PriorityQueue<int[]> points = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0])
          return o1[0] - o2[0];
        else
          return o1[1] - o2[1];
      }
    });
    // sort height in descending order
    PriorityQueue<Integer> height = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    // add critical points
    for (int[] b : buildings) {
      points.add(new int[]{b[0], b[2]});
      points.add(new int[]{b[1], -b[2]});
    }
    int[] lastPoint = null;
    while (!points.isEmpty()) {
      int[] p = points.poll();
      if (p[1] > 0) {
        // left point
        height.add(p[1]);
        p[1] = height.peek();
      } else {
        // right point
        height.remove(-p[1]);
        p[1] = height.isEmpty() ? 0 : height.peek();
      }
      int[] nextP = points.peek();
      if (nextP != null && nextP[0] == p[0])
        continue;
      if (lastPoint == null || lastPoint[1] != p[1]) {
        sky.add(p);
        lastPoint = p;
      }
    }
    return sky;
  }
}
