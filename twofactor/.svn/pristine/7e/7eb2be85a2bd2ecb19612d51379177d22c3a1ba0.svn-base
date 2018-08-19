package twofactor;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	/**
	 * 
	 * @Title: toMD5 @Description: 计算字符串的MD5值，使用默认的UTF-8的编码方式 @date Aug 29, 2012
	 *         1:48:06 PM @param @return String @throws
	 */
	public static String toMD5(String text) {
		return toMD5(text, "utf-8");
	}

	/**
	 * 
	 * @Title: toMD5 @Description: 计算字符串的MD5值，使用指定的编码方式 @date Aug 29, 2012
	 *         1:45:07 PM @param @return String @throws
	 */
	public static String toMD5(String text, String charset) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			msgDigest.update(text.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("System doesn't support your EncodingException.");
		}
		byte[] bytes = msgDigest.digest();
		String md5Str = new String(encodeHex(bytes));
		return md5Str;
	}

	/**
	 * 
	 * @Title: encodeHex @Description: 将字节数组转换成十六进制字符数组 @date Aug 29, 2012
	 *         1:42:51 PM @param @return char[] @throws
	 */
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		// two characters form the hex value.
		int j = 0;
		for (int i = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}

}
