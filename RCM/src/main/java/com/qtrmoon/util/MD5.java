package com.qtrmoon.util;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class MD5 {
	
	protected static Logger logger = Logger.getLogger(MD5.class);

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	public static void main(String[] args) {
		logger.info(md5("31119@qq.com"+"123456"));
		logger.info(md5("mj1"));
		logger.info(md5("12312312312312"));
	}
}
