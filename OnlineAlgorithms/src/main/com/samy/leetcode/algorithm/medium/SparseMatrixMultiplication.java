package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {

  /**
   * https://leetcode.com/problems/sparse-matrix-multiplication/description/
   *
   * @param A
   * @param B
   * @return
   */
  public int[][] multiply(int[][] A, int[][] B) {
    Map<Integer, Map<Integer, Integer>> row = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> col = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      for (int j = 0; j < A[0].length; ++j) {
        if (A[i][j] != 0) {
          Map<Integer, Integer> map = row.getOrDefault(i, new HashMap<>());
          map.put(j, A[i][j]);
          row.put(i, map);
        }
      }
    }
    for (int i = 0; i < B.length; ++i) {
      for (int j = 0; j < B[0].length; ++j) {
        if (B[i][j] != 0) {
          Map<Integer, Integer> map = col.getOrDefault(j, new HashMap<>());
          map.put(i, B[i][j]);
          col.put(j, map);
        }
      }
    }
    // multiply
    int[][] C = new int[A.length][B[0].length];
    for (int i = 0; i < A.length; ++i) {
      for (int j = 0; j < B[0].length; ++j) {
        Map<Integer, Integer> rMap = row.get(i);
        if (rMap != null) {
          Map<Integer, Integer> cMap = col.get(j);
          if (cMap != null) {
            int sum = 0;
            for (int k : rMap.keySet()) {
              int tmp = cMap.getOrDefault(k, 0);
              sum += tmp * rMap.get(k);
            }
            C[i][j] = sum;
          }
        }
      }
    }
    return C;
  }

  /**
   * a more efficient way, utilize locality
   *
   * @param A
   * @param B
   * @return
   */
  public int[][] multiply2(int[][] A, int[][] B) {
    int m = A.length, n = A[0].length, p = B[0].length;
    int[][] C = new int[m][p];
    for (int i = 0; i < m; ++i) {
      for (int k = 0; k < n; ++k) {
        if (A[i][k] != 0) {
          for (int j = 0; j < p; ++j) {
            if (B[k][j] != 0)
              C[i][j] += A[i][k] * B[k][j];
          }
        }
      }
    }
    return C;
  }
}
