package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class CutOffTreesforGolfEvent {

  /**
   * https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
   * @param forest
   * @return
   */
  // four directions
  private final int[][] direc = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public int cutOffTree(List<List<Integer>> forest) {
    int row=forest.size();
    if(row == 0)
      return 0;
    int col = forest.get(0).size();
    int[][] trees = new int[row][col];
    PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>(){
      @Override
      public int compare(int[] p1, int[] p2) {
        return trees[p1[0]][p1[1]] - trees[p2[0]][p2[1]];
      }
    });
    // count the number of obstacles
    int zeros = 0;
    for(int i=0; i<row; ++i) {
      List<Integer> l = forest.get(i);
      for(int j=0; j<col; ++j) {
        int height = l.get(j);
        trees[i][j] = height;
        if(height > 1) {
          // put all trees in heap
          que.add(new int[]{i, j});
        } else if(height == 0)
          zeros++;
      }
    }
    // check if could go to all the places
    if(!check(trees, zeros))
      return -1;
    // cut tree one by one, count steps by bfs
    int count = 0;
    int i=0, j=0;
    while(!que.isEmpty()) {
      int[] p = que.poll();
      count += bfs(trees, i, j, p[0], p[1]);
      i = p[0];
      j = p[1];
    }
    return count;
  }

  /**
   * count if could traverse all places
   * use dfs
   * @param trees
   * @param zeros
   * @return
   */
  private boolean check(int[][] trees, int zeros) {
    Deque<int[]> stack = new LinkedList<>();
    boolean[][] visit = new boolean[trees.length][trees[0].length];
    stack.push(new int[]{0, 0});
    int count = 0;
    while(!stack.isEmpty()) {
      int[] p = stack.pop();
      // Notice DFS and BFS may
      // add same node in the stack/queue
      if(visit[p[0]][p[1]])
        continue;
      visit[p[0]][p[1]] = true;
      count++;
      for(int[] d: direc) {
        int i = Math.max(0, Math.min(p[0]+d[0], trees.length-1));
        int j = Math.max(0, Math.min(p[1]+d[1], trees[0].length-1));
        if(!visit[i][j] && trees[i][j]>0) {
          stack.push(new int[]{i, j});
        }
      }
    }
    return count == trees.length * trees[0].length - zeros;
  }

  /**
   * count the distance by using bfs
   * @param trees
   * @param i
   * @param j
   * @param p0
   * @param p1
   * @return
   */
  private int bfs(int[][] trees, int i, int j, int p0, int p1) {
    boolean[][] visit = new boolean[trees.length][trees[0].length];
    Queue<int[]> que = new LinkedList<>();
    // i, j, distance
    que.add(new int[]{i, j, 0});
    while(!que.isEmpty()) {
      int[] p = que.poll();
      if(p[0]==p0 && p[1]==p1)
        return p[2];
      if(visit[p[0]][p[1]])
        continue;
      visit[p[0]][p[1]] = true;
      for(int[] d: direc) {
        i = Math.max(0, Math.min(p[0]+d[0], trees.length-1));
        j = Math.max(0, Math.min(p[1]+d[1], trees[0].length-1));
        if(!visit[i][j] && trees[i][j]>0) {
          que.add(new int[]{i, j, p[2]+1});
        }
      }
    }
    return -1;
  }
}
