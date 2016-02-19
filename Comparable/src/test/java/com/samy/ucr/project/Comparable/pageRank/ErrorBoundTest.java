package com.samy.ucr.project.Comparable.pageRank;

import org.junit.Test;

public class ErrorBoundTest {

	public double probability(Page[] ps, float e) {
		double s = 0.0;
		double _2E = 2 * e;
		double _8E2 = 8 * e * e;
		double threshold = 1E-4d;
		int length = ps.length;
		for (int i = 0; i < length - 1; ++i)
			for (int j = i + 1; j < length; ++j) {
				float d = Math.abs(ps[i].getRankValue() - ps[j].getRankValue());
				if (d > 2 * e + threshold)
					continue;
				double p = (double) (d - _2E) * (d - _2E) / _8E2;
				s += p;
			}
		return 2 * s / (length * (length - 1));
	}

	public int EstimateKTD(Page[] ps, float e) {
		float s = 0.0f;
		double _2E = 2 * e;
		double _8E2 = 8 * e * e;
		double threshold = 1E-4d;
		int length = ps.length;
		for (int i = 0; i < length - 1; ++i)
			for (int j = i + 1; j < length; ++j) {
				float d = Math.abs(ps[i].getRankValue() - ps[j].getRankValue());
				if (d > 2 * e + threshold)
					continue;
				double p = (double) (d - _2E) * (d - _2E) / _8E2;
				s += p;
			}
		return Math.round(s);
	}

	public int EstimateKTD(float[] nums, float e) {
		float s = 0.0f;
		float _2E = 2 * e;
		float _8E2 = 8 * e * e;
		float threshold = 1E-4f;
		int length = nums.length;
		for (int i = 0; i < length - 1; ++i)
			for (int j = i + 1; j < length; ++j) {
				float d = Math.abs(nums[i] - nums[j]);
				if (d > 2 * e + threshold)
					continue;
				float p = (d - _2E) * (d - _2E) / _8E2;
				s += p;
			}
		return Math.round(s);
	}

	public int sortAndComputeKTD(float[] nums) {
		int times = 0;
		int length = nums.length;
		for (int i = length - 1; i >= 1; --i)
			for (int j = 0; j < i; j++)
				if (nums[j] < nums[j + 1]) {
					float tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
					++times;
				}
		return times;
	}

	public float errorneous(float e) {
		double r = Math.random();
		double s = Math.round(Math.random());
		e *= r;
		return s > 0.5 ? e : -e;
	}

	public void test() {
		ErrorBoundTest ebt = new ErrorBoundTest();
		/*
		 * initiate a Page array in a desc order
		 * 
		 */
		int length = 1000;
		float d = 1f;
		float e = 0.5f;
		float aver = 0f;
		Page[] ps = new Page[length];
		for (int i = 0; i < length; i++) {
			ps[i] = new Page(i);
			ps[i].setRankValue(length - (i + 1) * d);
		}

		int loop = 1;
		while (loop <= 100) {
			int es = ebt.EstimateKTD(ps, e);
			// recreate each value of page
			for (int i = 0; i < length; i++) {
				ps[i].setRankValue(ps[i].getRankValue() + ebt.errorneous(e));
			}
			int rs = PageRank.sortAndComputeKTDistance(ps);
			System.out.print("Loop " + loop + ": the estimated KTD is " + es + ", ");
			System.out.print("the real KTD is " + rs + " ");
			float proportion = es == 0 ? 0f : (float) (Math.abs(rs - es)) / es;
			aver += proportion;
			System.out.println("the difference proportion is " + proportion);

			++loop;
		}
		System.out.println("the average difference is " + (float) aver / loop);
	}

	public float[] randomFloatArray(int size, float min, float max) {
		float[] nums = new float[size];
		for (int i = 0; i < size; ++i) {
			nums[i] = (float) (min + Math.random() * (max - min));
		}
		return nums;
	}

	@Test
	public void testSort() {
		int length = 1000;
		//initiate a random float
		float[] nums = randomFloatArray(1000, 0f, 1000f);
		sortAndComputeKTD(nums);
		float error = 0.1f;
		int times = 20;
		while (times-- > 0) {
			//estimate the KTD
			int eKTD = EstimateKTD(nums, error);
			//add error on the array
			for (int i = 0; i < length; ++i) {
				nums[i] += errorneous(error);
			}

			//compute the new KTD
			int rKTD = sortAndComputeKTD(nums);
			System.out.println("eKTD:" + eKTD + " rKTD:" + rKTD + " diff proportion:"
					+ (Math.abs(rKTD - eKTD) / (float) rKTD));
		}

	}
}
