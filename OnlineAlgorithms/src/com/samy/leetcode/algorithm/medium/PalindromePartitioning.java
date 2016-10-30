package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 7, 2016
	 * @author Jiupeng
	 * @description 21 test cases, 7ms beats 61.19%. DFS solution
	 * @reference https://leetcode.com/problems/palindrome-partitioning/
	 * @interpretation http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> partitions = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		helper(partitions, list, s, 0);
		return partitions;
	}

	private void helper(List<List<String>> partitions, List<String> list, String s, int st) {
		if (st == s.length()) {
			List<String> l = new ArrayList<String>(list);
			partitions.add(l);
			return;
		}
		for (int i = st, l = s.length(); i < l; ++i) {
			String tmp = s.substring(st, i + 1);
			if (isPalindrome(tmp)) {
				list.add(tmp);
				helper(partitions, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}

	public List<List<String>> partition2(String s) {
		List<List<String>> partitions = new ArrayList<List<String>>();
		boolean[][] p = palindromeArray(s);
		for (int i = 0, l = s.length(); i < l; ++i) {
			if (p[0][i]) {
				/*
				 * not finished yet
				 */
			}
		}
		return partitions;
	}

	private boolean[][] palindromeArray(String s) {
		int l = s.length();
		boolean[][] p = new boolean[l][l];
		// initiate palindrome array
		// p[i][j] is true when s.substring(i,j+1) is palindromic, otherwise is
		// false
		for (int j = 1; j < l; ++j)
			for (int i = 0; i <= j; ++i) {
				if (i == j) {
					p[i][j] = true;
					continue;
				}
				if (s.charAt(i) == s.charAt(j) && (j == i + 1 || p[i + 1][j - 1]))
					p[i][j] = true;
				else
					p[i][j] = false;
			}

		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
