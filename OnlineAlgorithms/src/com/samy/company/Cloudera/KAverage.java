package com.samy.company.Cloudera;

/**
 * Created by samy on 11/19/16.
 */
public class KAverage {
  private int[] window;
  private int current;
  private int current_size;
  private double aver;
  private int sum;
  private Object lock;

  public KAverage(int size) {
    window = new int[size];
    current = 0;
    current_size = 0;
    aver = 0;
    sum = 0;
    lock = new Object();
  }

  public void add(int val) {
    synchronized(lock) {
      sum -= window[current];
      sum += val;
      window[current++] = val;
      current %= window.length;
      if(current_size < window.length)
        ++current_size;
      aver = (double) sum / current_size;
    }
  }

  public double get() {
    return aver;
  }
}
