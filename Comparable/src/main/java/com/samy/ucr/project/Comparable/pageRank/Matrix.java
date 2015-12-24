package com.samy.ucr.project.Comparable.pageRank;

public class Matrix {

	public static float[][] multiply(float[][] m1, float[][] m2) {
		if (m1[0].length != m2.length)
			return null;
		int row = m1.length;
		int col = m2[0].length;
		float[][] matrix = new float[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				float sum = 0.0f;
				for (int k = 0; k < m1[0].length; k++)
					sum += m1[i][k] * m2[k][j];
				matrix[i][j] = sum;
			}
		return matrix;
	}

	public static float[] multiply(float[][] m1, float[] m2) {
		if (m1[0].length != m2.length)
			return null;
		int row = m1.length;
		float[] matrix = new float[row];
		for (int i = 0; i < row; i++) {
			float sum = 0.0f;
			for (int j = 0; j < m2.length; j++) {
				sum += m1[i][j] * m2[j];
			}
			matrix[i] = sum;
		}
		return matrix;
	}

	public static float[] multiply(float[] m1, float a) {
		int row = m1.length;
		float[] matrix = new float[row];
		for (int i = 0; i < row; i++)
			matrix[i] = m1[i] * a;
		return matrix;
	}

	public static float[][] minus(float[][] m1, float[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			return null;
		int row = m1.length;
		int col = m1[0].length;
		float[][] matrix = new float[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix[i][j] = m1[i][j] - m2[i][j];
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

	public static float[] add(float[] m1, float[] m2) {
		if (m1.length != m2.length)
			return null;
		int row = m1.length;
		float[] matrix = new float[row];
		for (int i = 0; i < row; i++)
			matrix[i] = m1[i] + m2[i];
		return matrix;
	}

	public static boolean absoluteLessThanThreshold(float[][] m1, float threshold) {
		int row = m1.length;
		int col = m1[0].length;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (Math.abs(m1[i][j]) > threshold)
					return false;
		return true;
	}

	public static boolean absoluteLessThanThreshold(float[] m1, float threshold) {
		int row = m1.length;
		for (int i = 0; i < row; i++)
			if (Math.abs(m1[i]) > threshold)
				return false;
		return true;
	}

	public static void printMatrix(float[][] m1) {
		int row = m1.length;
		int col = m1[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(m1[i][j] + " ");
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

	public static void printMatrix(float[] m1) {
		int row = m1.length;
		for (int i = 0; i < row; i++)
			System.out.print(m1[i] + " ");
		System.out.println();
	}

}