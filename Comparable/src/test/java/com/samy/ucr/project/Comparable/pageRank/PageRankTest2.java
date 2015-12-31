package com.samy.ucr.project.Comparable.pageRank;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.chinalife.samy.ucr.Comparable.load.LoadData;

public class PageRankTest2 {

	// @Test
	public void test1() {
		float threshold = 0.001f;
		float dFactor = 0.8f;
		float E = 1f;

		String file = System.getProperty("user.dir")
				.concat("\\dataset\\Wiki-Vote.txt");

		try {
			PageRank.computeRank(file, "", dFactor, E, threshold);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test() {
		float threshold = 0.00001f;
		float dFactor = 0.8f;
		float E = 1f;

		String file = System.getProperty("user.dir")
				.concat("\\dataset\\Wiki-Vote.txt");

		try {
			Map<Integer, List<Integer>> mapNodeGraph = LoadData.getInstance()
					.loadNodeGraph(file);
			Page[] pages = null, newPages = null;
			int loop = 0;
			while (true) {
				loop++;
				long computeStartTag = System.currentTimeMillis();
				newPages = PageRank.computeRank(mapNodeGraph, pages, dFactor, E);
				long computeEndTag = System.currentTimeMillis();
				double stability = PageRank.sortAndComputeStability(newPages);
				long sortEndTag = System.currentTimeMillis();
				System.out.println("Loop:" + loop + " Stability:" + stability
						+ " Compute time:" + (computeEndTag - computeStartTag) + "ms"
						+ " Sort time:" + (sortEndTag - computeEndTag) + "ms");
				if ((PageRank.compareMaxDiff(pages, newPages) < threshold))
					break;
				pages = newPages;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
