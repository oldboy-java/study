package tk.ffmpeg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ffmpeg视频转换
 *
 */
public class FfmpegVideoConverter {
	private static String OS = System.getProperty("os.name").toLowerCase();
	private String inputPath;
	private String outputPath;
	private String ffmpegPath;

	public static void main(String args[]) throws IOException {
		boolean convert = new FfmpegVideoConverter("E:/1.avi", null,
				"G:/ffmpeg-20171225-be2da4c-win64-static/bin/")
				.convert(VideoEnum.MP4.getVideoType());
		System.err.println("convert=" + convert);
	}

	/***
	 * 
	 * @param inputPath
	 *            视频源路径
	 * @param outputPath
	 *            视频输出路径
	 * @param ffmpegPath
	 *            ffmpegPath安装路径
	 */
	public FfmpegVideoConverter(String inputPath, String outputPath,
			String ffmpegPath) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.ffmpegPath = ffmpegPath;
	}

	/***
	 * 转换处理
	 * 
	 * @param targetVideoType
	 *            目标视频格式
	 * @return
	 */
	public boolean convert(int targetVideoType) {
		if (!checkfile(inputPath)) {
			System.out.println(inputPath + " is not file");
			throw new RuntimeException(inputPath + " 路径不存在");
		}
		int result = checkContentType();
		String type = inputPath.substring(inputPath.lastIndexOf(".") + 1,
				inputPath.length()).toLowerCase();
		if (result == 1) {
			throw new RuntimeException("ffmpeg不支持" + type + "格式转换");
		}
		boolean status = false;
		if (targetVideoType == VideoEnum.MP4.getVideoType()) {
			status = processMp4();
		} else if (targetVideoType == VideoEnum.FLV.getVideoType()) {
			status = processFlv();
		}
		return status;
	}

	private int checkContentType() {
		String type = inputPath.substring(inputPath.lastIndexOf(".") + 1,
				inputPath.length()).toLowerCase();
		// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
		if (type.equals("avi")) {
			return 0;
		} else if (type.equals("mpg")) {
			return 0;
		} else if (type.equals("wmv")) {
			return 0;
		} else if (type.equals("3gp")) {
			return 0;
		} else if (type.equals("mov")) {
			return 0;
		} else if (type.equals("mp4")) {
			return 0;
		} else if (type.equals("asf")) {
			return 0;
		} else if (type.equals("asx")) {
			return 0;
		} else if (type.equals("flv")) {
			return 0;
		}
		// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
		// 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
		else if (type.equals("wmv9")) {
			return 1;
		} else if (type.equals("rm")) {
			return 1;
		} else if (type.equals("rmvb")) {
			return 1;
		}
		return 9;
	}

	private static boolean checkfile(String path) {
		File file = new File(path);
		if (!file.isFile()) {
			return false;
		}
		return true;
	}

	// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
	/*
	 * private static String processAVI() { List<String> commend = new
	 * ArrayList<String>(); commend.add(ffmpegPath + "mencoder");
	 * commend.add(inputPath); commend.add("-oac"); commend.add("lavc");
	 * commend.add("-lavcopts"); commend.add("acodec=mp3:abitrate=64");
	 * commend.add("-ovc"); commend.add("xvid"); commend.add("-xvidencopts");
	 * commend.add("bitrate=600"); commend.add("-of"); commend.add("mp4");
	 * commend.add("-o"); commend.add(outputPath + "a.AVI"); try {
	 * ProcessBuilder builder = new ProcessBuilder(); Process process =
	 * builder.command(commend) .redirectErrorStream(true).start(); new
	 * PrintStream(process.getInputStream()); new
	 * PrintStream(process.getErrorStream()); process.waitFor(); return
	 * outputPath + "a.AVI"; } catch (Exception e) { e.printStackTrace(); return
	 * null; } }
	 */

	// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	private boolean processFlv() {
		if (!checkfile(inputPath)) {
			System.out.println(inputPath + " is not file");
			return false;
		}
		List<String> command = new ArrayList<String>();
		if (OS.indexOf("windows") >= 0) {
			command.add(ffmpegPath + "ffmpeg");
		} else if (OS.indexOf("linux") >= 0) {
			command.add("ffmpeg");
		}
		command.add("-i");
		command.add(inputPath);
		command.add("-ab");
		command.add("56");
		command.add("-ar");
		command.add("22050");
		command.add("-qscale");
		command.add("8");
		command.add("-r");
		command.add("15");
		command.add("-s");
		command.add("600x500");
		if (outputPath == null || "".equals(outputPath)) {
			command.add(inputPath.substring(0, inputPath.lastIndexOf("."))
					+ ".flv");
		} else {
			command.add(outputPath);
		}
		try {

			// 方案1
			// Process videoProcess = Runtime.getRuntime().exec(ffmpegPath +
			// "ffmpeg -i " + oldfilepath
			// + " -ab 56 -ar 22050 -qscale 8 -r 15 -s 600x500 "
			// + outputPath + "a.flv");

			// 方案2
			Process videoProcess = new ProcessBuilder(command)
					.redirectErrorStream(true).start();
			new PrintStream(videoProcess.getErrorStream()).start();
			new PrintStream(videoProcess.getInputStream()).start();
			videoProcess.waitFor();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean processMp4() {
		// StringBuilder sb = new StringBuilder();
		if (!checkfile(inputPath)) {
			System.out.println(inputPath + " is not file");
			return false;
		}
		List<String> command = new ArrayList<String>();
		if (OS.indexOf("windows") >= 0) {
			command.add(ffmpegPath + "ffmpeg");
			// sb.append(ffmpegPath + "ffmpeg ");
		} else if (OS.indexOf("linux") >= 0) {
			command.add("ffmpeg");
			// sb.append("ffmpeg ");
		}

		// 在linux上-c:v libx264 -mbd 0 有问题
		// sb.append(" -i ").append(inputPath).append(" -c:a aac -strict -2  -pix_fmt yuv420p -movflags faststart ");

		command.add("-i");
		command.add(inputPath);
		command.add("-c:v");
		command.add("libx264");
		command.add("-mbd");
		command.add("0");
		command.add("-c:a");
		command.add("aac");
		command.add("-strict");
		command.add("-2");
		command.add("-pix_fmt");
		command.add("yuv420p");
		command.add("-movflags");
		command.add("faststart");

		if (outputPath == null || "".equals(outputPath)) {
			command.add(inputPath.substring(0, inputPath.lastIndexOf("."))
					+ ".mp4");
			// sb.append(inputPath.substring(0, inputPath.lastIndexOf(".")) +
			// ".mp4");
		} else {
			command.add(outputPath);
			// sb.append(outputPath);
		}
		try {

			// 方案1
			// Process videoProcess = Runtime.getRuntime().exec(sb.toString());

			// 方案2
			Process videoProcess = new ProcessBuilder(command)
					.redirectErrorStream(true).start();

			new PrintStream(videoProcess.getErrorStream()).start();
			new PrintStream(videoProcess.getInputStream()).start();
			videoProcess.waitFor();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

class PrintStream extends Thread {
	java.io.InputStream __is = null;

	public PrintStream(java.io.InputStream is) {
		__is = is;
	}

	public void run() {
		try {
			while (this != null) {
				int _ch = __is.read();
				if (_ch != -1)
					System.out.print((char) _ch);
				else
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}