package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 22, 2016
	 * @author Jiupeng
	 * @description 30 test cases, 62ms beats 10.06%
	 * @reference https://leetcode.com/problems/repeated-dna-sequences/
	 * @interpretation http://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int l = s.length() - 10, i = 0;
		for (; i <= l; ++i) {
			String t = s.substring(i, i + 10);
			int num = 0;
			for (int j = 0; j < 10; ++j) {
				char c = t.charAt(j);
				switch (c) {
					case 'A':
						num |= 0;
						break;
					case 'C':
						num |= 1;
						break;
					case 'G':
						num |= 2;
						break;
					case 'T':
						num |= 3;
						break;
				}
				num <<= 2;
			}
			Integer n = map.get(num);
			if (n == null)
				n = 0;
			if (n == 1)
				list.add(t);
			map.put(num, n + 1);
		}
		return list;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 22, 2016
	 * @author Jiupeng
	 * @description 30 test cases, 48ms beats 35.25%
	 * @reference 
	 * @interpretation 
	 */
	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> list = new ArrayList<String>();
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int l = s.length(), i = 0;
		if(l <= 10)
			return list;
		String t = s.substring(0, 10);
		int num = 0;
		for(; i<10; ++i){
			char c = t.charAt(i);
			switch (c) {
				case 'A':
					num |= 0;
					break;
				case 'C':
					num |= 1;
					break;
				case 'G':
					num |= 2;
					break;
				case 'T':
					num |= 3;
					break;
			}
			num <<= 2;
		}
		num >>= 2;
		map.put(num, 1);
		for(i=10; i<l; ++i){
			num = (num << 2) & 0xFFFFF;
			char c = s.charAt(i);
			switch (c) {
				case 'A':
					num |= 0;
					break;
				case 'C':
					num |= 1;
					break;
				case 'G':
					num |= 2;
					break;
				case 'T':
					num |= 3;
					break;
			}
			Integer n = map.get(num);
			if(n == null)
				n = 0;
			else if(n == 1)
				list.add(s.substring(i-9, i+1));
			map.put(num, n + 1);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s2 = "ACACACACACAC";
		String s3 = "AAAAAAAAAAA";
		String s4 = "CGACGCAATTTAGAACGGGCCGCACTGCAACCATTGCTCAGACAACGCATGAGTTAAATTTCACAAGTGATAGTGGCTTGCGAGACGTGGGTTGGTGGTAGCGTACGCCCGCTATTCGCCCCTAACGTGACGGGATTATAAGGTCGCTTCCCGGAATGCGCAGACGAGTCTCCGGTTTAGCCTAGACGTCTCACGCGCGCAAGGCGTCAGTTCTCACTATCTCGCACAGGTGTATTCTATTAGTTATGGGTTCTCACTACAGTCGGTTACTTCCTCATCCATTTCTGCATACGGGTCAACTAACAGTGTCATGGGGTATTGGGAAGGATGCGTTTTTAAACCCTCTCAGTAGCGCGAGGATGCCCACAAATACGACGGCGGCCACGGATCTAATGCGAAGCTAGCGACGCTTTCCAGCAACGAGCGCCCCACTTATGACTGCGTGGGGCGCTCCGCTTTCCTAGAGAACATAGATGGTGTTTTCGAATCGTAACCACTTA";
		RepeatedDNASequences rds = new RepeatedDNASequences();
		List<String> list = rds.findRepeatedDnaSequences(s4);
		for (String s : list)
			System.out.print(s + " ");
	}
}
