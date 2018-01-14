package com.samy.company.Uber;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://discuss.leetcode.com/topic/8/rate-limiter/4
 */
public class RateLimiter {

  int maxCapacity;
  int interval;
  volatile long last;
  Integer tokens;
  ReentrantLock lock = new ReentrantLock();

  /**
   * initialize a rate limiter
   * two parameters indicate the function can call maxCallingTimes
   * within interval period, otherwise it will block a specific time
   * @param interval unit is seconds
   * @param maxCallingTimes max times within specific period indicates by interval
   */
  private RateLimiter(int interval, int maxCallingTimes) {
    maxCapacity = maxCallingTimes;
    last = 0;
    this.interval = interval;
    tokens = maxCallingTimes;
  }

  public void take() throws InterruptedException {
    long spend = System.currentTimeMillis() - last;
    // million seconds to seconds
    int seconds = (int) (spend / 1000);
    // need add n tokens in the system
    lock.lock();
    tokens += seconds * maxCapacity / interval;
    if(tokens < maxCapacity)
      tokens = maxCapacity;
    if(tokens < 1) {
      wait(1000 * interval / maxCapacity - spend);
      tokens++;
    }
    tokens--;
    last = System.currentTimeMillis();
    lock.unlock();
  }
}
