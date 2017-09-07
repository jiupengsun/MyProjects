package com.samy.company.Quora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StackingBoxes {

  public static int organize(int n, List<int[]> boxes) {
    // construct adjacent matrix
    boolean[][] adj = new boolean[n][n];
    for(int i=0; i<n; ++i) {
      int[] p = boxes.get(i);
      for (int j = 0; j < n; ++j) {
        if(i == j) {
          continue;
        }
        int[] q = boxes.get(j);
        if(p[0] > q[0] && p[1] > q[1])
          adj[i][j] = true;
      }
    }
    // use Hungary algorithm
    int[] prev = new int[n];
    Arrays.fill(prev, -1);
    int count = 0;
    for(int i=0; i<n; ++i) {
      boolean[] visit = new boolean[n];
      if(findArgumentPath(adj, visit, prev, i, n))
        ++count;
    }
    // count is the max matching number
    // then return
    return n - count;
  }

  /**
   * recursively find the max argument path
   * @param adj
   * @param visit
   * @param prev
   * @param p
   * @param N
   * @return
   */
  private static boolean findArgumentPath(boolean[][] adj, boolean[] visit, int[] prev, int p, int N) {
    for(int j=0; j<N; ++j) {
      if(p == j)
        continue;
      if(adj[p][j]) {
        if(!visit[j]) {
          visit[j] = true;
          if(prev[j]<0 || findArgumentPath(adj, visit, prev, prev[j], N)) {
            prev[j] = p;
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = 0;
    if(in.hasNextLine())
      N = Integer.parseInt(in.nextLine());
    List<int[]> boxes = new ArrayList<>();
    while(in.hasNextLine()) {
      String text = in.nextLine();
      if(text.equals(""))
        break;
      String[] s = text.split(" ");
      boxes.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
    }
    System.out.println(organize(N, boxes));
  }
}
