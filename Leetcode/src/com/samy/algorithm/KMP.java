package com.samy.algorithm;

public class KMP {

	public int subString(String target, String match) {
		int lt = target.length(), lm = match.length();
		if (lt < lm)
			return -1;
		if (lm == 0)
			return 0;
		int m = 0, i = 0;
		int[] table = new int[lm];
		partialTable(match, table);
		while (m + i < lt) {
			if (target.charAt(m + i) == match.charAt(i)) {
				if (i == lm - 1)
					return m;
				++i;
			} else if (table[i] > -1) {
				// compare with new start 
				// start from table[i]
				// so the new m should be m+i, then back slide with table[i] characters
				m = m + i - table[i];
				i = table[i];
			} else {
				++m;
				i = 0;
			}
		}
		return -1;
	}

	private void partialTable(String s, int[] table) {
		int l = s.length();
		// set sentinel
		table[0] = -1;
		int cand = 0, i = 2;
		while (i < l) {
			if (s.charAt(cand) == s.charAt(i - 1))
				table[i++] = ++cand;
			else if (cand > 0)
				// backtracking
				cand = table[cand];
			else
				table[i++] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target = "ABC ABCDAB ABCDABCDABDE";
		String match = "ABCDABD";
		KMP kmp = new KMP();
		System.out.println(kmp.subString(target, match));
	}

}
