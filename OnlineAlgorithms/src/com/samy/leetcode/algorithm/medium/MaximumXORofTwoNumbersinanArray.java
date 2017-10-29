package com.samy.leetcode.algorithm.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray {
  /**
   * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
   * @param nums
   * @return
   */
  public int findMaximumXOR(int[] nums) {
    int max = 0, mask = 0;
    for(int i = 31; i >= 0; i--){
      mask = mask | (1 << i);
      Set<Integer> set = new HashSet<>();
      for(int num : nums){
        set.add(num & mask);
      }
      int tmp = max | (1 << i);
      for(int prefix : set){
        if(set.contains(tmp ^ prefix)) {
          max = tmp;
          break;
        }
      }
    }
    return max;
  }

  /**
   * use Trie tree
   * @param nums
   * @return
   */
  public int findMaximumXOR2(int[] nums) {
    Trie root = new Trie();
    for(int n: nums) {
      Trie tmp = root;
      for(int i=31; i>=0; --i) {
        int b = (n >> i) & 1;
        if(tmp.child[b] == null) {
          tmp.child[b] = new Trie();
        }
        tmp = tmp.child[b];
      }
    }

    // traverse each number, try to find a max match
    // a match is a number that XOR current number and larger
    // than current max
    int max = Integer.MIN_VALUE;
    int pos_max = 0;
    for(int n: nums) {
      Trie tmp = root;
      int current = 0;
      for(int i=31; i>=0; --i) {
        int b = (n >> i) & 1;
        if(pos_max == 0 && b == 1) {
          if(pos_max > i)
            break;
          pos_max = i;
        }
        if(tmp.child[b ^ 1] != null) {
          current += 1 << i;
          tmp = tmp.child[b ^ 1];
        } else{
          tmp = tmp.child[b];
        }
      }
      if(current > max)
        max = current;
    }
    return max;
  }

  class Trie {
    Trie[] child;
    Trie() {
      child = new Trie[2];
    }
  }

  public static void main(String[] args) {
    MaximumXORofTwoNumbersinanArray m = new MaximumXORofTwoNumbersinanArray();
    m.findMaximumXOR(new int[]{3,10,5,25,2,8});
  }
}
