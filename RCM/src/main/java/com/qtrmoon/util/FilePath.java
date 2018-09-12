package com.qtrmoon.util;

import java.util.ResourceBundle;

public class FilePath
{

	public static String getFilePath(String name)
	{
		// ResourceBundle是一个抽象类，这种方式来获取properties属性文件不需要加.properties后缀名，只需要文件名即可。
		ResourceBundle resource = ResourceBundle.getBundle("application");// application为属性文件名，放在包com.qtrmoon.student.util下，如果是放在src下，直接用filepath即可
		String pathName = resource.getString(name);// 通过getString(key)获取，文件中对应的属性值
		return pathName;
	}

}
