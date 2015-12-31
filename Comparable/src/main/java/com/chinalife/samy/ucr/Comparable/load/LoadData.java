package com.chinalife.samy.ucr.Comparable.load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadData {

	private BufferedReader dataFile;

	private final String REGEX = "[ \t]+";

	private static LoadData instance;

	private LoadData() {
	}

	public static LoadData getInstance() {
		if (instance == null)
			instance = new LoadData();
		return instance;
	}

	public Map<Integer, List<Integer>> loadNodeGraph(String file)
			throws IOException {
		if (dataFile == null)
			dataFile = new BufferedReader(new FileReader(file));
		String line = "";
		int mapInitialSize = 5000;
		Map<Integer, List<Integer>> nodeGraph = new HashMap<Integer, List<Integer>>(
				mapInitialSize);
		try {
			while ((line = dataFile.readLine()) != null) {
				if (line.startsWith("#"))
					continue;
				String[] ss = line.split(REGEX);
				int nodeId = Integer.parseInt(ss[0]);
				int edgeId = Integer.parseInt(ss[1]);
				if (nodeGraph.containsKey(nodeId))
					nodeGraph.get(nodeId).add(edgeId);
				else {
					List<Integer> edgeList = new ArrayList<Integer>();
					edgeList.add(edgeId);
					nodeGraph.put(nodeId, edgeList);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dataFile != null) {
				dataFile.close();
				dataFile = null;
			}
		}
		return nodeGraph;
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
