package com.samy.leetcode.algorithm.hard;

import com.samy.datastructure.Point;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {

  public static void main(String[] args) {
    int[][] p = new int[][]{{40, -23}, {9, 138}, {429, 115}, {50, -17}, {-3, 80}, {-10, 33}, {5, -21}, {-3, 80}, {-6, -65}, {-18, 26}, {-6, -65}, {5, 72}, {0, 77}, {-9, 86}, {10, -2}, {-8, 85}, {21, 130}, {18, -6}, {-18, 26}, {-1, -15}, {10, -2}, {8, 69}, {-4, 63}, {0, 3}, {-4, 40}, {-7, 84}, {-8, 7}, {30, 154}, {16, -5}, {6, 90}, {18, -6}, {5, 77}, {-4, 77}, {7, -13}, {-1, -45}, {16, -5}, {-9, 86}, {-16, 11}, {-7, 84}, {1, 76}, {3, 77}, {10, 67}, {1, -37}, {-10, -81}, {4, -11}, {-20, 13}, {-10, 77}, {6, -17}, {-27, 2}, {-10, -81}, {10, -1}, {-9, 1}, {-8, 43}, {2, 2}, {2, -21}, {3, 82}, {8, -1}, {10, -1}, {-9, 1}, {-12, 42}, {16, -5}, {-5, -61}, {20, -7}, {9, -35}, {10, 6}, {12, 106}, {5, -21}, {-5, 82}, {6, 71}, {-15, 34}, {-10, 87}, {-14, -12}, {12, 106}, {-5, 82}, {-46, -45}, {-4, 63}, {16, -5}, {4, 1}, {-3, -53}, {0, -17}, {9, 98}, {-18, 26}, {-9, 86}, {2, 77}, {-2, -49}, {1, 76}, {-3, -38}, {-8, 7}, {-17, -37}, {5, 72}, {10, -37}, {-4, -57}, {-3, -53}, {3, 74}, {-3, -11}, {-8, 7}, {1, 88}, {-12, 42}, {1, -37}, {2, 77}, {-6, 77}, {5, 72}, {-4, -57}, {-18, -33}, {-12, 42}, {-9, 86}, {2, 77}, {-8, 77}, {-3, 77}, {9, -42}, {16, 41}, {-29, -37}, {0, -41}, {-21, 18}, {-27, -34}, {0, 77}, {3, 74}, {-7, -69}, {-21, 18}, {27, 146}, {-20, 13}, {21, 130}, {-6, -65}, {14, -4}, {0, 3}, {9, -5}, {6, -29}, {-2, 73}, {-1, -15}, {1, 76}, {-4, 77}, {6, -29}};
    Point[] points = new Point[p.length];
    for (int i = 0; i < p.length; ++i) {
      points[i] = new Point(p[i][0], p[i][1]);
    }
    MaxPointsonaLine mpl = new MaxPointsonaLine();
    System.out.println(mpl.maxPoints(points));
  }

  public int maxPoints(Point[] points) {
    int max_points = 0;
    for (int i = 0; i < points.length; ++i) {
      Map<String, Integer> map = new HashMap<>();
      int max = 1, duplicate = 0;
      for (int j = i + 1; j < points.length; ++j) {
        if (points[i].x == points[j].x) {
          if (points[i].y == points[j].y) {
            // same node
            duplicate++;
          } else {
            // verticle
            int num = map.getOrDefault("INFINITY", 1) + 1;
            max = Math.max(max, num);
            map.put("INFINITY", num);
          }
        } else {
          // calculate slope
          int y = points[i].y - points[j].y;
          int x = points[i].x - points[j].x;
          String sign = "+";
          if (x > 0 && y < 0 || x < 0 && y > 0)
            sign = "-";
          x = Math.abs(x);
          y = Math.abs(y);
          int gcd = gcd(Math.max(x, y), Math.min(x, y));
          String slope = String.valueOf(y / gcd) + sign + String.valueOf(x / gcd);
          int num = map.getOrDefault(slope, 1) + 1;
          max = Math.max(max, num);
          map.put(slope, num);
        }
      }
      max_points = Math.max(max_points, max + duplicate);
    }
    return max_points;
  }

  private int gcd(int a, int b) {
    while (b > 0) {
      int tmp = b;
      b = a % b;
      a = tmp;
    }
    return a;
  }
}
