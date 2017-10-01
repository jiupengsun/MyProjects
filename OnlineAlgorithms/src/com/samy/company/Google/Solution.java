package com.samy.company.Google;

// you can also use imports, for example:
// import java.util.*;
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

  public int[] duplicateMax(int[] nums) {
    if(nums.length == 0)
      return nums;
    int[] dup = new int[nums.length + 1];
    int i = 0;
    for(; i<nums.length-1; ++i) {
      if(nums[i] <= nums[i+1]) {
        dup[i] = nums[i];
        continue;
      }
      break;
    }
    // i is larger, then duplicate i
    dup[i] = nums[i];
    while(i < nums.length) {
      dup[i+1] = nums[i];
      ++i;
    }
    return dup;
  }

  public String nextTime(String S) {
    //23:59, next is 22:22
    // get digit
    Set<Integer> set = new HashSet<>();
    for(char c: S.toCharArray()) {
      if(c == ':')
        continue;
      set.add(c - '0');
    }
    List<Integer> list = new ArrayList<>(set);
    int max_minutes = 24 * 60;
    int current = Integer.parseInt(S.substring(0, 2)) * 24 + Integer.parseInt(S.substring(3, 5));
    int nearest = Integer.MAX_VALUE;
    String nextTime = S;
    int[] time = new int[4];

    Deque<int[]> stack = new LinkedList<>();
    int[] p = new int[]{0, 0};
    while(p!=null || !stack.isEmpty()) {
      // p0 is index of time
      // p1 is index of list
      if(p == null)
        p = stack.pop();
      if(p[0] == 4) {
        int minutes = getMinutes(time);
        if(minutes < 0) {
          // illegal
          p = null;
          continue;
        }
        minutes -= current;
        if(minutes <= 0)
          minutes += max_minutes;
        if(minutes < nearest) {
          nearest = minutes;
          StringBuilder sb = new StringBuilder();
          sb.append(time[0]).append(time[1]).append(":").append(time[2]).append(time[3]);
          nextTime = sb.toString();
        }
        p = null;
        continue;
      }
      if(p[1] == list.size()) {
        p = null;
        continue;
      }
      time[p[0]] = list.get(p[1]++);
      stack.push(new int[]{p[0], p[1]});
      p[0]++;
      p[1] = 0;
    }
    return nextTime;
  }

  private int getMinutes(int[] time) {
    int hour = time[0] * 10 + time[1];
    if(hour>23)
      return -1;
    int minutes = time[2] * 10 + time[3];
    if(minutes > 59)
      return -1;
    return hour * 24 + minutes;
  }

  public int flower(int[] P, int k) {
    TreeSet<Integer> set = new TreeSet<>();
    for(int i: P) {
      Integer h = set.higher(P[i]);
      if(h == null)
        h = P.length;
      if(h - P[i] == k)
        return i;
      Integer l = set.lower(P[i]);
      if(l == null)
        l = 1;
      if(P[i] - l == k)
        return i;
      set.add(P[i]);
    }
    return -1;
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    //StringBuilder res = new StringBuilder("");
    String res = "";
    for(int i=0; i<100000; ++i) {
      //res.append("1");
      res += "1";
    }
    //System.out.println(res.toString().length());
    System.out.println(res.length());
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}
