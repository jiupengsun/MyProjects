package com.samy.leetcode.algorithm;

public class AddBinary {

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * 2016Äê1ÔÂ20ÈÕ
	 * @author Jiupeng
	 * @description 294 test cases, 3ms beats 91.28%
	 * @reference https://leetcode.com/problems/add-binary/
	 */
	public String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			// ensure a has the larger size
			String c = b;
			b = a;
			a = c;
		}
		int la = a.length(), lb = b.length(), l = a.length() + 1, i, j, k,
				carry = 0;
		int[] bi = new int[l];
		char ca, cb;
		for (i = la - 1, j = lb - 1, k = l - 1; i >= 0 && j >= 0; --i, --j, --k) {
			ca = a.charAt(i);
			cb = b.charAt(j);
			if (ca == cb)
				bi[k] = 2 * (ca - 48) + carry;
			else
				bi[k] = carry + 1;
			carry = bi[k] >> 1;
			bi[k] %= 2;
		}
		while (i >= 0) {
			bi[k] = a.charAt(i--) - 48 + carry;
			carry = bi[k] >> 1;
			bi[k--] %= 2;
		}
		bi[0] = carry;
		i = 0;
		while (i < l - 1 && bi[i] == 0)
			++i;
		StringBuilder sb = new StringBuilder();
		for (; i < l; ++i) {
			sb.append(bi[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = { ' ', '0', '1' };
		//char[] c = new char[3];
		System.out.println(String.valueOf(c));
	}

}
