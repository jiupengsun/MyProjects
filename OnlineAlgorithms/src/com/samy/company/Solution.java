package com.samy.company;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int solution(int[] A) {
    int length = A.length;
    if (length < 2)
      return 0;
    int left_max = Integer.MIN_VALUE;
    int right_min = Integer.MAX_VALUE;
    int left=0, right=length-1;
    for(int i=0; i<length; ++i) {
      if (left_max > A[i])
        left = Math.max(left, i);
      left_max = Math.max(left_max, A[i]);
    }
    for(int i=length-1; i>=0; --i) {
      if (right_min < A[i])
        right = Math.min(right, i);
      right_min = Math.min(right_min, A[i]);
    }
    return right - left + 1;
  }

/*  public int solution(int[] A) {
    int length = A.length;
    if (length < 2)
      return 0;
    int i=0, j=0, start=0;
    while(i < length -1) {
      if(A[i] < A[i+1]) {
        ++i;
        ++start;
        continue;
      } else if (A[i] == A[i+1]) {
        ++i;
        continue;
      }
      // find a reverse-order pair
      j = length - 1;
      while(j > i && A[j] >= A[i])
        --j;
      break;
    }
    return j - Math.min(i, start) + 1;
  }*/

/*  public int solution(int[] A) {
    // write your code in Java SE 8
    List<Integer[]> pairList = new ArrayList<>();
    int length = A.length;
    if (length < 2)
      return 0;
    int i=0, j=0;
    while(i < length -1) {
      if(A[i] < A[i+1]) {
        ++i;
        continue;
      }
      // find a reverse-order pair
      int j = i+1;
      while(j<length && A[j] < A[i])
        ++j;
      Integer[] pair = new Integer[]{i, j};
      pairList.add(pair);
      i = j;
    }

  }*/
}

class Solution1 {

  public String solution(int A, int B, int C, int D) {
    // write your code in Java SE 8
    int[][] transform = getTime(A, B, C, D);
    int max_hour=-1, max_min=-1;
    for(int i=0, row=transform.length; i<row; ++i) {
      if(transform[i][0] > 23 || transform[i][1] > 59)
        continue;
      if(transform[i][0] > max_hour) {
        max_hour = transform[i][0];
        max_min = transform[i][1];
      } else if (transform[i][0] == max_hour && transform[i][1] > max_min) {
        max_min = transform[i][1];
      }
    }
    if(max_hour == -1)
      return "NOT POSSIBLE";
    StringBuilder sb = new StringBuilder("");
    if(max_hour < 10)
      sb.append("0");
    sb.append(max_hour + ":");
    if(max_min < 10)
      sb.append("0");
    sb.append(max_min);
    return sb.toString();
  }

  private int[][] getTime(int A, int B, int C, int D) {
    int[] time = new int[]{A, B, C, D};
    List<List<Integer>> list = new ArrayList<>();
    backTracking(time, 0, 4, list);
    int[][] transform = new int[list.size()][2];
    int i = 0;
    for(List<Integer> l : list) {
      int hour = l.get(0) * 10 + l.get(1);
      int minute = l.get(2) * 10 + l.get(3);
      transform[i][0] = hour;
      transform[i][1] = minute;
      ++i;
    }
    return transform;

  }

  private void backTracking(int[] array, int index, int length, List<List<Integer>> list) {
    if(index == length - 1) {
      List<Integer> l = new ArrayList<Integer>();
      for(int i : array)
        l.add(i);
      list.add(l);
      return;
    }
    for(int i=index; i<length; ++i) {
      swap(array, i, index);
      backTracking(array, index+1, length, list);
      swap(array, index, i);
    }
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;

  }
}