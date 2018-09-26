package tk.response.v2;

/**
 * 请求响应实体
 */
public class Result<T> {
	private int code; //响应码
	private String message;//消息
	private T data;//数据
	

	public Result() {
		super();
	}

	public Result(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**获取数据**/
	public T getData() {
		return data;
	}

	/**设置数据**/
	public void setData(T data) {
		this.data = data;
	}
	
}
