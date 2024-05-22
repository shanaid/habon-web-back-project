package com.ssafy.board.model.dto;

public class weeklyrank {
	private int id;
	private int worldcupId;
	private int year;
	private int month;
	private int week;
	private int firstEleId;
	private int secondEleId;
	private int thirdEleId;
	private int fourthEleId;
	private int fifthEleId;
	public weeklyrank(int id, int worldcupId, int year, int month, int week, int firstEleId, int secondEleId,
			int thirdEleId, int fourthEleId, int fifthEleId) {
		super();
		this.id = id;
		this.worldcupId = worldcupId;
		this.year = year;
		this.month = month;
		this.week = week;
		this.firstEleId = firstEleId;
		this.secondEleId = secondEleId;
		this.thirdEleId = thirdEleId;
		this.fourthEleId = fourthEleId;
		this.fifthEleId = fifthEleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWorldcupId() {
		return worldcupId;
	}
	public void setWorldcupId(int worldcupId) {
		this.worldcupId = worldcupId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getFirstEleId() {
		return firstEleId;
	}
	public void setFirstEleId(int firstEleId) {
		this.firstEleId = firstEleId;
	}
	public int getSecondEleId() {
		return secondEleId;
	}
	public void setSecondEleId(int secondEleId) {
		this.secondEleId = secondEleId;
	}
	public int getThirdEleId() {
		return thirdEleId;
	}
	public void setThirdEleId(int thirdEleId) {
		this.thirdEleId = thirdEleId;
	}
	public int getFourthEleId() {
		return fourthEleId;
	}
	public void setFourthEleId(int fourthEleId) {
		this.fourthEleId = fourthEleId;
	}
	public int getFifthEleId() {
		return fifthEleId;
	}
	public void setFifthEleId(int fifthEleId) {
		this.fifthEleId = fifthEleId;
	}
	@Override
	public String toString() {
		return "weeklyrank [id=" + id + ", worldcupId=" + worldcupId + ", year=" + year + ", month=" + month + ", week="
				+ week + ", firstEleId=" + firstEleId + ", secondEleId=" + secondEleId + ", thirdEleId=" + thirdEleId
				+ ", fourthEleId=" + fourthEleId + ", fifthEleId=" + fifthEleId + "]";
	}
	
	
	
	
}
