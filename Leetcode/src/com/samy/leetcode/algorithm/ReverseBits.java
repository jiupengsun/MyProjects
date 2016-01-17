package com.samy.leetcode.algorithm;

public class ReverseBits {

	private final int high_hex = 0xFFFF0000;
	private final int low_hex = 0x0000FFFF;
	private final int high_oct = 0xFF00FF00;
	private final int low_oct = 0x00FF00FF;
	private final int high_qua = 0xF0F0F0F0;
	private final int low_qua = 0x0F0F0F0F;
	private final int high_bin = 0xCCCCCCCC;
	private final int low_bin = 0x33333333;
	private final int high_byte = 0xAAAAAAAA;
	private final int low_byte = 0x55555555;

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description 2ms
	 * @reference https://leetcode.com/problems/reverse-bits/
	 */
	//you need treat n as an unsigned value
	public int reverseBits(int n) {
		n = (n & low_hex) << 16 | (n & high_hex) >>> 16;
		n = (n & low_oct) << 8 | (n & high_oct) >>> 8;
		n = (n & low_qua) << 4 | (n & high_qua) >>> 4;
		n = (n & low_bin) << 2 | (n & high_bin) >>> 2;
		n = (n & low_byte) << 1 | (n & high_byte) >>> 1;
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits r = new ReverseBits();
		int n = 1;
		n = r.reverseBits(n);
		System.out.println(n);
	}

}
