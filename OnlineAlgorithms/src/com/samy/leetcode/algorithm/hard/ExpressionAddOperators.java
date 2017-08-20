package com.samy.leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators {

  /**
   * https://leetcode.com/problems/expression-add-operators/description/
   * @param num
   * @param target
   * @return
   */
  public List<String> addOperators(String num, int target) {
    List<String> list = new ArrayList<>();
    if(num==null || num.equals(""))
      return list;
    char[] operator = new char[(num.length()<<1)-1];
    for(int i=0, j=0; i<operator.length; i+=2, ++j) {
      operator[i] = num.charAt(j);
    }
    //
    backtracking(operator, operator.length-1, list, target, operator[operator.length-1]-'0');
    return list;
  }

  private void backtracking(char[] op, int pos, List<String> list, int target, int current) {
    if(pos==0) {
      if(current == target) {
        // find one
        list.add(new String(op));
      }
      return;
    }
    // add
    op[pos-1] = '+';
    backtracking(op, pos-2, list, target-current, op[pos-2]-'0');
    // minus
    op[pos-1] = '-';
    backtracking(op, pos-2, list, target+current, op[pos-2]-'0');
    // mul
    op[pos-1] = '*';
    current *= op[pos-2];
    backtracking(op, pos-2, list, target, current);
  }

  public static void main(String[] args) {
    System.out.println(Integer.parseInt("234234234"));
  }
}
