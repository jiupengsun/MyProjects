package com.samy.ucr.project.Comparable.pageRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.chinalife.samy.ucr.Comparable.load.LoadData;

public class PageRank {

	/**
	 * 
	 * @param size
	 * @param weight
	 * @return 2015年12月24日
	 * @author Jiupeng
	 * @description Generate a randomly connected graph
	 */
	public static int[][] randomConnectedGraph(int size, double weight) {
		// calculate the new weight
		if (weight < 0 || weight > 1.0 || size < 0)
			return null;
		weight = (double) (size * (size - 1) * weight) / (size * size);
		// generate a directed connected graph
		int[][] transform = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (j != (i + 1) % size)
					transform[i][j] = (int) Math.round(weight / 0.5 * Math.random());
				else
					transform[i][j] = 1;
			}
		return transform;
	}

	/**
	 * 
	 * @param connM
	 * @return 2015年12月24日
	 * @author Jiupeng
	 * @description Generate a transform matrix according to the connected graph
	 */
	public static double[][] transformMatrix(int[][] connM) {
		int row = connM.length;
		int col = connM[0].length;
		double[][] transform = new double[row][col];
		for (int j = 0; j < col; j++) {
			int sum = 0;
			for (int i = 0; i < row; i++)
				if (connM[i][j] > 0.99)
					sum++;
			if (sum > 0)
				for (int i = 0; i < row; i++)
					if (connM[i][j] > 0.99)
						transform[i][j] = 1d / sum;
		}
		return transform;
	}

	/**
	 * 
	 * @param transform
	 * @param _V
	 * @param _E
	 * @param dV
	 * @return 2015年12月24日
	 * @author Jiupeng
	 * @description V' = aMV + (1-a)e
	 */
	public static double[] computeRank(double[][] transform, double[] _V, double[] _E, double dV) {
		return Matrix.add(Matrix.multiply(Matrix.multiply(transform, _V), dV), Matrix.multiply(_E, 1 - dV));
	}

	/**
	 * 
	 * @param pages
	 * @return 2015年12月24日
	 * @author Jiupeng
	 * @description sort the array of Page, and return the stability. Bubble sort
	 *              | desc
	 */
	public static double sortAndComputeStability(Page[] pages) {
		int times = 0;
		int length = pages.length;
		long max_times = length * (length - 1) / 2;
		for (int i = length - 1; i >= 1; i--)
			for (int j = 0; j < i; j++)
				if (pages[j].compareTo(pages[j + 1]) < 0) {
					Page p = pages[j];
					pages[j] = pages[j + 1];
					pages[j + 1] = p;
					times++;
				}
		return (double) times / max_times;
	}

	/**
	 * 
	 * @param dataFile
	 * @param rankFile
	 *          2015年12月30日
	 * @author Jiupeng
	 * @description Load data file, then compute the rank of page and output the
	 *              results in specific file
	 */
	public static void computeRank(String dataFile, String rankFile, float dFactor, float E, float threshold)
			throws IOException {
		// create rankFile
		Map<Integer, List<Integer>> mapNodeGraph = LoadData.getInstance().loadNodeGraph(dataFile);
		Map<Integer, Float> mapNodeRank = new HashMap<Integer, Float>(mapNodeGraph.size());
		Map<Integer, Float> mapNodeRankTmp = new HashMap<Integer, Float>(mapNodeGraph.size());
		int loop = 0;
		while (copyAndCompare(mapNodeRank, mapNodeRankTmp) > threshold) {
			// continue to the next loop
			mapNodeRankTmp.clear();
			loop++;
			Iterator<Integer> it = mapNodeGraph.keySet().iterator();
			// compute the temp rank
			while (it.hasNext()) {
				int nodeid = it.next();
				List<Integer> edges = mapNodeGraph.get(nodeid);
				mapNodeRankTmp.put(nodeid, 0f);
				int s = edges.size();
				for (int i = 0; i < s; i++) {
					int eid = edges.get(i);
					float weight = mapNodeRank.get(nodeid) == null ? E : mapNodeRank.get(nodeid);
					if (mapNodeRankTmp.containsKey(eid)) {
						mapNodeRankTmp.put(eid, mapNodeRankTmp.get(eid) + weight / s);
					} else
						mapNodeRankTmp.put(eid, weight / s);
				}
			}
			// aMV + (1-a)E
			it = mapNodeRankTmp.keySet().iterator();
			while (it.hasNext()) {
				int nodeid = it.next();
				mapNodeRankTmp.put(nodeid, dFactor * mapNodeRankTmp.get(nodeid) + (1 - dFactor) * E);
			}
		}

		// output the pageRank File
		System.out.println(loop);
	}

	/**
	 * 
	 * @param o
	 * @param r
	 * @return 2015年12月31日
	 * @author Jiupeng
	 * @description Compare the two map, and return the max difference between
	 *              each value, copy r -> o
	 * @reference
	 */
	private static float copyAndCompare(Map<Integer, Float> o, Map<Integer, Float> r) {
		if (o.isEmpty() && r.isEmpty())
			return Float.MAX_VALUE;
		float maxDiff = 0f;
		Iterator<Integer> it = r.keySet().iterator();
		while (it.hasNext()) {
			int nid = it.next();
			float o_rank = o.get(nid) == null ? 0f : o.get(nid);
			float r_rank = r.get(nid);
			maxDiff = maxDiff > Math.abs(o_rank - r_rank) ? maxDiff : Math.abs(o_rank - r_rank);
			o.put(nid, r_rank);
		}
		return maxDiff;
	}

	/**
	 * 
	 * @param dataFile
	 * @param rankFile
	 * @param dFactor
	 * @param E
	 *          2015年12月31日
	 * @author Jiupeng
	 * @throws IOException
	 * @description
	 * @reference
	 */
	public static Page[] computeRank(Map<Integer, List<Integer>> mapNodeGraph, Page[] pages, float dFactor, float E)
			throws IOException {
		Map<Integer, Float> mapNodeRank = new HashMap<Integer, Float>(mapNodeGraph.size());
		Map<Integer, Float> mapNodeRankTmp = new HashMap<Integer, Float>(mapNodeGraph.size());
		int i = 0, length = 0;
		// transform array of page rank to map, in case of using it more
		// conviniently
		if (pages != null && (length = pages.length) > 0)
			for (; i < length; i++) {
				mapNodeRank.put(pages[i].getId(), pages[i].getRankValue());
			}
		Iterator<Integer> it = mapNodeGraph.keySet().iterator();
		while (it.hasNext()) {
			int nodeid = it.next();
			List<Integer> edges = mapNodeGraph.get(nodeid);
			mapNodeRankTmp.put(nodeid, 0f);
			int s = edges.size();
			for (i = 0; i < s; i++) {
				int eid = edges.get(i);
				float weight = mapNodeRank.get(nodeid) != null ? mapNodeRank.get(nodeid) : E;
				if (mapNodeRankTmp.containsKey(eid)) {
					mapNodeRankTmp.put(eid, mapNodeRankTmp.get(eid) + weight / s);
				} else
					mapNodeRankTmp.put(eid, weight / s);
			}
		}
		mapNodeRank.clear();
		mapNodeRank = null;
		// aMV + (1-a)E
		Page[] newPages = new Page[mapNodeRankTmp.size()];
		i = 0;
		if (length > 0) {
			for (; i < length; i++) {
				int nodeid = pages[i].getId();
				newPages[i] = new Page(nodeid);
				newPages[i].setRankValue(mapNodeRankTmp.get(nodeid));
			}
		} else {
			// the first time of loop
			it = mapNodeRankTmp.keySet().iterator();
			while (it.hasNext()) {
				int nodeid = it.next();
				newPages[i] = new Page(nodeid);
				newPages[i++].setRankValue(dFactor * mapNodeRankTmp.get(nodeid) + (1 - dFactor) * E);
			}
		}

		return newPages;
	}

	/**
	 * 
	 * @param o
	 * @param r
	 * @return 2015年12月31日
	 * @author Jiupeng
	 * @description Compare each element in two arrays, and return the max
	 *              difference
	 * @reference
	 */
	public static float compareMaxDiff(Page[] o, Page[] r) {
		if (o == null || r == null || o.length != r.length)
			return Float.MAX_VALUE;
		float max = 0f;
		int length = o.length;
		for (int i = 0; i < length; i++) {
			float diff = Math.abs(o[i].getRankValue() - r[i].getRankValue());
			max = max > diff ? max : diff;
		}
		return max;
	}

}
