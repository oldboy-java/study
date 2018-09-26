package tk.upload;


/***
 * 上传服务响应Vo
 */
public class UploadResponseVo {
	
	private String fileId; //文件ID
	private String state; //上传状态
	private String fileType; //文件类型
	private String fileName; //文件名
	private String fileSize; //文件大小
	private String filePath;//文件路径
	private String msg ; //提示信息
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "UploadResponseVo [fileId=" + fileId + ", state=" + state
				+ ", fileType=" + fileType + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", filePath=" + filePath
				+ ", msg=" + msg + "]";
	}
	
	
}
