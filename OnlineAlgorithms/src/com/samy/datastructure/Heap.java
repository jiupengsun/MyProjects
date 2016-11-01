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
      heapify();
    }
  }

  public Heap(int size) {
    this.max_heap_size = size;
    heap = new int[this.max_heap_size];
  }

  /**
   * heapify this heap
   */
  private void heapify() {
    for(int i=(max_heap_size >> 1)-1; i>=0; --i) {
      max_heapify(i);
    }
  }

  private void max_heapify(int i) {
    int l = i << 1;
    int r = l + 1;
    int smaller = i;
    if (l < max_heap_size && heap[l] < heap[smaller])
      smaller = l;
    if (r < max_heap_size && heap[r] < heap[smaller])
      smaller = r;
    if (smaller != i) {
      swap(heap, smaller, i);
      max_heapify(smaller);
    }
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  public static void main(String[] args) {
    int[] heap = new int[]{2,8,1,7,9,10,3,14,4,16};
    Heap h = new Heap(heap);
    for(int i : heap)
      System.out.print(i + " ");
    System.out.println();
  }

}
