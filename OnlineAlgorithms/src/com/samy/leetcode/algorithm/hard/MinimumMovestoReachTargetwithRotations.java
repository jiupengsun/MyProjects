package com.samy.leetcode.algorithm.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


/**
 * <a href="https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/">Minimum Moves to Reach Target with Rotations</a>
 */
public class MinimumMovestoReachTargetwithRotations {

  static class Pair<F, S> {
    F fst;
    S snd;

    Pair(F fst, S snd) {
      this.fst = fst;
      this.snd = snd;
    }
  }

  static class Position {
    Pair<Integer, Integer> _head;
    Pair<Integer, Integer> _tail;

    Position(Pair<Integer, Integer> head, Pair<Integer, Integer> tail) {
      _head = head;
      _tail = tail;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Position)) {
        return false;
      }
      Position other = (Position) obj;
      return this._head.fst.equals(other._head.fst)
          && this._head.snd.equals(other._head.snd)
          && this._tail.fst.equals(other._tail.fst)
          && this._tail.snd.equals(other._tail.snd);
    }

    @Override
    public int hashCode() {
      return Objects.hash(_head.fst, _head.snd, _tail.fst, _tail.snd);
    }
  }

  public int minimumMoves(int[][] grid) {
    int size = grid.length - 1;
    Pair<Position, Integer> start = new Pair<>(new Position(new Pair<>(0, 1), new Pair<>(0, 0)), 0);
    Position dst = new Position(new Pair<>(size, size), new Pair<>(size, size-1));
    Queue<Pair<Position, Integer>> que = new LinkedList<>();
    Set<Position> visited = new HashSet<>();
    que.add(start);
    while(!que.isEmpty()) {
      Pair<Position, Integer> next = que.poll();
      if (next.fst.equals(dst)) {
        // reach!
        return next.snd;
      }
      if (!visited.add(next.fst)) {
        // already visit
        continue;
      }
      // check direction
      checkNextAvailable(grid, next.fst, next.snd, que);
    }
    return -1;
  }

  private void checkNextAvailable(int[][] grid, Position cur, Integer step, Queue<Pair<Position, Integer>> que) {
    // check the moving direction
    // next head position = current head position * 2 - current tail position
    // and current head will be next position's tail
    Pair<Integer, Integer> nextHead = new Pair<>((cur._head.fst<<1) - cur._tail.fst, (cur._head.snd<<1) - cur._tail.snd);
    if (checkAvailable(nextHead.fst, nextHead.snd, grid)) {
      // available
      que.add(new Pair<>(new Position(nextHead, cur._head), step+1));
    }
    if (cur._head.fst.equals(cur._tail.fst)) {
      // snake is in horizontal position, check clockwise
      if (checkAvailable(cur._head.fst + 1, cur._head.snd, grid)
          && checkAvailable(cur._tail.fst + 1, cur._tail.snd, grid)) {
        que.add(new Pair<>(new Position(new Pair<>(cur._head.fst+1, cur._tail.snd), cur._tail), step+1));
        que.add(new Pair<>(new Position(new Pair<>(cur._head.fst+1, cur._head.snd), new Pair<>(cur._tail.fst+1, cur._tail.snd)), step+1));
      }
    } else {
      // snake is in vertical position, check counterclockwise
      if (checkAvailable(cur._head.fst, cur._head.snd+1, grid)
          && checkAvailable(cur._tail.fst, cur._tail.snd+1, grid)) {
        que.add(new Pair<>(new Position(new Pair<>(cur._tail.fst, cur._tail.snd+1), cur._tail), step+1));
        que.add(new Pair<>(new Position(new Pair<>(cur._head.fst, cur._head.snd+1), new Pair<>(cur._tail.fst, cur._tail.snd+1)), step+1));
      }
    }
  }

  private boolean checkAvailable(int row, int col, int[][] grid) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 0;
  }

  public static void main(String[] args) {
    MinimumMovestoReachTargetwithRotations m = new MinimumMovestoReachTargetwithRotations();
    int[][] grid = new int[][]{
/*        {0,0,0,0,0,1},
        {1,1,0,0,1,0},
        {0,0,0,0,1,1},
        {0,0,1,0,1,0},
        {0,1,1,0,0,0},
        {0,1,1,0,0,0}*/
        {0,0,1,1,1,1},
        {0,0,0,0,1,1},
        {1,1,0,0,0,1},
        {1,1,1,0,0,1},
        {1,1,1,0,0,1},
        {1,1,1,0,0,0}
    };
    System.out.println(m.minimumMoves(grid));
  }
}
