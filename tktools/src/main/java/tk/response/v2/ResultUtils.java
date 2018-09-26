package tk.response.v2;


/***
 * 请求响应结果封装工具类，完成请求结果响应封装
 *
 */
public class ResultUtils {

	
	/**
	 * 成功返回数据
	 * @param codeMsg 响应码消息
	 * @param data 返回数据
	 * @return
	 */
	public static Result success(CodeMsg codeMsg,Object data){
		Result result = new Result(codeMsg.getCode(),codeMsg.getMessage(), data);//构造含有Object的Result对象
		return result;  //返回
	}
	

	/***
	 * 成功不返回数据
	 * @return
	 */
	public static Result success(CodeMsg codeMsg){
		Result result = new Result(codeMsg.getCode(),codeMsg.getMessage(), null);//构造不含有Object的Result对象返回成功
		return result;//返回
	}
	
	
	/**失败
	 * @param codeMsg 响应码消息
	 * @return
	 */
	public static Result error(CodeMsg codeMsg){
		Result result = new Result(codeMsg.getCode(),codeMsg.getMessage(), null);//构造不含有Object的Result对象返回错误标识和操作消息
		return result;//返回
	}
}
