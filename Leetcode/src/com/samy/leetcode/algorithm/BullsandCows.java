package com.samy.leetcode.algorithm;

public class BullsandCows {

	/**
	 * 
	 * @param secret
	 * @param guess
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description 151 test cases, 4ms beats 66.93%
	 * @reference https://leetcode.com/problems/bulls-and-cows/
	 */
	public String getHint(String secret, String guess) {
		byte[] nums1 = new byte[10];
		byte[] nums2 = new byte[10];
		int A = 0, B = 0;
		char c1, c2;
		for (int i = 0, l = secret.length(); i < l; ++i) {
			c1 = secret.charAt(i);
			c2 = guess.charAt(i);
			if (c1 == c2)
				++A;
			else {
				++nums1[c1 - 48];
				++nums2[c2 - 48];
			}
		}
		for (int i = 0; i < 10; ++i) {
			B += Math.min(nums1[i], nums2[i]);
		}
		return String.valueOf(A + "A" + B + "B");
	}

	/**
	 * 
	 * @param secret
	 * @param guess
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/discuss/79935/easy-java-solution
	 */
	public String getHintSample(String secret, String guess) {
		int bull = 0, cow = 0;
		int[] array = new int[10];

		for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) {
				bull++;
			} else {
				if (array[s - '0'] < 0) {
					cow++;
				}
				array[s - '0']++;

				if (array[g - '0'] > 0) {
					cow++;
				}
				array[g - '0']--;
			}
		}
		return bull + "A" + cow + "B";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
