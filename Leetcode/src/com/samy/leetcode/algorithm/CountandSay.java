package com.samy.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class CountandSay {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ19ÈÕ
	 * @author Jiupeng
	 * @description 18 test cases, 7ms beats 39.89%
	 * @reference https://leetcode.com/problems/count-and-say/
	 */
	public String countAndSay(int n) {
		Queue<Character> q = new LinkedList<Character>();
		q.add('1');
		q.add('0');
		int i = 1;
		while (i < n) {
			char c, last = q.poll();
			int count = 1;
			while (true) {
				c = q.poll();
				if (c == last)
					++count;
				else {
					q.add((char) (count + '0'));
					q.add(last);
					if (c == '0') {
						q.add('0');
						++i;
						break;
					}
					last = c;
					count = 1;
				}
			}
		}

		// the end is 0
		int l = q.size() - 1;
		char[] s = new char[l];
		for (i = 0; i < l; ++i)
			s[i] = q.poll();
		return String.valueOf(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay cs = new CountandSay();
		System.out.println(cs.countAndSay(2));
	}

}
