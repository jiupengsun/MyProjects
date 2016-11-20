package com.samy.algorithm;

import java.util.Arrays;

public class Sort {

  public static void shellSort(int[] A, int st, int length) {
    int[] step = new int[] {5, 2, 1};
    int en = st + length;
    for(int s : step) {
      for(int i=st+s; i<en; i+=s) {
        int t = A[i];
        int j = i;
        while(j>st && t < A[j-s]) {
          A[j] = A[j-s];
          j -= s;
        }
        A[j] = t;
      }
    }
  }

  public static void insertSort(int[] A, int st, int length) {
    int en = st + length;
    for(int i=st+1, j; i<en; ++i) {
      int t = A[i];
      j = i;
      while(j>st && t < A[j-1]) {
        A[j] = A[j-1];
        --j;
      }
      A[j] = t;
    }
  }

  public static void mergeSort(int[] A, int st, int length) {
    if(length < 2)
      return;
    int[] B = new int[length];
    int mid = st+(length>>1), en=st+length;
    mergeSort(A, st, mid-st);
    mergeSort(A, mid, en-mid);
    // merge
    int i=st, j=mid, k=0;
    while(i<mid && j<en) {
      B[k++] = A[i] < A[j] ? A[i++] : A[j++];
    }
    while(i<mid) {
      B[k++] = A[i++];
    }
    while(j<en) {
      B[k++] = A[j++];
    }
    // copy
    System.arraycopy(B, 0, A, st, length);
  }

  public static void selectSort(int[] A, int st, int length) {
    int en = st + length;
    for(int i=st; i<en-1; ++i) {
      for(int j=i+1; j<en; ++j) {
        if(A[j] < A[i])
          swap(A, i, j);
      }
    }
  }

  public static void heapSort(int[] A, int st, int length) {
    // build the max heap
    max_heap(A, st, length);
    // sort
    int en = st + length;
    for(int i=en-1; i>st; --i) {
      // swap top node of heap
      swap(A, st, i);
      // rebuild the heap
      // reduce the length of the heap by 1
      max_heapify(A, st, i-st, st);
    }
  }

  private static void max_heap(int[] A, int st, int length) {
    for(int i=st+(length>>1); i>=st; --i) {
      max_heapify(A, st, length, i);
    }
  }

  private static void max_heapify(int[] A, int st, int length, int current) {
    int left = (current<<1) - st;
    int right = left + 1;
    int en = st + length, select=current;
    if(left<en && A[left] > A[select])
      select = left;
    if(right<en && A[right] > A[select])
      select = right;
    if(select != current) {
      swap(A, select, current);
      max_heapify(A, st, length, select);
    }

  }

  public static void quickSort(int[] A, int st, int length) {
    if(length < 2)
      return;
    int pivot = partition(A, st, length);
    quickSort(A, st, pivot-st);
    quickSort(A, pivot, st+length-pivot);
  }

  private static int partition(int[] A, int st, int length) {
    int en = st + length;
    // let right be the sentinel
    int right = A[en-1];
    int i = st;
    for(int j=st+1;j<en-1; ++j) {
      if(A[j] < right)
        swap(A, j, i++);
    }
    // put sentinel in the pivot
    swap(A, i, en-1);
    // i is the pivot
    return i;
  }

  public static void bubbleSort(int[] A, int st, int length) {
    int en = st + length;
    for(int i=st; i<en-1; ++i) {
      for(int j=en-1; j>i; --j) {
        if(A[j] < A[j-1])
          swap(A, j, j-1);
      }
    }
  }

  public static void countingSort(int[] A, int min, int max) {
    int[] c = new int[max - min + 1];
    for (int i : A)
      c[i - min]++;
    for (int i = 0, j = 0; i < c.length; ++i) {
      while (c[i]-- > 0)
        A[j++] = min + i;
    }
  }

  private static void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  public static void println(int[] A, String split) {
    for (int i : A)
      System.out.print(i + split);
    System.out.println();
  }

  public void testcase() {

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // int[] a = { 1, 5, 6, 23, 8, 3, 7, 9, 213 };
    // int[] a = { 2, 3, 1, 4 };
    String s = "abkefesicegesxklfehwalt";
    int[] character = new int[s.length()];
    for (int i = 0, l = s.length(); i < l; ++i)
      character[i] = s.charAt(i) - 'a';
    //bubbleSort(a, 0, a.length - 1, false);
    countingSort(character, 0, 25);
    println(character, " ");
    StringBuilder sb = new StringBuilder();
    for (int i : character)
      sb.append((char) (i + 'a'));
    System.out.println(sb.toString());
  }

}
