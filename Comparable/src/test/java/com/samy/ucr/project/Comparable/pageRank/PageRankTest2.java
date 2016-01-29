package com.samy.ucr.project.Comparable.pageRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.samy.ucr.project.Comparable.pageRank.load.LoadData;

public class PageRankTest2 {

	/**
	 * 
	 * @param graph
	 * @return
	 * 2016年1月29日
	 * @author Jiupeng
	 * @description convert web graph to a initiate page array
	 * @reference
	 */
	private Page[] generate(Map<Integer, List<Integer>> graph) {
		Iterator<Integer> it = graph.keySet().iterator();
		Page[] pages = null;
		// initiate the origin page array
		Map<Integer, Page> mapTmp = new HashMap<Integer, Page>();
		while (it.hasNext()) {
			int id = it.next();
			if (!mapTmp.containsKey(id)) {
				mapTmp.put(id, new Page(id));
			}
			List<Integer> list = graph.get(id);
			for (int i : list) {
				if (!mapTmp.containsKey(i)) {
					mapTmp.put(i, new Page(i));
				}
			}
		}
		pages = new Page[mapTmp.size()];
		float E = 1 / mapTmp.size();
		int i = 0;
		it = mapTmp.keySet().iterator();
		while (it.hasNext()) {
			int id = it.next();
			pages[i] = new Page(id);
			pages[i++].setRankValue(E);
		}
		mapTmp.clear();
		mapTmp = null;
		return pages;
	}

	/**
	 * 
	 * @param file
	 * 2016年1月29日
	 * @author Jiupeng
	 * @description load web node files and compute the page rank
	 * @reference
	 */
	private void loadAndCompute(String file) {
		float threshold = 0.0001f;
		float dFactor = 0.85f;
		float E = 1f;
		Page[] pages = null, newPages = null;

		try {
			Map<Integer, List<Integer>> mapNodeGraph = LoadData.getInstance()
					.loadNodeGraph(file);
			pages = generate(mapNodeGraph);
			E = E / pages.length;
			//
			int loop = 0;
			while (true) {
				loop++;
				long computeStartTag = System.currentTimeMillis();
				newPages = PageRank.computeRank(mapNodeGraph, pages, dFactor, E);
				long computeEndTag = System.currentTimeMillis();
				//float averDiff = PageRank.compareAverDiff(pages, newPages);
				float normal = Matrix
						.L1_normalization(PageRank.compareDiff(pages, newPages));
				/*System.out.println("Loop:" + loop + " Stability:" + stability
						+ " Average Diff:" + averDiff);*/
				pages = newPages;
				long sortStartTag = System.currentTimeMillis();
				//Arrays.sort(pages);
				long sortEndTag = System.currentTimeMillis();
				System.out.println("Loop:" + loop + " Computing time:"
						+ (computeEndTag - computeStartTag) + "ms" + " Sort time:"
						+ (sortEndTag - sortStartTag) + "ms");
				if (normal < threshold)
					break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//@Test
	public void testWiki() {

		String file = System.getProperty("user.dir")
				.concat("\\dataset\\Wiki-vote.txt");
		loadAndCompute(file);
	}

	@Test
	public void testStanford() {
		String file = System.getProperty("user.dir")
				.concat("\\dataset\\web-Stanford.txt");

		loadAndCompute(file);
	}

}
