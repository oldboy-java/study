package tk.response.v2;

/**
 * 响应码消息
 *
 */
public class CodeMsg {

	private int code; //响应码
	private String message;//消息
	
	
	public CodeMsg() {
		super();
	}
	public CodeMsg(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
