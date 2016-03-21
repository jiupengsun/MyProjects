package com.samy.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumberII {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年3月20日
	 * @author Jiupeng
	 * @description 596 test cases, 88ms beats 15.12%
	 * @reference https://leetcode.com/problems/ugly-number-ii/
	 * @interpretation https://wwwx.cs.unc.edu/~duozhao/entry/2015/08/ugly-number-ii/
	 */
	public int nthUglyNumber1(int n) {
		PriorityQueue<Long> que = new PriorityQueue<Long>();
		que.add(1l);
		long last = 0;
		for (int i = 1; i <= n;) {
			long now;
			if ((now = que.poll()) == last)
				continue;
			last = now;
			que.add(now << 1);
			que.add(3 * now);
			que.add(5 * now);
			++i;
		}
		return (int) last;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 596 test cases, 8ms beats 87.07%
	 * @reference 
	 * @interpretation https://zhongyinzhang.wordpress.com/2015/08/20/ugly-number-ii/
	 */
	public int nthUglyNumber2(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int index2 = 0, index3 = 0, index5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		for (int i = 1; i < n; ++i) {
			ugly[i] = min(factor2, factor3, factor5);
			if (factor2 == ugly[i]) {
				++index2;
				factor2 = ugly[index2] << 1;
			}
			if (factor3 == ugly[i]) {
				++index3;
				factor3 = ugly[index3] * 3;
			}
			if (factor5 == ugly[i]) {
				++index5;
				factor5 = ugly[index5] * 5;
			}
		}
		return ugly[n - 1];
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 596 test cases, 56ms beats 20.49%
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/67877/%08two-standard-dp-solutions
	 */
	public int nthUglyNumber3(int n) {
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		q2.add(1);
		q3.add(1);
		q5.add(1);
		int now = 1;
		for (int i = 1; i <= n; ++i) {
			now = min(q2.peek(), q3.peek(), q5.peek());
			if (now == q2.peek())
				q2.poll();
			if (now == q3.peek())
				q3.poll();
			if (now == q5.peek())
				q5.poll();
			q2.add(now << 1);
			q3.add(now * 3);
			q5.add(now * 5);
		}
		return now;
	}

	private int min(int n1, int n2, int n3) {
		return n1 < n2 ? (n1 < n3 ? n1 : n3) : (n2 < n3 ? n2 : n3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumberII unii = new UglyNumberII();
		System.out.println(unii.nthUglyNumber1(1407));
	}

}
