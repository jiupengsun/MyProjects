package com.samy.company.Uber;

public class TokenBucket {

  long timestamp;
  int capacity;
  int token;
  long interval;

  public TokenBucket(int c, long in) {
    capacity = c;
    interval = in;
  }

  public synchronized boolean take() {
    long now = System.currentTimeMillis();
    token += (now - timestamp) / interval;
    timestamp = now;
    if(token > capacity)
      token = capacity;
    if(token < 1)
      return false;
    token--;
    return true;
  }
}
