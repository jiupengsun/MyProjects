package com.samy.ucr.project.Comparable.pageRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.samy.ucr.project.Comparable.pageRank.load.LoadData;

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
	public static double[] computeRank(double[][] transform, double[] _V,
			double[] _E, double dV) {
		return Matrix.add(Matrix.multiply(Matrix.multiply(transform, _V), dV),
				Matrix.multiply(_E, 1 - dV));
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
	 * @param pages
	 * @return
	 * 2016年1月11日
	 * @author Jiupeng
	 * @description Sort the array, and compute the K-T distance
	 * @reference
	 */
	public static int sortAndComputeKTDistance(Page[] pages) {
		int times = 0;
		int length = pages.length;
		for (int i = length - 1; i >= 1; i--)
			for (int j = 0; j < i; j++)
				if (pages[j].compareTo(pages[j + 1]) < 0) {
					Page p = pages[j];
					pages[j] = pages[j + 1];
					pages[j + 1] = p;
					times++;
				}
		return times;
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
	public static void computeRank(String dataFile, String rankFile,
			float dFactor, float E, float threshold) throws IOException {
		// create rankFile
		Map<Integer, List<Integer>> mapNodeGraph = LoadData.getInstance()
				.loadNodeGraph(dataFile);
		Map<Integer, Float> mapNodeRank = new HashMap<Integer, Float>(
				mapNodeGraph.size());
		Map<Integer, Float> mapNodeRankTmp = new HashMap<Integer, Float>(
				mapNodeGraph.size());
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
					float weight = mapNodeRank.get(nodeid) == null ? E
							: mapNodeRank.get(nodeid);
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
				mapNodeRankTmp.put(nodeid,
						dFactor * mapNodeRankTmp.get(nodeid) + (1 - dFactor) * E);
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
	private static float copyAndCompare(Map<Integer, Float> o,
			Map<Integer, Float> r) {
		if (o.isEmpty() && r.isEmpty())
			return Float.MAX_VALUE;
		float maxDiff = 0f;
		Iterator<Integer> it = r.keySet().iterator();
		while (it.hasNext()) {
			int nid = it.next();
			float o_rank = o.get(nid) == null ? 0f : o.get(nid);
			float r_rank = r.get(nid);
			maxDiff = maxDiff > Math.abs(o_rank - r_rank) ? maxDiff
					: Math.abs(o_rank - r_rank);
			o.put(nid, r_rank);
		}
		return maxDiff;
	}

	/**
	 * 
	 * @param graph
	 * @param V
	 * @param dFactor
	 * @param E
	 * @param diffThreshold
	 * @return
	 * 2016年1月29日
	 * @author Jiupeng
	 * @description compute new page rank, using sparse matrix, formula: aMV + (1-a)E
	 * @reference
	 */
	public static Page[] computeRank(Map<Integer, List<Integer>> graph, Page[] V,
			float dFactor, float E, float diffThreshold) {
		if (graph.isEmpty() || V.length == 0)
			return null;
		int size = V.length;
		Map<Integer, Float> pages = new HashMap<Integer, Float>(size);
		//compute new page rank and put in map
		for (int i = 0; i < size; ++i) {
			List<Integer> link = graph.get(V[i].getId());
			// exists out link
			if (link != null) {
				float rank = V[i].getRankValue() / link.size();
				for (int id : link) {
					Float tmp = pages.get(id);
					if (tmp == null) {
						// not existed
						pages.put(id, rank);
					} else {
						pages.put(id, tmp + rank);
					}
				}
			}
		}
		//transform the matrix to page array
		Page[] _V = new Page[size];
		for (int i = 0; i < size; ++i) {
			_V[i] = new Page(V[i].getId());
			Float f = pages.get(V[i].getId());
			float rank = f == null ? 0 : f;
			rank = dFactor * rank + (1 - dFactor) * E;
			_V[i].setRankValue(rank);
			if (Math.abs(V[i].getRankValue() - rank) > diffThreshold) {
				_V[i].setConvertTimes(V[i].getConvertTimes() + 1);
			} else
				_V[i].setConvertTimes(V[i].getConvertTimes());
		}
		return _V;
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

	/**
	 * 
	 * @param o
	 * @param r
	 * @return
	 * 2016年1月12日
	 * @author Jiupeng
	 * @description Compare each element in two arrays, and return the aver
	 *              difference
	 * @reference
	 */
	public static float compareAverDiff(Page[] o, Page[] r) {
		if (o == null || r == null || o.length != r.length)
			return Float.MAX_VALUE;
		float aver = 0f;
		int length = o.length;
		for (int i = 0; i < length; ++i) {
			aver += Math.abs(o[i].getRankValue() - r[i].getRankValue());
		}
		return aver / length;
	}

	public static float[] compareDiff(Page[] o, Page[] r) {
		int l = o.length;
		float[] f = new float[l];
		for (int i = 0; i < l; ++i) {
			f[i] = o[i].getRankValue() - r[i].getRankValue();
		}
		return f;
	}

	/**
	 * 
	 * @param p
	 * @return
	 * 2016年2月2日
	 * @author Jiupeng
	 * @description compute average converge times and the correspondent pagerank
	 * @reference 
	 * @interpretation
	 */
	public static Map<Integer, Float> computeAverConvergeTimes(Page[] p) {
		Map<Integer, Float> map = new HashMap<Integer, Float>();
		for (int i = 0, j, l = p.length; i < l; ++i) {
			float r = p[i].getRankValue();
			for (j = i + 1; j < l
					&& p[j].getConvertTimes() == p[j - 1].getConvertTimes(); ++j) {
				r += p[j].getRankValue();
			}
			map.put(p[i].getConvertTimes(), r / (j - i));
			i = j - 1;
		}
		return map;
	}
}
