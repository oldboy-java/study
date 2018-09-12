package insertTools;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.stream.FileImageInputStream;

import org.apache.log4j.Logger;

/**
 * 文件操作工具类
 * 
 * @author cuiqinglong
 * @author Carl He 2007-11-6
 */
public class FileUtil {
	private static final Logger logger = Logger.getLogger(FileUtil.class);
	private static final int BUFFER = 2048;
	
	/**
	 * 把图片转换为byte数组
	 * @param path
	 * @return
	 */
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 把文件转换成byte数组
	 * @param filePath
	 * @return
	 */
	public static byte[] file2byte(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
  
	
	/**
	 * 文件删除 FilePath为要删除的文件路径
	 */
	public static void deleteFile(String FilePath) {
		File file = new File(FilePath);
		if (file.exists()) {
			file.delete();
		} else {
			logger.debug("所要删除的文件不存在");
		}
	}
	
	public static long getFileSizeByDir(String dirPath) {
		File file = new File(dirPath);
		long size = 0l;
		File files[] = file.listFiles();
		for (int i = (files.length); i > 0; i--) {
			if (files[i - 1].isDirectory()) {
				size = size + getFileSizeByDir(dirPath + files[i - 1].getName());
			} else {
				size = size + files[i - 1].length();
			}
		}
		return size;
	}

	public static File[] getDirectory() {
		File file = new File("C:\\temp32");
		File files[] = file.listFiles(new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isFile();
			}
		});
		return files;
	}

	/**
	 * 提取文件的后缀名
	 * @author Carl He
	 * @param file
	 *            文件
	 * @return 文件的后缀名， 如 fileName = "test.txt" 时， 将返回 "txt"
	 */
	public static String getFileExtention(File file) {
		return getFileExtention(file.getName());
	}

	/**
	 * 根据文件名提取文件的后缀名
	 * @author Carl He
	 * @param fileName
	 *            文件名
	 * @return 文件的后缀名， 如 fileName = "test.txt" 时， 将返回 "txt"
	 */
	public static String getFileExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return (pos == -1) ? "" : fileName.substring(pos + 1);
	}

	public static boolean createZeroFile(String filename){
		File file = new File(filename);
		file.getParentFile().mkdirs();
		try {
			return file.createNewFile();
		} catch (IOException e) {
			return false;
		}		
	}
	
	
	public static String getFileByEncoding(String fileFullPath, String encoding) {

		if (encoding.equalsIgnoreCase("unicode")) {

			return read_Uni(fileFullPath);
		}
		StringBuffer content = new StringBuffer();
		InputStream input = null;
		try {
			File file = new File(fileFullPath);
			input = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			ByteArrayOutputStream outbytestream = new ByteArrayOutputStream();
			int bytes_read, len = 0;
			while ((bytes_read = input.read(buffer)) != -1) {
				outbytestream.write(buffer, 0, bytes_read);
				len = len + bytes_read;
			}
			content.append(new String(outbytestream.toByteArray(), 0, len,
					encoding));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
					// monLog.error(fileName + " get file error");
					return null;
				}
			}
		}
		return content.toString();
	}

	public static String read_Uni(String fileFullPath) {

		String strReturn = null;

		FileInputStream is = null;
		ByteArrayOutputStream outbytestream = null;
		byte[] word_uni = null;

		try {
			File file = new File(fileFullPath);
			is = new FileInputStream(file);
			outbytestream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			
			int bytes_read, len = 0, start = 0;
			boolean isread = false;

			while ((bytes_read = is.read(buffer)) != -1) {
				// 跳过两个字节的文件头
				if (!isread) {
					isread = true;
					if (buffer[0] == -1 && buffer[1] == -2) {
						byte[] temp_buffer = new byte[buffer.length - 2];
						for (int i = 0; i < temp_buffer.length; i++) {
							temp_buffer[i] = buffer[i + 2];

						}
						outbytestream.write(temp_buffer, 0, bytes_read - 2);
					} else {
						outbytestream.write(buffer, 0, bytes_read);
					}
				} else {
					outbytestream.write(buffer, 0, bytes_read);
				}

				len = len + bytes_read;
				start++;
			}
			word_uni = outbytestream.toByteArray();
		} catch (IOException ex) {
			System.out.println(ex);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outbytestream != null) {
				try {
					outbytestream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		StringBuffer stringbuffer = new StringBuffer("");
		for (int j = 0; j < word_uni.length;) {
			int l = word_uni[j++];
			int h = word_uni[j++];
			char c = (char) ((l & 0xff) | ((h << 8) & 0xff00));
			stringbuffer.append(c);
		}
		strReturn = stringbuffer.toString();

		return strReturn;

	}

	public static boolean writeFileByEncoding(String docContent,
			String fileFullName, String fileCode) {
		boolean writeFlag = true;

		if (docContent == null) {
			return false;
		}
		// strBuffer_8.append(newsDocument_8.getItemId().)
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter writer = null;

		if (fileFullName == null && fileFullName.length() == 0) {
			// 稿号为空，生成失败
			return false;
		}
		try {
			fileOutputStream = new FileOutputStream(new File(fileFullName));
			writer = new OutputStreamWriter(fileOutputStream, fileCode);
			writer.write(docContent);
			writeFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			writeFlag = false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}

		}
		return writeFlag;
	}

	public static boolean writeFileByEncoding(String docContent,
			String textFliePath, String fileName, String fileCode) {
		boolean writeFlag = true;

		if (docContent == null) {
			return false;
		}
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter writer = null;

		if (fileName == null && fileName.length() == 0) {
			// 稿号为空，生成失败
			return false;
		}
		try {
			fileOutputStream = new FileOutputStream(new File(textFliePath
					+ File.separator + fileName));
			writer = new OutputStreamWriter(fileOutputStream, fileCode);
			writer.write(docContent);
			writeFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			writeFlag = false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}

		}
		return writeFlag;
	}


	public static boolean renameFile(String srcFilePath, String srcFileName,
			String targetPath, String targetFileName) {

		String srcFileFullPath = null;
		if (srcFilePath != null && srcFilePath.length() > 0) {
			while (srcFilePath.endsWith("/")) {
				srcFilePath = srcFilePath
						.substring(0, srcFilePath.length() - 1);
			}
			srcFileFullPath = srcFilePath + "/" + srcFileName;
		} else {
			System.out.println("ddd");
			srcFileFullPath = srcFileName;
		}
		if (srcFileName == null || srcFileName.length() == 0) {
			return true;
		}
		File targetFileDir = new File(targetPath);
		if (!targetFileDir.exists()) {
			// 如果输出路径不存在,创建文件目录
			targetFileDir.mkdirs();

		}
		String targetFileFullPath = targetPath + "/" + targetFileName;
		File srcFile = new File(srcFileFullPath);
		if (!srcFile.exists()) {
			return false;
		}
		File targetFile = new File(targetFileFullPath);

		return srcFile.renameTo(targetFile);
	}

	public static boolean renameFile(String srcFileFullPath, String targetPath,
			String targetFileName) {

	
		if (srcFileFullPath != null && srcFileFullPath.length() > 0) {
			while (srcFileFullPath.endsWith("/")) {
				srcFileFullPath = srcFileFullPath
						.substring(0, srcFileFullPath.length() - 1);
			}
		
		} 
		if (srcFileFullPath == null || srcFileFullPath.length() == 0) {
			return true;
		}
		File targetFileDir = new File(targetPath);
		if (!targetFileDir.exists()) {
			// 如果输出路径不存在,创建文件目录
			targetFileDir.mkdirs();

		}
		String targetFileFullPath = targetPath + "/" + targetFileName;
		File srcFile = new File(srcFileFullPath);
		if (!srcFile.exists()) {
			return false;
		}
		File targetFile = new File(targetFileFullPath);

		return srcFile.renameTo(targetFile);
	}

	public static String filepath(String filePath) {
		String temp = filePath.replace('\\', '/');
		while (temp.contains("//")) {
			temp = temp.replace("//", "/");
		}
		return temp;
	}

	/**
	 * 
	 * @param srcFileFullPath
	 * @param targetPath
	 * @param destFileName
	 * @throws Exception
	 */
	/**
	 * //zs 解压缩文件 输入文件PZIP 输出PDFILE
	 * 
	 * @param pzip
	 *            String
	 */
	public static String ungzip(String pzip, String filepath, String format) {
		String strentry = "";
		ZipEntry entry = null;
		File fzip = new File(pzip);
		System.out.println("pzip=" + pzip + " filepath=" + filepath
				+ " format=" + format);
		if (!fzip.exists() || !fzip.isFile())
			return "ErrorInfo=invalid zip file, filename=" + pzip;
		BufferedOutputStream dest = null;
		BufferedInputStream is = null;
		ZipFile zipfile = null;
		FileOutputStream fos = null;
		try {

			zipfile = new ZipFile(fzip);
			Enumeration e = zipfile.entries();
			while (e.hasMoreElements()) {
				entry = (ZipEntry) e.nextElement();
				strentry = entry.toString();
				int i = strentry.lastIndexOf(".");
				// String inx = entry.toString().substring(i+1,
				// entry.toString().length());
				// System.out.println("strentry="+strentry);
				String inx = strentry.substring(i + 1);
				if (format.length() > 0) {
					if (inx.trim().toLowerCase().compareTo("ssdoc") != 0) {
						return "ErrorInfo=incompatible format, object format="
								+ format;
					}
				}
				is = new BufferedInputStream(zipfile.getInputStream(entry));
				int count;
				byte data[] = new byte[BUFFER];
				String targetFile = filepath + "/" + strentry;
				fos = new FileOutputStream(targetFile);
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = is.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
			}
			zipfile.close();
		} catch (Exception ex) {
			ex.printStackTrace();

			return "ErrorInfo= Exception:" + ex.toString();
		} finally {
			if (dest != null) {
				try {
					dest.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (dest != null) {
				try {
					dest.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (zipfile != null) {

				try {
					zipfile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return strentry;
	}

	public static String filterInvalidChar(String strContent) {
		String reString = strContent;
		byte invaldchars[] = { 0, 3, 4, 7, 16, 17, 19 };
		for (int i = 0; i < invaldchars.length; i++) {
			byte[] curbyte = { invaldchars[i] };
			reString = reString.replaceAll(new String(curbyte), "");
		}

		return reString;
	}

	public static String replaceTabchar(String strContent) {
		String reString = strContent;
		byte tabchar[] = { 9 };
		reString = reString.replaceAll(new String(tabchar), "     ");
		return reString;
	}

	public static String resetText(String strText, String langId) {
		String strFinish = "";
		String strUnfinish = strText;
		int i = strUnfinish.indexOf("\r\n");
		while (i >= 0) {
			String strRemain = strUnfinish.substring(i + "\r\n".length());
			// ３个半角空格
			if (strRemain.startsWith("   ")
			// ２个全角空格
					|| strRemain.startsWith("　　")
					// 回车换行
					|| strRemain.startsWith("\r\n")) {
				strFinish = strFinish
						+ strUnfinish.substring(0, i + "\r\n".length());
			} else {
				strFinish = strFinish + strUnfinish.substring(0, i);
				if ((langId.equalsIgnoreCase("C"))
						&& strRemain.length() > 0
						&& strRemain.charAt(0) != ' '
						&& (strFinish.length() > 0 && strFinish
								.charAt(strFinish.length() - 1) != ' '))
					strFinish = strFinish + ' ';
			}
			strUnfinish = strUnfinish.substring(i + "\r\n".length());

			i = strUnfinish.indexOf("\r\n");
		}
		strFinish = strFinish + strUnfinish;

		return strFinish;
	}

}
