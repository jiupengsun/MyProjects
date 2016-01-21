package com.samy.leetcode.algorithm;

public class RangeSumQueryImmutable {

	private int[] triangle;
	private int[] nums;
	private int n;

	/**
	 * 
	 * @param nums
	 * 2016Äê1ÔÂ21ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/range-sum-query-immutable/
	 */
	public RangeSumQueryImmutable(int[] nums) {
		this.nums = nums;
		n = nums.length;
		triangle = new int[n * (n - 1) >> 1];
		int i = 0, j = 0, k = 0, t = 0;
		for (; i < n - 1; ++i)
			triangle[k++] = nums[i] + nums[i + 1];

		for (i = 1; i < n; ++i) {
			for (j = i + 1, t = n - i; j < n; ++j, ++k) {
				triangle[k] = triangle[k - t] + nums[j];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (i == j)
			return nums[i];
		else {
			int k = j - i, pos = i;
			while ((--k) > 0) {
				pos += n - k;
			}
			return triangle[pos];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[-2,0,3,-5,2,-1],sumRange(0,2),sumRange(2,5),sumRange(0,5)

		int[] nums = { -2, 0, 3, -5, 2, -1 };
		/*int[] nums = new int[10000];
		for (int i = 0; i < 10000; ++i)
			nums[i] = i;*/
		RangeSumQueryImmutable rs = new RangeSumQueryImmutable(nums);
		System.out.println(rs.sumRange(0, 1));
		System.out.println(rs.sumRange(1, 2));
		/*System.out.println(rs.sumRange(3, 123));
		System.out.println(rs.sumRange(5, 2356));
		System.out.println(rs.sumRange(7654, 9876));*/
	}

}
