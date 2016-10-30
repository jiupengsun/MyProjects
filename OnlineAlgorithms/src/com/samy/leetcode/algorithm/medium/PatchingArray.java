package com.samy.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.List;

public class PatchingArray {

	/**
	 * 
	 * @param nums
	 * @param n
	 * @return
	 * 2016年3月29日
	 * @author Jiupeng
	 * @description my own thinking, but tooooo slow!!
	 * @reference https://leetcode.com/problems/patching-array/
	 * @interpretation
	 */
	public int minPatches(int[] nums, int n) {
		int count = 0;
		List<Integer> list = new LinkedList<Integer>();
		for (int i : nums)
			list.add(i);
		int l = list.size();
		while (n > 0) {
			int m = n, i = l - 1;
			while (m > 0 && i >= 0) {
				int t = list.get(i);
				if (t <= m) {
					m -= t;
					i = binarySearch(list, m);
				}
				--i;
			}
			if (m > 0) {
				list.add(binarySearch(list, m), m);
				++l;
				++count;
			}
			--n;
		}

		return count;
	}

	private int binarySearch(List<Integer> list, int m) {
		int st = 0, en = list.size() - 1, mid;
		while (st <= en) {
			mid = (st + en) >> 1;
			int t = list.get(mid);
			if (t < m)
				st = mid + 1;
			else if (t > m)
				en = mid - 1;
			else
				return mid;
		}
		return st;
	}

	/**
	 * 
	 * @param nums
	 * @param n
	 * @return
	 * 2016年3月29日
	 * @author Jiupeng
	 * @description
	 * @reference 149 test cases, 1ms beats 15.00%
	 * @interpretation https://leetcode.com/discuss/83272/share-my-thinking-process
	 */
	public int minPatchesSample(int[] nums, int n) {
		int count = 0;
		long sum = 0;
		for (int i : nums) {
			if (sum >= n || i > n)
				break;
			while (sum < i - 1) {
				sum = (sum << 1) + 1;
				++count;
			}
			sum += i;
		}
		while (sum < n) {
			sum = (sum << 1) + 1;
			++count;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 6, 34, 38, 41, 44, 47, 47, 56, 59, 62, 73, 77, 83,
				87, 89, 94 };
		int n = 20;
		/*int[] nums = { 1, 5, 10 };
		int n = 20;*/
		PatchingArray pa = new PatchingArray();
		pa.minPatchesSample(nums, n);
	}

}
