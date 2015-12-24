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
		final int size = 10000;
		float threshold = 0.00005f;
		Page[] pages = new Page[size];
		// unit vector
		float[] _E = new float[size];
		for (int i = 0; i < size; i++) {
			pages[i] = new Page(i);
			_E[i] = 1f / size;
		}
		//////
		double percent = 0.5;
		int weight = size / 10;
		// transform matrix
		float[][] transformMatrix = PageRank.transformMatrix(PageRank.randomConnectedGraph(size, percent), weight);
		float[] result;
		float[] page = _E;
		float dEle = 0.8f;
		int loop = 0;
		//////
		while (true) {
			result = PageRank.computeRank(transformMatrix, page, _E, dEle);
			loop++;
			for (int i = 0; i < size; i++)
				pages[i].setRankValue(result[pages[i].getId()]);
			float stability = PageRank.sortAndComputeStability(pages);
			System.out.println("loop " + loop + ", stability:" + stability);
			if (Matrix.absoluteLessThanThreshold(Matrix.minus(result, page), threshold))
				break;
			page = result;
		}
	}

}
