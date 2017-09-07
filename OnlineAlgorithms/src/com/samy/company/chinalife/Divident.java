package com.samy.company.chinalife;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by samy on 11/5/16.
 */
public class Divident {

  static class Insurance {
    int id;
    int interest;
    int delay;

    Insurance(int i, int in, int d){
      id = i;
      interest = in;
      delay = d;
    }
  }

  public static int sort(List<Insurance> list) {
    Insurance[] ins = new Insurance[list.size()];
    list.toArray(ins);
    List<List<Integer>> insList = new ArrayList<>();
    calculate(ins, 0, insList);
    List<Integer> l = insList.get(0);
    int interest = l.get(0);
    for(int i=0, size=list.size(); i<size; ++i) {
      list.get(i).id = l.get(i+1);
    }
    return interest;
  }

  private static void calculate(Insurance[] ins, int index, List<List<Integer>> list) {
    if (index == ins.length) {
      int days = 0;
      int interest = 0;
      for(Insurance in : ins) {
        days += in.delay;
        interest += days * in.interest;
      }
      int min = Integer.MAX_VALUE;
      if (list.size() > 0) {
        List<Integer> lmin = list.get(0);
        min = lmin.get(0);
      }
      if (min < interest)
        // do not add this permutation
        return;
      List<Integer> lcur = new ArrayList<>(ins.length + 1);
      lcur.add(interest);
      for(Insurance in : ins) {
        lcur.add(in.id);
      }

      if (min > interest || compare(lcur, list.get(0)) < 0) {
        // add only this permutation
        list.clear();
        list.add(lcur);
      }
    } else {
      for(int i=index; i<ins.length; ++i) {
        swap(ins, index, i);
        // permutate elements after index
        calculate(ins, i+1, list);
        swap(ins, i, index);
      }
    }
  }

  private static int compare(List<Integer> l1, List<Integer> l2) {
    for(int i=1, l=l1.size(); i<l; ++i) {
      if(l1.get(i) < l2.get(i))
        return -1;
      else
        return 1;
    }
    return 0;
  }

  private static void swap(Insurance[] ins, int i, int j) {
    if (i==j)
      return;
    Insurance tmp = ins[i];
    ins[i] = ins[j];
    ins[j] = tmp;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<List<Insurance>> ins = new ArrayList<>();
    int testcase = Integer.parseInt(in.nextLine());
    for(int i=0; i<testcase; ++i) {
      int number = Integer.parseInt(in.nextLine());
      List<Insurance> list = new ArrayList<>(number);
      for(int j=0; j<number; ++j) {
        String[] s = in.nextLine().split(" ");
        Insurance d = new Insurance(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        list.add(d);
      }
      ins.add(list);
    }

    for(int i=0; i<testcase; ++i) {
      int interest = sort(ins.get(i));
      for(Insurance n : ins.get(i))
        System.out.print(n.id + " ");
      System.out.println();
      System.out.println(interest);
    }
  }
}
