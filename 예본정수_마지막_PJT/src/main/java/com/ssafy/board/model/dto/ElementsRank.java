package com.ssafy.board.model.dto;

public class ElementsRank {
	private int elementsId;
	private String name;
	private String img;
	private int point;
	private int accPoint;
	public ElementsRank(int elementsId, String name, String img, int point, int accPoint) {
		super();
		this.elementsId = elementsId;
		this.name = name;
		this.img = img;
		this.point = point;
		this.accPoint = accPoint;
	}
	
	
	public int getElementsId() {
		return elementsId;
	}
	public void setElementsId(int elementsId) {
		this.elementsId = elementsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getAccPoint() {
		return accPoint;
	}
	public void setAccPoint(int accPoint) {
		this.accPoint = accPoint;
	}
	@Override
	public String toString() {
		return "ElementsRank [elementsId=" + elementsId + ", name=" + name + ", img=" + img + ", point=" + point
				+ ", accPoint=" + accPoint + "]";
	}
	

	
	
}
