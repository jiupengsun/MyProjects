package com.samy.ucr.project.Comparable.pageRank;

public class Page implements Comparable<Page> {

	private int id;
	private float rankValue;
	private int convertTimes = 0;

	public int getConvertTimes() {
		return convertTimes;
	}

	public void setConvertTimes(int convertTimes) {
		this.convertTimes = convertTimes;
	}

	public Page(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setRankValue(float rv) {
		rankValue = rv;
	}

	public float getRankValue() {
		return rankValue;
	}

	/*@Override
	public int compareTo(Page o) {
		// TODO Auto-generated method stub
		float r = o.getRankValue();
		return rankValue < r ? -1 : (rankValue == r ? 0 : 1);
	}*/

	/**
	 * sort by convert Times
	 */
	@Override
	public int compareTo(Page o) {
		// TODO Auto-generated method stub
		int c = o.getConvertTimes();
		return convertTimes < c ? -1 : (convertTimes == c ? 0 : 1);
	}
}
