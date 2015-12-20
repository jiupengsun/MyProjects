package com.chinalife.samy.ucr.Comparable;

public class TestTool {
	/**
	 * 
	 * @param times
	 * @return 2015年12月10日
	 * @author Jiupeng
	 * @description caculate the average running time with the following steps: 1.
	 *              count the variance and the standard deviation 2. discard the
	 *              values out of the range (average-standard, average+standard)
	 *              3. count the new average
	 */
	public static double countNewAver(double[] times) {
		double aver = getAverage(times);
		double sd = getStandardDeviation(times);
		double new_aver = 0.0f;
		int length = times.length;
		int nl = 0;
		for (int i = 0; i < length; i++) {
			if (times[i] >= aver - sd && times[i] <= aver + sd) {
				new_aver += times[i];
				nl++;
			}
		}
		return new_aver / nl;
	}

	private static double getAverage(double[] times) {
		double sum = 0.0;
		for (double d : times)
			sum += d;
		return sum / times.length;
	}

	private static double getVariance(double[] times) {
		double var = 0.0;
		double aver = getAverage(times);
		for (double d : times) {
			var += Math.pow(d - aver, 2);
		}
		return var / times.length;
	}

	private static double getStandardDeviation(double[] times) {
		return Math.sqrt(getVariance(times));
	}
}
