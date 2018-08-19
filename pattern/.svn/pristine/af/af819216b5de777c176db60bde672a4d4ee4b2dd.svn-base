package io;

import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class IOTest {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("d:\\a.txt");
			fis.skip(3); 
			
			//调用read方法，读取一个字节的数据
			int a = fis.read();
			System.err.println((char)a);
			fis.close();
			
			RandomAccessFile file = new RandomAccessFile("d:\\a.txt","rw");
			file.skipBytes(3);
			file.seek(2);
			a = file.read();
			System.err.println((char)a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
