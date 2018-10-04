package com.tk.redpacket.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.FileCopyUtils;


public class FileUtils {

	/**
	 * 获取文件的byte字节数组
	 * @param file
	 * @return 字节数组
	 */
	public static byte[] getFileByte(File file) {
		byte[] result = null;
		byte[] buffer = new byte[4096];
		InputStream input = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			input = new FileInputStream(file);
			int read = -1;
			while ((read = input.read(buffer))!=-1) {
				out.write(buffer, 0, read);
			}
			out.flush();
			result = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	
	}
	
	/**
	 * 获取输入流的字节数组
	 * @param input 输入流
	 * @return 字节数组
	 */
	public static byte[] getInputStreamByte(InputStream input) {
		if(input == null) {
			return null;
		}
		byte[] result = null;
		byte[] buffer = new byte[4096];
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			int read = -1;
			while ((read = input.read(buffer))!=-1) {
				out.write(buffer, 0, read);
			}
			out.flush();
			result = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	
	}
	
	public static void main(String[] args) throws IOException {
		byte [] result = null;
		File file = new File("D:\\ssmGenerator.jar");
		Long start = System.currentTimeMillis();
		//result = getFileByte(file);
		result = FileCopyUtils.copyToByteArray(file);
		Long end = System.currentTimeMillis();
		System.err.println("共耗时：" + (end -start)+"毫秒");
	}
}
