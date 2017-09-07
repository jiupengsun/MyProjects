package com.samy.company.Amazon;

public class ArrangeArray {

  public void arrange(int[] nums) {
    /**
     * two pointer, i j
     * flag true means current ith element is positive, otherwise negative
     * if(positive)
     *  move j to the first negative number, then swap(i, j)
     * else
     *  move j to the first positive number, then swap(i, j)
     * positive = !positive
     */
    int i=0, j=0;
    boolean flag = nums[0] > 0;
    while(j < nums.length) {
      if(i <= j && (flag && nums[i] < 0 || !flag && nums[i] > 0)) {
        if(flag)
          while(j < nums.length && nums[j] < 0)
            ++j;
        else
          while(j < nums.length && nums[j] > 0)
            ++j;
        if(j < nums.length) {
          swap(nums, i++, j);
        }
      } else {
        ++i;
        j = Math.max(i, j);
      }
      flag = !flag;
    }
  }

  public ListNode reverseKNode(ListNode head, int k) {
    /**
     * use a fakehead
     * find start and end
     * then reverse(start, end)
     * prev.next = end, start.next=original end.next
     */
    if(k <= 1)
      return head;
    ListNode fakeHead = new ListNode(0);
    fakeHead.next = head;
    ListNode prev = fakeHead, start=head, tmp=head;
    int count = k - 1;
    while(tmp != null) {
      if(count == 0) {
        ListNode next = tmp.next;
        reverse(start, tmp);
        prev.next = tmp;
        start.next = next;
        prev = start;
        tmp = next;
        start = next;
        count = k-1;
      } else {
        tmp = tmp.next;
        --count;
      }
    }
    return fakeHead.next;
  }

  private void reverse(ListNode head, ListNode tail) {
    if(head == tail)
      return;
    ListNode prev=head, next=head.next;
    while(next != tail.next) {
      ListNode tmp = next.next;
      next.next = prev;
      prev = next;
      next = tmp;
    }
  }

  private void swap(int[] nums, int i, int j) {
    if(i != j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

  public static void main(String[] args) {
    ArrangeArray aa = new ArrangeArray();
    int[] nums = new int[] {1,2,3,-1,-2,-3};
    aa.arrange(nums);
    for(int i: nums)
      System.out.println(i);
  }
}
