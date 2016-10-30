package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê2ÔÂ21ÈÕ
	 * @author Jiupeng
	 * @description 12 test cases, 1ms beats 59.6%
	 * @reference https://leetcode.com/problems/gray-code/
	 * @interpretation
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> gray = new ArrayList<Integer>();
		gray.add(0);
		int i = 0;
		while (i < n) {
			int or = 1 << (i++);
			for (int j = gray.size() - 1; j >= 0; --j)
				gray.add(gray.get(j) | or);
		}
		return gray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
