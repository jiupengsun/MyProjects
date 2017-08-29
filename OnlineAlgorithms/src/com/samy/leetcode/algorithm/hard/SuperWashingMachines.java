package com.samy.leetcode.algorithm.hard;

public class SuperWashingMachines {

  /**
   * https://leetcode.com/problems/super-washing-machines/description/
   * @param machines
   * @return
   */
  public int findMinMoves(int[] machines) {
    int sum = 0, count = -1;
    for(int i: machines)
      sum += i;
    if(sum % machines.length != 0)
      return count;
    int aver = sum / machines.length;
    sum = 0;
    for(int i: machines) {
      sum += i - aver;
      count = Math.max(count, Math.max(Math.abs(sum), i-aver));
    }
    return count;
  }
}
