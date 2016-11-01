package com.samy.company_oa;

import java.util.*;

/**
 * Created by samy on 10/30/16.
 */
public class Qumulo {

  public static void winner(int N, int M) {
    if (N < M)
      return;
    int[] array = new int[(N >> 1) + 1];
    for(int i=1, j=0; i<N; ++i) {
      if(i % M == 0)
        continue;
      array[j++] = i;
    }
  }

  public static void main(String[] args) {
/*    Scanner in = new Scanner(System.in);
    int N = Integer.parseInt(in.nextLine());
    int M = Integer.parseInt(in.nextLine());
    winner(N, M);*/
    winner(5, 3);

  }
}

class Graph{

  private static Map<String, List<String>> graph;
  private static Set<String> vectors;

  static Scanner in;

  private static boolean hasCircle(String node, Set<String> hasVisited) {
    hasVisited.add(node);
    List<String> subGraph = graph.get(node);
    if(subGraph == null)
      return false;
    for(String v : subGraph) {
      if(hasVisited.contains(v) || hasCircle(v, hasVisited))
        return true;
    }
    return false;
  }

  private static boolean isTree() {
    Iterator<String> it = graph.keySet().iterator();
    while(it.hasNext()) {
      String v = it.next();
      Set<String> hasVisited = new HashSet<>();
      if(hasCircle(v, hasVisited))
        return false;
      if(hasVisited.size() == vectors.size())
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    in = new Scanner(System.in);
    graph = new HashMap<>();
    vectors = new HashSet<>();
    String line;
    while( in.hasNext() && (line = in.nextLine()) != null && !line.equals("")) {
      String[] g = line.split(" ");
      List<String> edge = graph.get(g[0]);
      if (edge == null)
        edge = new ArrayList<>();
      edge.add(g[1]);
      graph.put(g[0], edge);
      vectors.add(g[0]);
      vectors.add(g[1]);
    }
    System.out.println(isTree());
  }

}

class RPN{

  private static Stack<Integer> stack;

  public static void main(String[] args) {
    stack = new Stack<>();
    Scanner in = new Scanner(System.in);
    String line;
    while(in.hasNext()) {
      line = in.nextLine().trim();
      if(!in.equals("")) {
        String[] seq = line.split(" ");
        int left, right;
        for(String s : seq) {
          switch(s) {
            case "+":
              right = stack.pop();
              left = stack.pop();
              stack.push(left + right);
              break;
            case "-":
              right = stack.pop();
              left = stack.pop();
              stack.push(left - right);
              break;
            case "*":
              right = stack.pop();
              left = stack.pop();
              stack.push(left * right);
              break;
            case "/":
              right = stack.pop();
              left = stack.pop();
              stack.push(left / right);
              break;
            default:
              stack.push(Integer.parseInt(s));
          }
        }
      }
    }
    System.out.println(stack.pop());
  }
}

