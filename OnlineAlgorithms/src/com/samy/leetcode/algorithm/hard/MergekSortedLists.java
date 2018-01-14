package com.samy.leetcode.algorithm.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
  /**
   * https://leetcode.com/problems/merge-k-sorted-lists/
   * @param lists
   * @return
   * Suppose there are N lists in the array, and each list has M node respectively
   * Then the time complexity of building heap is N*logN, and after insertion of each
   * node, the adjust time is logN. Thus the total time complexity is:
   * N*logN + (M-N)*logN = M*logN
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists==null || lists.length==0)
      return null;
    ListNode fakeHead = new ListNode(0);
    // lambda has very low efficiency
    PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(Comparator.comparingInt(n1 -> n1.val));
    for(ListNode n : lists) {
      if(n != null)
        que.add(n);
    }
    ListNode pointer = fakeHead;
    while(!que.isEmpty()) {
      ListNode tmp = que.poll();
      pointer.next = tmp;
      pointer = pointer.next;
      if(tmp.next != null) {
        tmp = tmp.next;
        que.add(tmp);
      }
    }
    return fakeHead.next;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
