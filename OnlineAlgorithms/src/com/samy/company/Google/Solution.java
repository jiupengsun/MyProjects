package com.samy.company.Google;

// you can also use imports, for example:
// import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public String solution(String S) {
    // write your code in Java SE 8
    int minutes = 0;
    int hours = 0;
    HashSet<Integer> nums = new HashSet<Integer>();

    int indexOfColon = S.indexOf(":");
    char[] allNum = S.toCharArray();

    // save numbers in hour
    for (int i = 0 ; i < indexOfColon ; i++) {
      int num = allNum[i] - '0';
      nums.add(num);
      hours = hours * 10 + num;
    }

    // save numbers in minute
    for (int i = indexOfColon + 1 ; i < indexOfColon ; i++) {
      int num = allNum[i] - '0';
      nums.add(num);
      minutes = minutes * 10 + num;
    }

    // add time from now till find the answer
    boolean[] record = new boolean[60];

    boolean flagMinute;
    boolean flagHour;

    minutes++;

    while (true) {
      flagMinute = false;
      flagHour = false;

      if (minutes >= 60) {
        hours++;
        minutes = minutes - 60;

        if (hours >= 24) hours = 0;
      }

      // check whether minutes contain the numbers that can be used
      if (record[minutes]) {
        flagMinute = true;
      } else {
        int num1 = minutes % 10;
        int num2 = minutes / 10;

        if (nums.contains(num1) && nums.contains(num2)) {
          flagMinute = true;
          record[minutes] = true;
        }
      }

      // If minute passes check, check hour
      if (flagMinute) {
        if (record[hours]) {
          flagHour= true;
        } else {
          int num1 = hours % 10;
          int num2 = hours / 10;

          if (nums.contains(num1) && nums.contains(num2)) {
            flagHour = true;
            record[hours] = true;
          }
        }

        if (flagHour) {
          String min = String.valueOf(minutes);
          String hr = String.valueOf(hours);
          if (minutes < 10) {
            min = "0" + min;
          }
          if (hours < 10) {
            hr = "0" + hr;
          }
          String result = hr + ":" + min;
          return result;
        }
      }

      minutes++;

    }
  }

  public static void main(String[] args) {
    int[] P = new int[] {};
    int k = 3;
    TreeSet<Integer> set = new TreeSet<>();
    set.add(1);
    set.add(P.length);
    for(int i: P) {
      Integer h = set.higher(P[i]);
      if(h == null)
        h = P.length;
      if(h - P[i] == k)
        System.out.println(i);
      Integer l = set.lower(P[i]);
      if(l == null)
        l = 1;
      if(P[i] - l == k)
        System.out.println(i);
      set.add(P[i]);
    }
  }
}
