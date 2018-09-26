package tk.response;

/**
 * 请求响应实体
 */
public class Result<T> {

	private Integer code;//响应码
	private String message;//消息
	private T data;//数据
	
	/**
	 * 构造器
	 * @param code 响应码
	 * @param message 消息
	 * @param data 数据
	 */
	public Result(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**获取响应码**/
	public Integer getCode() {
		return code;
	}

	/**设置响应码**/
	public void setCode(Integer code) {
		this.code = code;
	}

	/**获取消息**/
	public String getMessage() {
		return message;
	}

	/**设置消息**/
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
