package com.samy.company.Uber;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://instant.1point3acres.com/thread/278953
 */
public class FunctionCallTime {

  /**
   * Need thinking about function call in recursive mode
   * calculate the max time
   *
   * @param log
   */
  public static void printCallTime(String[] log) {
    Map<String, Integer> map = new HashMap<>();
    Deque<Function> stack = new LinkedList<>();
    int current_time = 0;
    for (String s : log) {
      String[] tmp = s.split(" ");
      if (tmp[1].equals("Enter")) {
        // new Function
        Function f = new Function(tmp[0]);
        f.real_time = current_time;
        f.start_time = tmp[2];
        stack.push(f);
      } else {
        // exit
        Function f = stack.pop();
        int duration = interval(f.start_time, tmp[2]);
        map.put(f.name, Math.max(duration - current_time + f.real_time, map.getOrDefault(f.name, 0)));
        current_time = duration + f.real_time;
      }
    }
    for (Map.Entry<String, Integer> m : map.entrySet()) {
      System.out.println(m.getKey() + " " + m.getValue());
    }
  }

  private static int interval(String st, String en) {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    try {
      return (int) (sdf.parse(en).getTime() - sdf.parse(st).getTime()) / 1000;
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public static void main(String[] args) {
    String[] log = new String[]{
      "F1 Enter 10:00:00",
      "F2 Enter 10:00:06",
      "F2 Exit 10:00:07",
      "F3 Enter 10:00:08",
      "F3 Exit 10:00:12",
      "F1 Exit 10:00:15"
    };
    printCallTime(log);
  }

  static class Function {
    String name;
    String start_time;
    int real_time;

    Function(String n) {
      name = n;
    }
  }

}
