package com.samy.ucr.project.Comparable.pageRank;

public class Matrix {

	public static double[][] multiply(double[][] m1, double[][] m2) {
		if (m1[0].length != m2.length)
			return null;
		int row = m1.length;
		int col = m2[0].length;
		double[][] matrix = new double[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				double sum = 0.0f;
				for (int k = 0; k < m1[0].length; k++)
					sum += m1[i][k] * m2[k][j];
				matrix[i][j] = sum;
			}
		return matrix;
	}

	public static double[] multiply(double[][] m1, double[] m2) {
		if (m1[0].length != m2.length)
			return null;
		int row = m1.length;
		double[] matrix = new double[row];
		for (int i = 0; i < row; i++) {
			double sum = 0.0f;
			for (int j = 0; j < m2.length; j++) {
				sum += m1[i][j] * m2[j];
			}
			matrix[i] = sum;
		}
		return matrix;
	}

	public static double[] multiply(double[] m1, double a) {
		int row = m1.length;
		double[] matrix = new double[row];
		for (int i = 0; i < row; i++)
			matrix[i] = m1[i] * a;
		return matrix;
	}

	public static double[][] minus(double[][] m1, double[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			return null;
		int row = m1.length;
		int col = m1[0].length;
		double[][] matrix = new double[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix[i][j] = m1[i][j] - m2[i][j];
		return matrix;
	}

	public static double[] minus(double[] m1, double[] m2) {
		if (m1.length != m2.length)
			return null;
		int row = m1.length;
		double[] matrix = new double[row];
		for (int i = 0; i < row; i++)
			matrix[i] = m1[i] - m2[i];
		return matrix;
	}

	public static float[] minus(float[] m1, float[] m2) {
		if (m1.length != m2.length)
			return null;
		int row = m1.length;
		float[] matrix = new float[row];
		for (int i = 0; i < row; i++)
			matrix[i] = m1[i] - m2[i];
		return matrix;
	}

	public static double[] add(double[] m1, double[] m2) {
		if (m1.length != m2.length)
			return null;
		int row = m1.length;
		double[] matrix = new double[row];
		for (int i = 0; i < row; i++)
			matrix[i] = m1[i] + m2[i];
		return matrix;
	}

	/**
	 * 
	 * @param m
	 * @return
	 * 2016年1月29日
	 * @author Jiupeng
	 * @description Get the L1-Normal of two-dimension matrix m
	 * @reference
	 */
	public static float L1_normalization(float[][] m) {
		float max = Float.MIN_VALUE;
		int row = m.length;
		int col = row > 0 ? m[0].length : 0;
		for (int i, j = 0, sum; j < col; ++j) {
			for (i = 0, sum = 0; i < row; ++i)
				sum += Math.abs(m[i][j]);
			if (sum > max)
				max = sum;
		}
		return max;
	}

	/**
	 * 
	 * @param m
	 * @return
	 * 2016年1月29日
	 * @author Jiupeng
	 * @description Get the L1-Normal of column vector
	 * @reference
	 */
	public static float L1_normalization(float[] m) {
		float sum = 0f;
		int row = m.length;
		for (int i = 0; i < row; ++i) {
			sum += Math.abs(m[i]);
		}
		return sum;
	}

	public static boolean absoluteLessThanThreshold(double[][] m1,
			double threshold) {
		int row = m1.length;
		int col = m1[0].length;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (Math.abs(m1[i][j]) > threshold)
					return false;
		return true;
	}

	public static boolean absoluteLessThanThreshold(double[] m1,
			double threshold) {
		int row = m1.length;
		for (int i = 0; i < row; i++)
			if (Math.abs(m1[i]) > threshold)
				return false;
		return true;
	}

	public static void printMatrix(double[][] m1) {
		int row = m1.length;
		int col = m1[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(m1[i][j] + " ");
			System.out.println();
		}
	}

	public static void printMatrixToRoundInt(double[][] m) {
		int row = m.length;
		int col = m[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(Math.round(m[i][j]) + " ");
			System.out.println();
		}
	}

	public static void printMatrix(int[][] m1) {
		int row = m1.length;
		int col = m1[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(m1[i][j] + " ");
			System.out.println();
		}
	}

	public static void printMatrix(double[] m1) {
		int row = m1.length;
		for (int i = 0; i < row; i++)
			System.out.print(m1[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		double[][] M = { { 0.4435, 0.0619, 0.0619 }, { 0.0619, 0.4435, 0.0619 },
				{ 0.0619, 0.0619, 0.4435 } };
		double[][] X = { { 0.9067, 0.9067, 3.5211, 3.5211, 6.1482, 6.1482 },
				{ 3.5211, 6.1482, 0.9067, 6.1482, 0.9067, 3.5211 },
				{ 6.1482, 3.5211, 6.1482, 0.9067, 3.5211, 0.9067 } };
		printMatrixToRoundInt(multiply(M, X));
	}

}
