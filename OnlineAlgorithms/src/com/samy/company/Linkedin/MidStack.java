package com.samy.company.Linkedin;

/**
 * http://www.1point3acres.com/bbs/thread-198263-1-1.html
 * design a stack that return the middle of index
 * e.g. 1,2,3,4,5 return 3
 * e.g. 1,2,3,4,5,6 return 3
 */
public class MidStack {
  private int length;
  private int leftLength;
  private Node head, tail, middle;

  public void push(int v) {
    Node n = new Node(v);
    if (head == null) {
      head = n;
      tail = n;
      middle = n;
      length = 1;
    } else {
      tail.next = n;
      tail = n;
      ++length;
      if (((leftLength + 1) << 1) < length) {
        // move middle
        leftLength++;
        middle = middle.next;
      }
    }
  }

  public int peek() {
    return tail.val;
  }

  public int pop() {
    int v = tail.val;
    if (((leftLength + 1) << 1) > length) {
      leftLength--;
      middle = middle.prev;
    }
    --length;
    tail = tail.prev;
    if (head.next == null)
      head = null;
    return v;
  }

  public int popMiddle() {
    Node n = middle;
    leftLength--;
    length--;
    middle = middle.prev;
    if (n.prev != null)
      n.prev.next = n.next;
    else
      head = head.next;
    if (n.next != null)
      n.next.prev = n.prev;
    else
      tail = tail.prev;
    return n.val;
  }

  public int peekMiddle() {
    return middle.val;
  }

  class Node {
    int val;
    Node prev, next;

    Node(int v) {
      val = v;
    }
  }
}
