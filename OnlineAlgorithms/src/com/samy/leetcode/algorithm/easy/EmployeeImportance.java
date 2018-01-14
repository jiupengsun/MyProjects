package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
  public int getImportance(List<Employee> employees, int id) {
    if(employees == null)
      return 0;
    Map<Integer, Employee> map = new HashMap<>();
    Employee target = null;
    for(Employee e: employees) {
      if(e.id == id)
        target = e;
      map.put(e.id, e);
    }
    if(target == null)
      return 0;
    return countImp(target, map);
  }

  private int countImp(Employee e, Map<Integer, Employee> map) {
    int sum = e.importance;
    for(int c: e.subordinates) {
      Employee child = map.get(c);
      sum += countImp(child, map);
    }
    return sum;
  }
}
