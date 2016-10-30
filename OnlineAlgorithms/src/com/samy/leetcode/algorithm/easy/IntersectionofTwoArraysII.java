package com.samy.leetcode.algorithm.easy;

import java.util.*;

/**
 * Created by samy on 10/1/16.
 */
public class IntersectionofTwoArraysII {

  /**
   * https://leetcode.com/problems/intersection-of-two-arrays-ii/
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums1) {
      if (map.containsKey(i))
        map.put(i, map.get(i) + 1);
      else
        map.put(i ,1);
    }

    List<Integer> list = new ArrayList<>();
    for (int i : nums2) {
      if (map.containsKey(i)) {
        list.add(i);
        int count = map.get(i);
        if (count == 1)
          map.remove(i);
        else
          map.put(i, --count);
      }
    }

    int[] sects = new int[list.size()];
    int i = 0;
    for (Integer I : list)
      sects[i++] = I;
    return sects;
  }

  /**
   * If both of nums1 and nums2 are sorted
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] interSectSort(int[] nums1, int[] nums2) {
    int l1=nums1.length, l2=nums2.length;
    int[] sects = new int[Math.max(l1, l2)];
    int i=0, j=0, k=0;
    for (; i<l1 && j<l2;) {
      if (nums1[i] == nums2[j]) {
        sects[k++] = nums1[i];
        ++i;
        ++j;
      } else if (nums1[i] > nums2[j])
        ++j;
      else
        ++i;
    }
    return Arrays.copyOf(sects, k);
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41};
    int[] nums2 = new int[]{17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
    IntersectionofTwoArraysII in = new IntersectionofTwoArraysII();
    int[] sects = in.intersect(nums1, nums2);
    for (int i : sects)
      System.out.print(i + " ");

  }
}
