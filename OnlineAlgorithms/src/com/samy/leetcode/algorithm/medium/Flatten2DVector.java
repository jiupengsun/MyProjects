package com.samy.leetcode.algorithm.medium;

import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-2d-vector/description/
 */
public class Flatten2DVector {
}

class Vector2D implements Iterator<Integer> {
  Iterator<List<Integer>> iter;
  Iterator<Integer> subIter;

  public Vector2D(List<List<Integer>> vec2d) {
    iter = vec2d.iterator();
  }

  @Override
  public Integer next() {
    return subIter.next();
  }

  @Override
  public boolean hasNext() {
    while (subIter == null || !subIter.hasNext()) {
      if (iter == null || !iter.hasNext())
        return false;
      subIter = iter.next().iterator();
    }
    return true;
  }

}
