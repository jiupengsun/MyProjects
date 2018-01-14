package com.samy.company.Linkedin;

import com.samy.datastructure.FourDirectionList;
import com.samy.datastructure.TwoDirectionList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public FourDirectionList fourToOne(FourDirectionList head) {
    FourDirectionList tail=null, tmp=head;
    while(tmp.right != null)
      tmp = tmp.right;
    tail = tmp;
    FourDirectionList tmpHead = head;
    while(tmpHead != tail) {
      if(tmpHead.left != null) {
        tail.right = tmpHead.left;
        tmpHead.left = null;
        while(tail.right != null)
          tail = tail.right;
      }
      if(tmpHead.up != null) {
        tail.right = tmpHead.up;
        tmpHead.up = null;
        while(tail.right != null)
          tail = tail.right;
      }
      if(tmpHead.down != null) {
        tail.right = tmpHead.down;
        tmpHead.down = null;
        while(tail.right != null)
          tail = tail.right;
      }
      tmpHead = tmpHead.right;
    }
    return head;
  }

  /**
   * http://blog.csdn.net/craiglin1992/article/details/44917459
   * @param head
   * @return
   */
  public TwoDirectionList twoToOne(TwoDirectionList head) {
    TwoDirectionList tail = null, tmp = head;
    while(tmp.next != null)
      tmp = tmp.next;
    tail = tmp;
    TwoDirectionList tmpHead = head;
    while(tmpHead != tail) {
      if(tmpHead.child != null) {
        // append children to the end of tail
        tail.next = tmpHead.child;
        tmpHead.child = null;
        // move to new tail
        while(tail.next != null)
          tail = tail.next;
      }
      tmpHead = tmpHead.next;
    }
    return head;
  }

  class Record {
    int[] arr;
    int pointer;
    Record(int[] a, int p) {
      arr = a;
      pointer = p;
    }
  }

  public int findMiddleFromSortedArrays(int[][] arrays) {
    int sum = 0;
    PriorityQueue<Record> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.arr[o.pointer]));
    for(int[] a: arrays) {
      sum += a.length;
      if(a.length > 0)
        pq.add(new Record(a, 0));
    }
    int middle = sum >> 1;
    int i = 0;
    while(i < middle - 1) {
      Record r = pq.poll();
      if(r.pointer < r.arr.length) {
        r.pointer++;
        pq.add(r);
      }
      ++i;
    }
    Record r = pq.peek();
    return r.arr[r.pointer];
  }
}
