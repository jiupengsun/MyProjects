package com.samy.ucr.project.Comparable.pageRank;

public class Page implements Comparable<Page> {

	private int id;
	private double rankValue;

	public Page(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setRankValue(double rv) {
		rankValue = rv;
	}

	public double getRankValue() {
		return rankValue;
	}

	@Override
	public int compareTo(Page o) {
		// TODO Auto-generated method stub
		double r = o.getRankValue();
		return rankValue < r ? -1 : (rankValue == r ? 0 : 1);
	}

}
