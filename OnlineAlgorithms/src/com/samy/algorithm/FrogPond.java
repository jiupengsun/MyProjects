package com.samy.algorithm;

public class FrogPond {

	/**
	 * 
	 * @param A
	 * @param N
	 * @param X
	 * @param D
	 * @return
	 * @author Jiupeng
	 * @description
	 * @reference http://www.1point3acres.com/bbs/thread-137338-1-1.html
	 */
	public int solution(int[] A, int X, int D) {
		if (X <= D)
			return 0;
		int[] step = new int[X + 1];
		int l = A.length, d, i, j;
		for (i = 0, d = X + 1; i < l && d > 0; ++i) {
			int st = Math.max(0, A[i] - D);
			int en = Math.min(X, A[i] + D);
			for (j = st; j <= en; ++j) {
				if (step[j] == 0) {
					step[j] = 1;
					--d;
				}
			}
		}
		return d > 0 ? -1 : i - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 3, 1, 4, 2, 5 };
		int X = 7, D = 3;
		FrogPond fp = new FrogPond();
		System.out.println(fp.solution(A, X, D));
	}

}
