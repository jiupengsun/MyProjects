package com.samy.ucr.project.Comparable.pageRank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
	private Page[] generate(Map<Integer, List<Integer>> graph, float E) {
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
		E /= pages.length;
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
		float diffThreshold = 1f;
		float dFactor = 0.85f;
		float E = 1f;
		Page[] pages = null, newPages = null;

		try {
			Map<Integer, List<Integer>> mapNodeGraph = LoadData.getInstance()
					.loadNodeGraph(file);
			pages = generate(mapNodeGraph, E);
			E = E / pages.length;
			diffThreshold = threshold;
			//
			int loop = 0;
			while (true) {
				loop++;
				long computeStartTag = System.currentTimeMillis();
				newPages = PageRank.computeRank(mapNodeGraph, pages, dFactor, E,
						diffThreshold);
				long computeEndTag = System.currentTimeMillis();
				//float averDiff = PageRank.compareAverDiff(pages, newPages);
				//float maxDiff = PageRank.compareMaxDiff(pages, newPages);
				float normal = Matrix
						.L1_normalization(PageRank.compareDiff(pages, newPages));
				pages = newPages;
				System.out.println("Loop:" + loop + " Computing time:"
						+ (computeEndTag - computeStartTag) + "ms");
				if (normal < threshold)
					break;
			}

			//output convert times to file
			//times rankValue
			Arrays.sort(pages);
			Map<Integer, Float> averConvert = PageRank
					.computeAverConvergeTimes(pages);
			output(file, averConvert);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void output(String file, Map<Integer, Float> map) {
		Iterator<Integer> it = map.keySet().iterator();
		File f = new File(file);
		String outputFile = f.getParent() + "\\" + f.getName() + "_output.txt";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(outputFile));
			while (it.hasNext()) {
				int times = it.next();
				pw.println(times + "\t" + map.get(times));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
				pw = null;
			}
		}
	}

	private void output(String file, Page[] n) {
		File f = new File(file);
		String outputFile = f.getParent() + "\\" + f.getName() + "_output.txt";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(outputFile));
			for (Page p : n) {
				pw.println(p.getConvertTimes() + "\t" + p.getRankValue());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
				pw = null;
			}
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
