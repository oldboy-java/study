package tk.random;

import java.util.Random;

/***
 * 随机工具类
 */
public class RandomUtil {
	
	private static int nums [] = {0,1,2,3,4,5,6,7,8,9};
	private static char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	/**
	 * 获取随机串
	 * @param digitNum 数字个数
	 * @param charNum 字母个数
	 * @param startWithDigit 是否数字开头
	 */
	public static String getRandomString(int digitNum,int charNum,boolean startWithDigit){
		StringBuilder sb = new StringBuilder();
		if(startWithDigit){
			for(int i = 0;i <digitNum;i++){
				sb.append(String.valueOf(nums[new Random().nextInt(10)]));
			}
			for(int j = 0;j <charNum;j++){
				sb.append(String.valueOf(chars[new Random().nextInt(26)]));
			}
		}else{
			for(int j = 0;j <charNum;j++){
				sb.append(String.valueOf(chars[new Random().nextInt(26)]));
			}
			for(int i = 0;i <digitNum;i++){
				sb.append(String.valueOf(nums[new Random().nextInt(10)]));
			}
		}
		return sb.toString();
	}
}
