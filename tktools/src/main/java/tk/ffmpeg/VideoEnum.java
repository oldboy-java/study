package tk.ffmpeg;

/**
 * 视频类型枚举
 *
 */
public enum VideoEnum {

	MP4(1),FLV(2),AVI(3);
	
	private Integer videoType;

	private VideoEnum(Integer videoType) {
		this.videoType = videoType;
	}

	public Integer getVideoType() {
		return videoType;
	}

	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	
	
}
