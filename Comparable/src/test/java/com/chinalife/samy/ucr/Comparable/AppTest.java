package com.chinalife.samy.ucr.Comparable;

import java.util.Arrays;

import com.chinalife.samy.ucr.Comparable.math.BigInteger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 * 
 * @author Jiupeng
 * @description: this testcase is to test the
 *               com.chinalife.samy.ucr.Comparable.math.BigInteger this
 *               BigInteger use the original compareTo method
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *          name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppExTest.class);
	}

	/**
	 * Rigourous Test :-) The running time of this average time is 3*10^7 nano
	 * seconds
	 */
	public void testApp() {
		// assertTrue( true );
		int maxNumBits = (int) Math.pow(2, 15);
		// average running time
		double aver_time = 0.0;
		// total running times
		int running_time = 30;
		for (int i = 0; i < running_time; i++) {
			// generate a random BigInteger array, but each number has the same high
			// order
			BigInteger[] bia = App.getRandomBigIntegerWithSameHigherOrder(
					(int) Math.round(maxNumBits * 0.99),
					(int) Math.floor(maxNumBits * 0.01), 100);
			long start = System.nanoTime();
			Arrays.sort(bia, 0, bia.length);
			long end = System.nanoTime();
			aver_time += end - start;
		}
		System.out.println(aver_time / running_time);
	}
}
