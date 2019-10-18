package com.samy.company.Uber;

import com.samy.datastructure.ListNode;

public class InsertintoaCyclicSortedList {

  /**
   * http://articles.leetcode.com/insert-into-a-cyclic-sorted-list/
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode insert(ListNode head, ListNode n) {
    if (head == null) {
      n.next = n;
      return n;
    }

    ListNode cur = head, next = head.next;
    do {
      if (cur.val <= n.val && n.val <= next.val) break;
      if (next.val < cur.val && (n.val > cur.val || n.val < next.val)) break;
      cur = cur.next;
      next = next.next;
    } while (cur != head);
    cur.next = n;
    n.next = next;
    return head;
  }
}
