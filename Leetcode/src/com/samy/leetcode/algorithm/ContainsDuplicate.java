package com.samy.leetcode.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年1月12日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/contains-duplicate/
	 */
	public static boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		for (int i : nums) {
			if (map.containsKey(i))
				return true;
			map.put(i, i);
		}
		return false;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年1月12日
	 * @author Jiupeng
	 * @description Though HashMap is faster than HashSet(since HashSet is actual a HashMap), this case is faster. Becaue it 
	 * only execute once put and return a value, while if using hashmap, I have to check firstly, then put it in
	 * @reference
	 */
	public static boolean containsDuplicateSample(int[] nums) {
		HashSet<Integer> flag = new HashSet<Integer>();

		for (int i : nums) {
			if (!flag.add(i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
