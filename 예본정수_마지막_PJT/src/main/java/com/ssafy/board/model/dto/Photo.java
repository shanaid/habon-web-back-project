package com.ssafy.board.model.dto;

public class Photo {

	private int year; 
	private int month;
	private int week; 
	private String fn;
	private String fi;
	private String sn;
	private String si;
	private String tn;
	private String ti;
	private String fon;
	private String foi;
	private String fin;
	private String fii;
	
	
	public Photo() {
		super();
	}


	public Photo(int year, int month, int week, String fn, String fi, String sn, String si, String tn, String ti,
			String fon, String foi, String fin, String fii) {
		super();
		this.year = year;
		this.month = month;
		this.week = week;
		this.fn = fn;
		this.fi = fi;
		this.sn = sn;
		this.si = si;
		this.tn = tn;
		this.ti = ti;
		this.fon = fon;
		this.foi = foi;
		this.fin = fin;
		this.fii = fii;
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


	public String getFn() {
		return fn;
	}


	public void setFn(String fn) {
		this.fn = fn;
	}


	public String getFi() {
		return fi;
	}


	public void setFi(String fi) {
		this.fi = fi;
	}


	public String getSn() {
		return sn;
	}


	public void setSn(String sn) {
		this.sn = sn;
	}


	public String getSi() {
		return si;
	}


	public void setSi(String si) {
		this.si = si;
	}


	public String getTn() {
		return tn;
	}


	public void setTn(String tn) {
		this.tn = tn;
	}


	public String getTi() {
		return ti;
	}


	public void setTi(String ti) {
		this.ti = ti;
	}


	public String getFon() {
		return fon;
	}


	public void setFon(String fon) {
		this.fon = fon;
	}


	public String getFoi() {
		return foi;
	}


	public void setFoi(String foi) {
		this.foi = foi;
	}


	public String getFin() {
		return fin;
	}


	public void setFin(String fin) {
		this.fin = fin;
	}


	public String getFii() {
		return fii;
	}


	public void setFii(String fii) {
		this.fii = fii;
	}


	@Override
	public String toString() {
		return "Photo [year=" + year + ", month=" + month + ", week=" + week + ", fn=" + fn + ", fi=" + fi + ", sn="
				+ sn + ", si=" + si + ", tn=" + tn + ", ti=" + ti + ", fon=" + fon + ", foi=" + foi + ", fin=" + fin
				+ ", fii=" + fii + "]";
	}
	
	
	
}
