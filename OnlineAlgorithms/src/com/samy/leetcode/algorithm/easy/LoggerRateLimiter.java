package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * Created by samy on 11/19/16.
 */
public class LoggerRateLimiter {}

class Logger{
  Map<String, Integer> log;
  /** Initialize your data structure here. */
  public Logger() {
    log = new HashMap<>();
  }

  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    Integer lastTime = log.get(message);
    if(lastTime == null) {
      log.put(message, timestamp);
      return true;
    } else {
      if(timestamp - lastTime >= 10) {
        // update timestamp
        log.put(message, timestamp);
        return true;
      }
      return false;
    }
  }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
