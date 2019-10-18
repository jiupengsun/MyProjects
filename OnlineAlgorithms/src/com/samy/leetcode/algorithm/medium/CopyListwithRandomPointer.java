package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
  /**
   * https://leetcode.com/problems/copy-list-with-random-pointer/description/
   *
   * @param head
   * @return
   */
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null)
      return null;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode chead = new RandomListNode(head.label);
    chead.random = head.random;
    RandomListNode tmp = head, ctmp = chead;
    map.put(tmp, ctmp);
    while (tmp.next != null) {
      RandomListNode r = new RandomListNode(tmp.next.label);
      r.random = tmp.next.random;
      map.put(tmp.next, r);
      ctmp.next = r;
      ctmp = r;
      tmp = tmp.next;
    }
    ctmp = chead;
    while (ctmp != null) {
      ctmp.random = map.get(ctmp.random);
      ctmp = ctmp.next;
    }
    return chead;
  }

  /**
   * @param head
   * @return I use a trick that I insert the copy node right after the original node
   * for example, if you have a node 1, then after I copy it, I will get a list of 1-1'
   * and the copy node will point the origin node in its random field.
   * Then in second traverse, I will correct the random pointer to the copy node by
   * move the pointer to its next neighbor.
   * In the last step, I split the list to two lists.
   */
  public RandomListNode copyRandomList2(RandomListNode head) {
    if (head == null)
      return null;
    RandomListNode tmp = head;
    while (tmp != null) {
      RandomListNode copy = new RandomListNode(tmp.label);
      copy.next = tmp.next;
      copy.random = tmp.random;
      tmp.next = copy;
      tmp = copy.next;
    }
    tmp = head.next;
    while (tmp != null) {
      if (tmp.random != null)
        tmp.random = tmp.random.next;
      if (tmp.next != null)
        tmp = tmp.next.next;
      else
        break;
    }
    // split
    tmp = head;
    RandomListNode chead = tmp.next, ctmp = chead;
    while (ctmp.next != null) {
      tmp.next = ctmp.next;
      ctmp.next = ctmp.next.next;
      tmp = tmp.next;
      ctmp = ctmp.next;
    }
    tmp.next = null;
    return chead;
  }
}

class RandomListNode {
  int label;
  RandomListNode next, random;

  RandomListNode(int x) {
    this.label = x;
  }
};
