package com.ssafy.board.model.dto;

public class Video {
	private int videoId;
	private String videoTitle;
	private String videoCategory;
	private String videoUrl;
	private String videoChannelName;
	private int videoViewCount;

	public Video() {
	}

	public Video(String videoTitle, String videoCategory, String videoUrl, String videoChannelName) {
		super();
		this.videoTitle = videoTitle;
		this.videoCategory = videoCategory;
		this.videoUrl = videoUrl;
		this.videoChannelName = videoChannelName;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoChannelName() {
		return videoChannelName;
	}

	public void setVideoChannelName(String videoChannelName) {
		this.videoChannelName = videoChannelName;
	}

	public int getVideoViewCount() {
		return videoViewCount;
	}

	public void setVideoViewCount(int videoViewCount) {
		this.videoViewCount = videoViewCount;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoCategory=" + videoCategory
				+ ", videoUrl=" + videoUrl + ", videoChannelName=" + videoChannelName + ", videoViewCount="
				+ videoViewCount + "]";
	}

}
