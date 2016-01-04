package com.samy.ucr.project.Comparable.pageRank;

import org.junit.Test;

public class PageRankTest {

	@Test
	public void test() {
		/*
		 * step1: define the number of pages, threshold;
		 */
		/*
		 * step2: generate the directed connected graph randomly. algorithm:
		 * generate a directed loop, then randomly add edge;
		 */
		/*
		 * step3: generate the transform matrix, and set the rank value of each page
		 */
		/*
		 * step4: iteratively compute the rank value, and assign it to the page,
		 */
		/*
		 * step5: then sort the pages according to the rank value, calculate the
		 * stability
		 */
		final int size = 5000;
		double threshold = 0.00001d / Math.pow(size, 3);
		double percent = 0.5;
		double dEle = 0.8f;

		Page[] pages = new Page[size];
		// unit vector
		double[] _E = new double[size];
		for (int i = 0; i < size; i++) {
			pages[i] = new Page(i);
			_E[i] = 1d;
		}
		//////

		// transform matrix
		double[][] transformMatrix = PageRank.transformMatrix(PageRank.randomConnectedGraph(size, percent));
		double[] result;
		double[] page = _E;
		int loop = 0;
		//////
		while (true) {
			result = PageRank.computeRank(transformMatrix, page, _E, dEle);
			loop++;
			for (int i = 0; i < size; i++)
				pages[i].setRankValue((float) result[pages[i].getId()]);
			double stability = PageRank.sortAndComputeStability(pages);
			System.out.println("loop " + loop + ", stability:" + stability);
			if (Matrix.absoluteLessThanThreshold(Matrix.minus(result, page), threshold))
				break;
			page = result;
		}
	}

}
