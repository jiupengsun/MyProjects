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

	public int KTDistance(Page[] ps, float e) {
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

	public float errorneous(float e) {
		double r = Math.random();
		double s = Math.round(Math.random());
		e *= r;
		return s > 0.5 ? e : -e;
	}

	@Test
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
			int es = ebt.KTDistance(ps, e);
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

}
