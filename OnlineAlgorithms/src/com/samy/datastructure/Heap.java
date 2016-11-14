package com.samy.datastructure;

/**
 * Created by samy on 10/30/16.
 */
public class Heap {

  private int[] heap;
  private int max_heap_size;

  public Heap(int[] array) {
    if (array != null) {
      this.heap = array;
      this.max_heap_size = array.length;
      max_heapify();
    }
  }

  public Heap(int size) {
    this.max_heap_size = size;
    heap = new int[this.max_heap_size];
  }

  /**
   * heapify this heap
   */
  private void max_heapify() {
    for(int i=(max_heap_size >> 1)-1; i>=0; --i) {
      max_heapify(i);
    }
  }

  private void max_heapify(int i) {
    // notice that if it's a 0-based array, left child will be 2i+1
    // if 1-based, left child will be 2i
    int l = (i << 1) + 1;
    int r = l + 1;
    int smaller = i;
    if (l < max_heap_size && heap[l] > heap[smaller])
      smaller = l;
    if (r < max_heap_size && heap[r] > heap[smaller])
      smaller = r;
    if (smaller != i) {
      swap(heap, smaller, i);
      max_heapify(smaller);
    }
  }

  private static void swap(int[] array, int i, int j) {
    if (i == j)
      return;
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  public static void min_heapify(int[] array, int length) {
    if (length > array.length)
      return;
    for(int i=(length>>1) - 1; i>=0; --i) {
      min_heapify(array, i, length);
    }
  }

  private static void min_heapify(int[] array, int i, int length) {
    int select = i;
    int left_child = (i<<1) + 1;
    int right_child = left_child + 1;
    if (left_child < length && array[left_child] < array[select])
      select = left_child;
    if (right_child < length && array[right_child] < array[select])
      select = right_child;
    if (select != i) {
      swap(array, i, select);
      min_heapify(array, select, length);
    }
  }

  public static void main(String[] args) {
    int[] heap = new int[]{2,8,1,7,9,10,3,14,4,16};
    Heap.min_heapify(heap, heap.length);
    for(int i : heap)
      System.out.print(i + " ");
    System.out.println();
  }

}
