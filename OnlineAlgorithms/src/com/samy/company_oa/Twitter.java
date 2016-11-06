package com.samy.company_oa;

import java.util.*;

/**
 * Created by samy on 11/1/16.
 */
public class Twitter {

  abstract class Node {
    char name;
  }

  /**
   * parenthesis node
   * must has children, and children node could be
   * parenthesis node or letter node
   */
  class P_Node extends Node {
    List<Node> children;
    P_Node(char name, List<Node> children) {
      this.name = name;
      this.children = children;
    }
  }

  /**
   * letter node
   * don't have children, so letter node must be leaf node
   */
  class L_Node extends Node {
    L_Node(char name) {
      this.name = name;
    }
  }

  /**
   * transform expression to Node tree
   * @param exp
   * @return
   */
  private Node parseTree(String exp) {
    Stack<Integer> parStack = new Stack<>();
    List<Node> children = new ArrayList<>();
    for(int i=0, l=exp.length(); i<l; ++i) {
      char c = exp.charAt(i);
      if (c == ' ')
        // jump space
        continue;
      if (c == '(') {
        parStack.push(i);
      } else if (c == ')') {
        if (!parStack.isEmpty()) {
          int index = parStack.pop();
          if (!parStack.isEmpty())
            // find the matched parenthesis
            continue;
          String subexp = exp.substring(index + 1, i);
          children.add(parseTree(subexp));
        } else {
          // parenthesis not match
          // throw an exception here, maybe
        }
      } else {
        if (parStack.isEmpty()) {
          children.add(new L_Node(c));
        }
      }
    }
    return new P_Node('(', children);
  }

  /**
   * pre process operations, remove duplicated operators like
   * multiple continuous S and two continuous R
   * @param operation
   * @return
   */
  private String preprocess(String operation) {
    operation = operation.replace(" ", "");
    char[] array = operation.toCharArray();
    for(int i=1, l=array.length; i<l; ++i) {
      if(array[i] == 'S') {
        if(array[i-1] == 'S' || array[i-1] == 's')
          array[i] = 's';
      }
      if(array[i] == 'R') {
        if(array[i-1] == 'R') {
          array[i-1] = 'r';
          array[i] = 'r';
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(char c : array) {
      if(c == 'S' || c == 'R')
        sb.append(c);
    }
    return sb.toString();
  }

  /**
   * implement operations on node tree
   * @param tree
   * @param ops
   * @return
   */
  private String run(Node tree, String ops) {
    for(char c : ops.toCharArray()) {
      if(c == 'R')
        reverseTree(tree);
      if(c == 'S')
        simplifyTree(tree);
    }

    return printTree(tree);
  }

  /**
   * transform tree structure to string
   * @param tree
   * @return
   */
  private String printTree(Node tree) {
    StringBuilder sb = new StringBuilder();
    if (tree instanceof P_Node) {
      List<Node> children = ((P_Node) tree).children;
      for(Node n : children) {
        if (n instanceof L_Node)
          sb.append(n.name);
        else if (n instanceof P_Node) {
          sb.append("(" + printTree(n) + ")");
        }
      }
    }
    return sb.toString();
  }

  /**
   * reverse the whole tree
   * @param tree
   */
  private void reverseTree(Node tree) {
    if (tree instanceof L_Node)
      return;
    else if (tree instanceof P_Node) {
      List<Node> children = ((P_Node) tree).children;
      List<Node> rev_children = new ArrayList<>(children.size());
      for(int i=children.size()-1; i>=0; --i) {
        Node n = children.get(i);
        reverseTree(n);
        rev_children.add(n);
      }
      ((P_Node) tree).children = rev_children;
    }
  }

  /**
   * remove the parenthesis for the first child
   * and recursively remove parenthesis for other children
   * @param tree
   */
  private void simplifyTree(Node tree) {
    if (tree instanceof L_Node)
      return;
    P_Node p_tree = (P_Node) tree;
    List<Node> children = p_tree.children;
    List<Node> sim_children = new ArrayList<>();
    for(Node n : children) {
      simplifyTree(n);
    }
    Node child0 = children.get(0);
    if (child0 instanceof P_Node) {
      for(Node n : ((P_Node) child0).children)
        sim_children.add(n);
    } else
      sim_children.add(child0);
    for(int i=1, l=children.size(); i<l; ++i)
      sim_children.add(children.get(i));
    p_tree.children = sim_children;
  }

  /**
   * parse input string to expression and operation
   * @param line
   * @return
   */
  public String parse(String line) {
    String[] cmd = line.trim().split("/");
    if(cmd.length != 2) {
      return cmd[0];
    }
    String expression = cmd[0].trim();
    String operation = cmd[1].trim();
    Node tree = parseTree(expression);
    return run(tree, preprocess(operation));
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String line;
    Twitter t = new Twitter();
    while(in.hasNext()) {
      line = in.nextLine().trim();
      System.out.println(t.parse(line));
    }

  }
}

