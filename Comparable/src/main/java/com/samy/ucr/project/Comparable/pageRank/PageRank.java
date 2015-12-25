package com.samy.ucr.project.Comparable.pageRank;

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
}
