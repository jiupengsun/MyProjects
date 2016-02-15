package com.samy.algorithm;

public class FindTwoNumsClosestZero {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description find two nums in an integer array, ensure the sum of the nums is closest to zero
	 * @reference
	 */
	public int closestZero(int[] nums) {
		int l = nums.length;
		switch (l) {
		case 0:
			return 0;
		case 1:
			return nums[0];
		case 2:
			return nums[0] + nums[1];
		default: {
			quickSort(nums, 0, nums.length - 1);
			if (nums[0] >= 0)
				return nums[0] + nums[1];
			else if (nums[l - 1] <= 0)
				return nums[l - 1] + nums[l - 2];
			else {
				int i = 0, j = l - 1, min = Integer.MAX_VALUE, tmp;
				while (i < j) {
					tmp = nums[i] + nums[j];
					if (tmp == 0)
						return tmp;
					min = Math.min(min, Math.abs(tmp));
					if (tmp > 0)
						--j;
					else
						++i;
				}
				return min;
			}
		}
		}

	}

	/**
	 * 
	 * @param nums
	 * @param st
	 * @param en
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description quick sort, and return the position of sentinel
	 * @reference
	 */
	private void quickSort(int[] nums, int st, int en) {
		if (st >= en)
			return;
		int sentinel = nums[st];
		int i = st, j = en;
		while (i < j) {
			while (j > i && nums[j] > sentinel)
				--j;
			if (j > i)
				nums[i++] = nums[j];
			while (i < j && nums[i] < sentinel)
				++i;
			if (i < j)
				nums[j--] = nums[i];
		}
		nums[i] = sentinel;
		quickSort(nums, st, i - 1);
		quickSort(nums, i + 1, en);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
