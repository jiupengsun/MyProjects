package com.samy.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class RectangleArea {

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description 
	 * @reference https://leetcode.com/problems/rectangle-area/
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int total = (C - A) * (D - B) + (G - E) * (H - F);
		int x1 = Math.max(A, E);
		int y1 = Math.max(B, F);
		int x2 = Math.min(C, G);
		int y2 = Math.min(D, H);
		if (x1 < x2 && y1 < y2) {
			return total - (x2 - x1) * (y2 - y1);
		}
		return total;
	}

	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description Wrong however meaningful
	 * @reference
	 */
	public int computeAreaWrongAnswer(int A, int B, int C, int D, int E, int F, int G, int H) {
		int[][] rec1 = { { A, D }, { A, B }, { C, B }, { C, D } };
		int[][] rec2 = { { E, H }, { E, F }, { G, F }, { G, H } };
		int[] p = check(rec1, rec2, true);
		// one point intersection
		// p1x, p1y, p2x, p2y
		// two points intersection
		// p1x, p1y, p2x, p3y
		// cover
		// p1x, p1y, p2x, p2y
		return Math.abs(p[0] - p[2]) * Math.abs(p[1] - p[3]);
	}

	/*
	 * determine the style of two rectangles, check each point of rec1 to find whether it locates in rec2
	*/
	private int[] check(int[][] rec1, int[][] rec2, boolean recursive) {
		int[] p = new int[4];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < 4; ++i)
			// in the rec2
			if (rec1[i][0] >= rec2[0][0] && rec1[i][0] <= rec2[2][0] && rec1[i][1] >= rec2[2][1]
					&& rec1[i][1] <= rec2[0][1]) {
				q.add(rec1[i][0]);
				q.add(rec1[i][1]);
			}
		int length = q.size();
		switch (length) {
		case 0: {
			// no intersection
			if (recursive)
				p = check(rec2, rec1, false);
		}
			break;
		case 1: {
			// one intersection, total two
			p[0] = q.poll();
			p[1] = q.poll();
			for (int i = 0; i < 4; ++i) {
				if (p[0] == rec1[i][0] && p[1] == rec1[i][1]) {
					p[2] = rec2[(i + 2) % 4][0];
					p[3] = rec2[(i + 2) % 4][1];
					break;
				}
			}
		}
			break;
		case 4: {
			for (int i = 0; i < 4; ++i) {
				p[i] = q.poll();
			}
			if (p[0] == p[2]) {
				//x1 = x2, vertical
				if (rec2[0][0] >= rec1[0][0] && rec2[2][0] < rec1[2][0]) {
					p[0] = rec1[2][1];
					p[1] = rec1[2][0];
					p[2] = rec1[3][1];
					p[3] = rec2[0][0];
				} else if (rec2[2][0] > rec1[0][0] && rec2[2][0] < rec1[2][0]) {
					p[0] = rec1[0][1];
					p[1] = rec1[0][0];
					p[2] = rec1[1][1];
					p[3] = rec2[2][0];
				}

			} else if (p[1] == p[3]) {
				//y1 = y2, horital
				if (rec2[0][1] > rec1[1][1] && rec2[0][1] < rec1[0][1]) {
					p[0] = rec1[1][0];
					p[1] = rec1[1][1];
					p[2] = rec1[2][0];
					p[3] = rec2[0][1];
				} else if (rec2[1][1] > rec1[1][1] && rec2[1][1] < rec1[0][1]) {
					p[0] = rec1[0][0];
					p[1] = rec1[0][1];
					p[2] = rec1[3][0];
					p[3] = rec2[1][1];
				}
			}
		}
			break;
		case 8: {
			p[0] = rec1[0][0];
			p[1] = rec1[0][1];
			p[2] = rec1[2][0];
			p[3] = rec1[2][1];
		}
		}
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleArea rec = new RectangleArea();
		System.out.println(rec.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}

}
