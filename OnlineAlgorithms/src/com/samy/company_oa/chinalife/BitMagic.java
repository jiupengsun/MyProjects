package com.samy.company_oa.chinalife;

import java.util.*;

/**
 * Created by samy on 11/5/16.
 */
public class BitMagic {

  static class Path {
    char[] current_state;
    List<char[]> prePath;

    Path(char[] sta, List<char[]> p) {
      current_state = sta;
      prePath= p;
    }
  }

  public static List<String> searchPath(String src, String dest) {
    char[] s = src.toCharArray();
    char[] d = dest.toCharArray();
    List<String> paths = new ArrayList<>();
    for(char[] c : onewayBFS(src, dest)) {
      paths.add(new String(c));
    }
    return paths;
  }

  private static List<char[]> onewayBFS(String src, String dest) {
    List<List<char[]>> paths = new ArrayList<>();
    Queue<Path> que = new LinkedList<>();
    Set<String> hasVisited = new HashSet<>();
    que.add(new Path(src.toCharArray(), new ArrayList<>()));
    while(!que.isEmpty()) {
      Path p = que.poll();
      char[] s = p.current_state;
      if (hasVisited.add(String.valueOf(s))) {
        // not visited yet
        List<char[]> pre = p.prePath;
        List<char[]> next = getNextState(s);
        for(char[]  n : next) {
          if (dest.equals(String.valueOf(n))) {
            // find a path, add it into list
            pre.add(s);
            pre.add(n);
            paths.add(pre);
          } else {
            // add into pre path list
            // and push it into queue
            List<char[]> pre_pnext = new ArrayList<>(pre);
            pre_pnext.add(s);
            Path p_next = new Path(n, pre_pnext);
            que.add(p_next);
          }
        }
      }
    }

    // search all possible paths and find the shortest one
    List<char[]> shortest = null;
    for(List<char[]> p : paths) {
      if(shortest == null || shortest.size() > p.size())
        shortest = p;
    }
    return shortest;
  }

  private static List<char[]> getNextState(char[] current) {
    int length = current.length;
    List<char[]> next = new ArrayList<>();
    for(int i=length-1; i>0; --i) {
      if(current[i-1] == 'L') {
        // previous bit is light
        // then could change this one
        char[] n = new char[length];
        for(int j=0; j<length; ++j) {
          if (j != i) {
            n[j] = current[j];
          } else {
            if (current[j] == 'L')
              n[j] = 'D';
            else
              n[j] = 'L';
          }
        }
        next.add(n);
      }
    }
    // change the first bit state
    char[] n = new char[length];
    if (current[0] == 'D')
      n[0] = 'L';
    else
      n[0] = 'D';
    for(int i=1; i<length; ++i) {
      n[i] = current[i];
    }
    next.add(n);

    return next;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Queue<String> input = new LinkedList<>();
    int testcase = Integer.parseInt(in.nextLine());
    for(int i=0; i<testcase; ++i) {
      int length = Integer.parseInt(in.nextLine());
      input.add(in.nextLine());
      input.add(in.nextLine());
    }
    for(int i=0; i<testcase; ++i) {
      List<String> path = searchPath(input.poll(), input.poll());
      System.out.println(path.size() - 1);
      for(String p : path)
        System.out.println(p);
    }
  }
}
