package com.samy.leetcode.algorithm.medium;

public class SolvetheEquation {

  /**
   * https://leetcode.com/problems/solve-the-equation/description/
   * @param equation
   * @return
   */
  public String solveEquation(String equation) {
    int coefficient=0, constant=0;
    int i=0, j=0, l=equation.length();
    int leftEquation=0, positive=0;
    while(j <= l) {
      char c = 0;
      if(j < l)
        c = equation.charAt(j);
      if(j==l || c=='+' || c=='-' || c=='=') {
        if(j > i) {
          String term = equation.substring(i, j);
          if(equation.charAt(j-1) == 'x') {
            int tmp = i==j-1 ? 1 : Integer.parseInt(term.substring(i, j-i-1));
            coefficient += positive==leftEquation ? tmp : -tmp;
          } else {
            int tmp = Integer.parseInt(term);
            constant += positive!=leftEquation ? tmp : -tmp;
          }
        }
        if(c == '=') {
          positive = 0;
          leftEquation = 1;
        } else
          positive = c=='+' ? 0 : 1;
        i = j + 1;
      }
      ++j;
    }
    if(coefficient == 0)
      return constant == 0 ? "Infinite solutions" : "No solution";
    return "x=" + (constant / coefficient);
  }
}
