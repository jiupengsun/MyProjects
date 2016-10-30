package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {

	/**
	 * 
	 * @param rowIndex
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/pascals-triangle-ii/
	 */
	public List<Integer> getRow(int rowIndex) {
		Integer[] l = new Integer[++rowIndex];
		int mid = (rowIndex) >> 1, j = 0;
		for (; j <= mid; ++j) {
			int com = combination(rowIndex - 1, j);
			l[j] = com;
			l[rowIndex - j - 1] = com;
		}
		return Arrays.asList(l);
	}

	private int combination(int n, int k) {
		k = Math.min(k, n - k);
		long numerator = 1, denominator = 1;
		int i = 1;
		while (i <= k) {
			denominator *= n - k + i;
			numerator *= i++;
			if ((denominator & 1) == 0 && (numerator & 1) == 0) {
				denominator >>>= 1;
				numerator >>>= 1;
			}
		}
		return (int) (denominator / numerator);
	}

	/**
	 * 
	 * @param rowIndex
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description Ck^i = Ck^(i-1) * [k-(i-1)] / i
	 * @reference https://leetcode.com/discuss/77693/my-clean-o-k-java-solution
	 */
	public List<Integer> getRowSample(int rowIndex) {
		Integer[] rowList = new Integer[rowIndex + 1];
		rowList[0] = 1;
		for (int i = 1; i < rowList.length; i++) {
			rowList[i] = (int) ((long) rowList[i - 1] * (rowIndex - (i - 1)) / (i));
		}
		return Arrays.asList(rowList);
	}

	/**
	 * 
	 * @param rowIndex
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description fastest, but need the most spaces
	 * @reference https://leetcode.com/discuss/75292/1ms-java-o-k-space-beats-90%25
	 */
	public List<Integer> getRowSample2(int rowIndex) {
		int n = rowIndex;
		int[] tmp = new int[2 * n + 3];
		tmp[n + 1] = 1;
		int left = n + 1, right = n + 1;
		while (n-- > 0) {
			--left;
			++right;
			for (int i = left; i <= right; i += 2) {
				tmp[i] = tmp[i - 1] + tmp[i + 1];
			}
		}
		List<Integer> ret = new ArrayList<>();
		for (int i = left; i <= right; i += 2) {
			ret.add(tmp[i]);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangleII p = new PascalsTriangleII();
		List<Integer> l = p.getRow(31);
		System.out.print(l);
	}

}
