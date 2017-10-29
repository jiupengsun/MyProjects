package com.samy.leetcode.algorithm.medium;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSumQuery2DImmutable {}

class NumMatrix {

  int[][] sumMatrix;

  public NumMatrix(int[][] matrix) {
    sumMatrix = new int[matrix.length+1][matrix[0].length+1];
    for(int i=1; i<sumMatrix.length; ++i) {
      for(int j=1; j<sumMatrix[0].length; ++j) {
        sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i-1][j-1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumMatrix[row2+1][col2+1] + sumMatrix[row1+1][col1+1]
             - sumMatrix[row2+1][col1+1] - sumMatrix[row1+1][col2+1];
  }


}
