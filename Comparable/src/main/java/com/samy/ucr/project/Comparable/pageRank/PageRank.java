package com.samy.ucr.project.Comparable.pageRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		int max_times = length * (length - 1) / 2;
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
	 * @param outputFile
	 *          2015年12月30日
	 * @author Jiupeng
	 * @description Load data file, then compute the rank of page and output the
	 *              results in specific file
	 */
	public static void computeRank(String dataFile, String outputFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dataFile));
		String path = System.getProperty("user.dir") + "\\tmp\\";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path + "data1"));
		String line = "";
		String regex = "[ \t]+";
		int mapMaxLength = 5000;
		Map<Integer, List<Integer>> nodeMap = new HashMap<Integer, List<Integer>>(mapMaxLength);
		while ((line = br.readLine().trim()) != null) {
			if (line.startsWith("#"))
				continue;// # means comment
			String[] ss = line.split(regex);
			int nodeId = Integer.parseInt(ss[0]);
			int edge = Integer.parseInt(ss[1]);
			if (nodeMap.size() < mapMaxLength) {
				// put in
				if (nodeMap.containsKey(nodeId)) {
					nodeMap.get(nodeId).add(edge);
				} else {
					List<Integer> al = new ArrayList<Integer>();
					al.add(edge);
					nodeMap.put(nodeId, al);
				}
			} else {
				// output to file

			}

		}
	}

	private void test() throws IOException {
		BufferedReader graphbr = new BufferedReader(new FileReader("aaa"));
		BufferedReader probbr = new BufferedReader(new FileReader("bbb"));

		int mapMaxLength = 5000;
		// read file of probability
		Map<Integer, Float> probMap = new HashMap<Integer, Float>(mapMaxLength);
		String line = "";
		String regex = "[ \t]+";
		while ((line = probbr.readLine().trim()) != null && probMap.size() <= mapMaxLength) {
			String[] ss = line.split(regex);
			int nodeid = Integer.parseInt(ss[0]);
			float rank = Float.parseFloat(ss[1]);
			probMap.put(nodeid, rank);
		}

		// read file of graphbr
		Map<Integer, List<Integer>> nodeMap = new HashMap<Integer, List<Integer>>(mapMaxLength);
		while ((line = graphbr.readLine().trim()) != null && nodeMap.size() <= mapMaxLength) {
			String[] ss = line.split(regex);
			int nodeId = Integer.parseInt(ss[0]);
			int edge = Integer.parseInt(ss[1]);
			if (nodeMap.containsKey(nodeId)) {
				nodeMap.get(nodeId).add(edge);
			} else {
				List<Integer> al = new ArrayList<Integer>();
				al.add(edge);
				nodeMap.put(nodeId, al);
			}
		}

		// match

	}
}
