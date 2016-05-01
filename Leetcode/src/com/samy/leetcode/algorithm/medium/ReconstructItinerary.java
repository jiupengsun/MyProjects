package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

	/**
	 * 
	 * @param tickets
	 * @return
	 * 2016年5月1日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/reconstruct-itinerary/
	 * @interpretation
	 */
	public List<String> findItinerary(String[][] tickets) {
		Map<String, List<String>> order = new HashMap<String, List<String>>();
		for (String[] t : tickets) {
			List<String> list = null;
			if ((list = order.get(t[0])) != null) {
				int i = 0, l = list.size();
				while (i < l && t[1].compareTo(list.get(i)) > 0)
					++i;
				list.add(i, t[1]);
			} else {
				list = new LinkedList<String>();
				list.add(t[1]);
				order.put(t[0], list);
			}
		}
		List<String> cons = new ArrayList<String>();
		String last = "JFK";
		while (true) {
			cons.add(last);
			List<String> next = order.get(last);
			String tmp = null;
			for (int i = 0, l = next.size(); i < l; ++i) {
				if (order.containsKey(next.get(i))) {
					
					tmp = next.remove(i);
					break;
				}
			}
			if (tmp == null) {
				Iterator<String> keys = order.keySet().iterator();
				while (keys.hasNext()) {
					List<String> l = order.get(keys.next());
					cons.addAll(l);
				}
				return cons;
			}
			if (next.size() == 0)
				order.remove(last);
			last = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" }, { "JFK", "MUC" } };
		ReconstructItinerary ri = new ReconstructItinerary();
		ri.findItinerary(tickets);
	}

}
