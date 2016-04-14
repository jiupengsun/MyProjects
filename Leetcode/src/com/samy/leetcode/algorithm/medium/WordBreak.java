package com.samy.leetcode.algorithm.medium;

import java.util.Set;

public class WordBreak {

	/**
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 * 2016Äê4ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/word-break/
	 * @interpretation
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
		List<Integer[]> pairs = new ArrayList<Integer[]>();
		int l = s.length();
		Iterator<String> words = wordDict.iterator();
		while(words.hasNext()){
			String word = words.next();
			int i=-1,j=-1;
			i = s.indexOf(word);
			j = i+word.length();
			for(int p=0, q=pairs.size(); p<q; ++p){
				int[] pair = pairs.get(p);

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
