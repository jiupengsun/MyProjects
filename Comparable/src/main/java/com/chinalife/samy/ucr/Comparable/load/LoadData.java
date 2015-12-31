package com.chinalife.samy.ucr.Comparable.load;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoadData {

	private BufferedReader dataFile;
	private String path = System.getProperty("user.dir").concat("\\tmp\\");
	private String rankFile = "";

	private static LoadData instance;

	private LoadData() {
	}

	public static LoadData getInstance() {
		if (instance == null)
			instance = new LoadData();
		return instance;
	}

	public void loadDataFile(String file) throws FileNotFoundException {
		dataFile = new BufferedReader(new FileReader(file));
		rankFile = file.concat("-rankfile");
	}

	public static void test() {
		int max = 1000000;
		Map<Integer, Integer> graph = new HashMap<Integer, Integer>(max);
		Map<Integer, Integer> prob = new HashMap<Integer, Integer>(max);
		long start = System.nanoTime();
		for (int i = 0; i < max; i++) {
			graph.put(i, i);
			prob.put(i, i);
		}
		long tag1 = System.nanoTime();
		System.out.println(tag1 - start);
		Iterator<Integer> it = prob.keySet().iterator();
		while (it.hasNext()) {
			int id = it.next();
			if (graph.containsKey(id)) {
				graph.remove(id);
				it.remove();
			}
		}
		long tag2 = System.nanoTime();
		System.out.println(tag2 - start);
	}

}
