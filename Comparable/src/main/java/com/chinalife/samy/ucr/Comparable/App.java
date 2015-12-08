package com.chinalife.samy.ucr.Comparable;

import java.util.Random;

import com.chinalife.samy.ucr.Comparable.math.BigInteger;

/**
 * 
 * @author samparly Test the BigInteger
 */
public class App {

	/**
	 * 
	 * @param numBits
	 * @param length
	 * @return 2015年12月8日
	 * @author Jiupeng
	 * @description According to the numBits, return a random BigInteger array
	 *              containing %length% elements.
	 */
	public static BigInteger[] getRandomBigInteger(int numBits, int length) {
		BigInteger[] bia = new BigInteger[length];
		Random rd = new Random(System.nanoTime());
		for (int i = 0; i < length; i++) {
			bia[i] = new BigInteger(numBits, rd);
		}
		return bia;
	}

	/**
	 * 
	 * @param highBits
	 * @param lowBits
	 * @param length
	 * @return 2015年12月8日
	 * @author Jiupeng
	 * @description Return a random BigInteger array containing %length% elements.
	 *              Each of the number starts with the same high order with high
	 *              bits, and different low order with low bits
	 */
	public static BigInteger[] getRandomBigIntegerWithSameHigherOrder(
			int highBits, int lowBits, int length) {
		BigInteger hOrder = new BigInteger(highBits, new Random());
		hOrder = hOrder.shiftLeft(lowBits);
		BigInteger[] bia = getRandomBigInteger(lowBits, length);
		for (int i = 0; i < length; i++) {
			bia[i] = hOrder.add(bia[i]);
		}
		return bia;
	}
}
