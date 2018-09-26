package tk.string;

public class StringUtils {

	/***
	 *  获取指定长度的字符串，长度不够前面0填充
	 * @param str
	 * @return 
	 */
	public static String getSpecialLenStringWithZeroPrefix(String str,int len){
		StringBuilder sb = new StringBuilder();
		if(str==null){
			return null;
		}
		if(str.length() >=len){
			return str;
		}
		if(str.length() < len){
			for(int i = 0;i < len-str.length();i++){
				sb.append("0");
			}
			sb.append(str);
		}
		return sb.toString();
	}
	
}
