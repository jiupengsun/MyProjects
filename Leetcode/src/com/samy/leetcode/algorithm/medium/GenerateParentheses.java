package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年2月20日
	 * @author Jiupeng
	 * @description 8 test cases, 2ms beats 25.17%
	 * @reference https://leetcode.com/problems/generate-parentheses/
	 * @interpretation https://leetcode.com/discuss/12400/concise-code-in-java
	 */
	public List<String> generateParenthesisSample1(int n) {
		List<String> list = new ArrayList<String>();
		sample1Helper(n, 0, "", list);
		return list;
	}

	private void sample1Helper(int left, int right, String par, List<String> list) {
		if (left == 0 && right == 0) {
			list.add(par);
			return;
		}
		if (left > 0)
			sample1Helper(left - 1, right + 1, par + "(", list);
		if (right > 0)
			sample1Helper(left, right - 1, par + ")", list);
		return;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年2月20日
	 * @author Jiupeng
	 * @description f(n) = (f(0))f(n-1)+(f(1))f(n-2)+(f(2))f(n-3)+......+(f(n-3))f(2)+(f(n-2))f(1)+(f(n-1))f(0)
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/11509/an-iterative-method
	 */
	public List<String> generateParenthesisSample2(int n) {
		List<List<String>> listCollection = new ArrayList<List<String>>();

		listCollection.add(Collections.singletonList(""));
		for (int i = 1; i <= n; ++i) {
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < i; ++j) {
				//(f(i))
				for (final String left : listCollection.get(j)) {
					for (final String right : listCollection.get(i - j - 1))
						list.add("(" + left + ")" + right);
				}
				//
			}

			listCollection.add(list);
		}

		return listCollection.get(n);
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年2月20日
	 * @author Jiupeng
	 * @description A wrong answer!!!!!!!!!!!!!!
	 * @reference https://leetcode.com/problems/generate-parentheses/
	 * @interpretation https://leetcode.com/discuss/2647/does-the-order-matter-rejected-even-when-got-all-them-correct
	 */
	public List<String> generateParenthesisWrong(int n) {
		List<String> list = new ArrayList<String>();
		if (n == 0)
			list.add("");
		else if (n == 1)
			list.add("()");
		else {
			List<String> tmp = generateParenthesisWrong(n - 1);
			int i, l = tmp.size();
			for (String s : tmp) {
				list.add("(" + s + ")");
			}
			for (i = 0; i < l - 1; ++i) {
				list.add("()" + tmp.get(i));
				list.add(tmp.get(i) + "()");
			}
			list.add("()" + tmp.get(l - 1));
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
