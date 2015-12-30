package com.samy.ucr.project.Comparable.pageRank;

import java.io.IOException;

import org.junit.Test;

public class PageRankTest2 {

	@Test
	public void test() {
		float threshold = 0.00001f;
		float dFactor = 0.8f;

		// load data file
		String dataFile = "";

		String outputFile = "";
		try {
			PageRank.computeRank(dataFile, outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
