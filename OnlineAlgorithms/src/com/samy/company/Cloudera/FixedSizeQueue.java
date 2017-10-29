package com.samy.company.Cloudera;

/**
 * Created by samy on 11/19/16.
 */
public class FixedSizeQueue {
  private Object[] queue;
  private int head, tail;
  private int size;
  private Object lock;

  public FixedSizeQueue(int size) {
    if (size < 0)
      return;
    queue = new Object[size];
    head = 0;
    tail = 0;
    size = 0;
  }

  public void add(Object o) throws Exception {
    synchronized(lock) {
      while(size == queue.length) {
        lock.wait();
      }
      queue[tail++] = o;
      size++;
      tail %= queue.length;
      lock.notify();
    }
  }

  public Object remove() throws Exception {
    synchronized(lock) {
      while(size == 0) {
        lock.wait();
      }
      Object o = queue[head++];
      head %= queue.length;
      size--;
      lock.notify();
      return o;
    }
  }
}
