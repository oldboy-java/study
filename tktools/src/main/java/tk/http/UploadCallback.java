package tk.http;

/**
 * 上传回调接口
 *
 */
public interface UploadCallback {
	
	/**
	 * 上传成功方法
	 * @param result 上传返回内容
	 */
	public void onSuccess(String result);
	
	/***
	 * 上传失败方法
	 * @param msg 错误消息
	 */
	public void onError(String msg);
	
}
