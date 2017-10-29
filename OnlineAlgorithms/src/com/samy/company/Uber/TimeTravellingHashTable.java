package com.samy.company.Uber;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeTravellingHashTable {

  Map<String, TreeMap<Double, String>> map = new HashMap<>();

  /**
   *
   * @param t timestamp
   * @param k key
   * @param v value
   */
  public void put(double t, String k, String v) {
    TreeMap<Double, String> tree = map.getOrDefault(k, new TreeMap<>());
    tree.put(t, v);
    map.put(k, tree);
  }

  /**
   *
   * @param t
   * @param k
   * @return key that most nearest smaller or equal with t
   */
  public String get(double t, String k) {
    TreeMap<Double, String> tree = map.getOrDefault(k, new TreeMap<>());
    return tree.floorEntry(t).getValue();
  }

  /**
   * remove key that most nearest smaller or equal with t
   * @param t
   * @param k
   */
  public void remove(double t, String k) {
    TreeMap<Double, String> tree = map.getOrDefault(k, new TreeMap<>());
    Double time = tree.floorKey(t);
    if(time != null) {
      tree.remove(time);
      map.put(k, tree);
    }
  }

  public static void main(String[] args) {
    TimeTravellingHashTable tht = new TimeTravellingHashTable();
    tht.put(1, "A", "X");
    tht.put(2, "A", "Y");
    tht.put(0, "A", "M");
    System.out.println(tht.get(1.5, "A"));
    System.out.println(tht.get(2, "A"));
    tht.remove(1.5, "A");
    System.out.println(tht.get(1.5, "A"));
  }
}
