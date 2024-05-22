package com.ssafy.board.model.dto;

public class Report {
	private int id;
	private String contentType;
	private int contentId;
	private String contentContent;
	private String reportContent;

	public Report() {
		super();
	}

	public Report(String contentType, int contentId, String contentContent, String reportContent) {
		super();
		this.contentType = contentType;
		this.contentId = contentId;
		this.contentContent = contentContent;
		this.reportContent = reportContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	

	public String getContentContent() {
		return contentContent;
	}

	public void setContentContent(String contentContent) {
		this.contentContent = contentContent;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", contentType=" + contentType + ", contentId=" + contentId + ", contentContent="
				+ contentContent + ", reportContent=" + reportContent + "]";
	}

}
