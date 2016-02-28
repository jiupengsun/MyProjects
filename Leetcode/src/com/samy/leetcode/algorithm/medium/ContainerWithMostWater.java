package com.samy.leetcode.algorithm.medium;

public class ContainerWithMostWater {

	/**
	 * 
	 * @param height
	 * @return
	 * 2016年2月26日
	 * @author Jiupeng
	 * @description 45 test cases, 5ms beats 71.89%
	 * if we have an array contains n element, [a0,a1,a2....an], and the max area need two elements ai and aj, which i and j between[0,n]
	 * it's certain that one pointer(either head or tail) would move to one of the two elements, and we suppose it's the head tail which
	 * moves to the element i firstly. Then if we could prove the tail pointer would move the element j, then we can assure our algorithm
	 * is correct. Then if the head pointer is locating i, and the tail pointer is pointing k, where k is larger than j. Then the elements
	 * between [j+1, k] must be less than i. Because if there exists one element w between [j+1, k] that it's larger than i, then we know
	 * pair(i,w) would form the larger area than pair(i,j), since the area of pair(i, w) would be height[i]*(w-i), and the maximum area of 
	 * pair(i,j) would be height[i]*(j-i), which is absolutely less than pair(i,w). So there must be not any larger element between [j+1,k]
	 * so the tail pointer would continue moving until to the element j, which means our solution is correct
	 * @reference https://leetcode.com/problems/container-with-most-water/
	 * @interpretation https://leetcode.com/discuss/59635/easy-concise-java-o-n-solution-with-proof-and-explanation
	 */
	public int maxAreaSample(int[] height) {
		int size = height.length, max = 0;
		int i = 0, j = size - 1, h, d;
		while (i < j) {
			d = j - i;
			if (height[i] <= height[j])
				h = height[i++];
			else
				h = height[j--];
			max = Math.max(max, h * d);
		}
		return max;
	}

	private int volume(int[] height, int i, int j) {
		int h = height[i] < height[j] ? height[i] : height[j];
		int l = i > j ? i - j : j - i;
		return h * l;
	}

	/**
	 * 
	 * @param height
	 * @return
	 * 2016年2月28日
	 * @author Jiupeng
	 * @description brute-force attack, o(n^2)
	 * @reference 
	 * @interpretation
	 */
	public int maxAreaSlow(int[] height) {
		int size = height.length, max = 0;
		for (int i = 0; i < size - 1; ++i)
			for (int j = i + 1; j < size; ++j) {
				int v = volume(height, i, j);
				max = v > max ? v : max;
			}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
