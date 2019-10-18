package com.samy.company.Quora;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class FindMentors {

  /**
   * sort the list by L in ascending order
   * use TreeMap to record how many employess'W are larger
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = 0;
    if (in.hasNext()) {
      N = Integer.parseInt(in.nextLine());
    }

    Node[] emp = new Node[N];
    int[] mentors = new int[N];
    int i = 0;
    while (i < N) {
      String[] s = in.nextLine().split(" ");
      emp[i] = new Node(i++, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
    }
    Arrays.sort(emp, new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        int dl = o1.L - o2.L;
        return dl != 0 ? dl : o1.W - o2.W;
      }
    });
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (i = N - 1; i >= 0; --i) {
      mentors[emp[i].id] = map.tailMap(emp[i].W, false).size();
      map.put(emp[i].W, map.getOrDefault(emp[i].W, 0) + 1);
    }
    for (int n : mentors) {
      System.out.print(n);
    }
    System.out.println();
  }

  static class Node {

    int id;
    int L;
    int W;

    Node(int i, int l, int w) {
      id = i;
      L = l;
      W = w;
    }
  }
}
