package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class KthLargestElementinanArray {

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 31 test cases, 4ms beats 80.07%
	 * @reference https://leetcode.com/problems/kth-largest-element-in-an-array/
	 * @interpretation
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 31 test cases, 130ms beats 2.49%
	 * @reference 
	 * @interpretation https://en.wikipedia.org/wiki/Selection_algorithm
	 * http://c3p0demo.googlecode.com/svn/trunk/scalaDemo/script/Order_statistics.ppt
	 */
	public int findKthLargest2(int[] nums, int k) {
		int maxIndex, maxValue;
		for (int i = 0, l = nums.length; i < k; ++i) {
			maxIndex = i;
			maxValue = nums[i];
			for (int j = i + 1; j < l; ++j) {
				if (nums[j] > maxValue) {
					maxIndex = j;
					maxValue = nums[j];
				}
			}
			int tmp = nums[i];
			nums[i] = nums[maxIndex];
			nums[maxIndex] = tmp;
		}
		return nums[k - 1];
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年3月23日
	 * @author Jiupeng
	 * @description 31 test cases, 4ms beats 80.07%
	 * @reference 
	 * @interpretation http://stackoverflow.com/questions/251781/how-to-find-the-kth-largest-element-in-an-unsorted-array-of-length-n-in-on#255128
	 */
	public int findKthLargest3(int[] nums, int k) {
		return quickSelect(nums, nums.length, k);
	}

	private int quickSelect(int[] nums, int length, int k) {
		int[] left = new int[length];
		int[] right = new int[length];
		int i = 0, j = 0;
		int pivot = nums[(int) (Math.random() * length)];
		for (int m = 0; m < length; ++m) {
			if (nums[m] > pivot)
				left[i++] = nums[m];
			else if (nums[m] < pivot)
				right[j++] = nums[m];
		}
		if (k <= i)
			return quickSelect(left, i, k);
		else if (k > length - j)
			return quickSelect(right, j, k - (length - j));
		else
			return pivot;
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年3月23日
	 * @author Jiupeng
	 * @description
	 * @reference  https://en.wikipedia.org/wiki/Median_of_medians
	 * @interpretation https://leetcode.com/discuss/88064/97%25-2ms-java-quick-select-solution
	 */
	public int findKthLargestSample(int[] nums, int k) {
		return select(nums, 0, nums.length - 1, k - 1);
	}

	private int select(int[] nums, int left, int right, int k) {
		while (true) {
			if (left == right)
				return nums[left];
			int pivotIndex = pivot(nums, left, right, 3);
			pivotIndex = partition(nums, left, right, pivotIndex);
			if (pivotIndex == k)
				return nums[k];
			else if (pivotIndex > k)
				right = pivotIndex - 1;
			else
				left = pivotIndex + 1;
		}
	}

	private int pivot(int[] nums, int left, int right, int type) {
		if (type == 3)
			return medianOf3(nums, left, right);
		else
			return medianOf5(nums, left, right);
	}

	/**
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 * 2016年3月23日
	 * @author Jiupeng
	 * @description passed
	 * @reference 
	 * @interpretation
	 */
	private int medianOf3(int[] nums, int left, int right) {
		int mid = left + ((right - left) >> 1);
		if (nums[left] < nums[right])
			swap(nums, left, right);
		if (nums[mid] < nums[right])
			swap(nums, mid, right);
		if (nums[left] < nums[mid])
			swap(nums, left, mid);
		return mid;
	}

	/**
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 * 2016年3月23日
	 * @author Jiupeng
	 * @description not passed yet
	 * @reference 
	 * @interpretation
	 */
	private int medianOf5(int[] nums, int left, int right) {
		if (right - left < 5)
			return partition5(nums, left, right);
		for (int i = left; i <= right; i += 5) {
			int subRight = i + 4 < right ? i + 4 : right;
			int median5 = partition5(nums, i, subRight);
			swap(nums, median5, left + (i - left) / 5);
		}
		return select(nums, left, left + (int) Math.ceil((right - left) / 5) - 1,
				left + (right - left) / 10);
	}

	/**
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 * 2016年3月23日
	 * @author Jiupeng
	 * @description directly using insertion sort
	 * @reference https://en.wikipedia.org/wiki/Insertion_sort
	 * @interpretation
	 */
	private int partition5(int[] nums, int left, int right) {
		for (int i = left + 1; i <= right; ++i)
			for (int j = i; j > 0 && nums[j - 1] < nums[j]; --j)
				swap(nums, j, j - 1);
		return left + ((right - left) >> 1);
	}

	private int partition(int[] nums, int left, int right, int pivotIndex) {
		int pivotValue = nums[pivotIndex];
		swap(nums, right, pivotIndex);
		int index = left;
		for (int i = left; i < right; ++i) {
			if (nums[i] > pivotValue) {
				swap(nums, index, i);
				++index;
			}
		}
		swap(nums, index, right);
		return index;
	}

	private void swap(int[] nums, int a, int b) {
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		KthLargestElementinanArray ke = new KthLargestElementinanArray();
		System.out.println(ke.findKthLargest3(nums, 2));
	}

}
