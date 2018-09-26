package tk.response;

/***
 * 请求响应结果封装工具类，完成请求结果响应封装
 *
 */
public class ResultUtils {

	/***
	 * 成功: 1
	 * @param data 响应结果集
	 * @return
	 */
	public static Result success(Object data){
		Result result = new Result(1,null, data);//构造含有Object的Result对象
		return result;  //返回
	}
	

	/***
	 * 成功 :1
	 * @return
	 */
	public static Result success(){
		Result result = new Result(1, null, null);//构造不含有Object的Result对象返回成功
		return result;//返回
	}
	
	
	/**失败
	 * @param code 错误码
	 * @param message 错误消息
	 * @return
	 */
	public static Result error(Integer code,String message){
		Result result = new Result(code, message, null);//构造不含有Object的Result对象返回错误标识和操作消息
		return result;//返回
	}
}
