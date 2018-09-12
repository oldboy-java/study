package insertTools;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author yanghui
 *ͨ�ù��߰����й��ַ�������Ĺ���
 */
public class StringUtils {


	public static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * turn GBK encoding into ISO8859_1 encoding
	 * 
	 * @param inputstring
	 * @return null if there is any exception
	 */
	public static String gbk2e(String inputstring) {
		if (inputstring == null) {
			return null;
		}

		String outputstring = "";
		try {
			byte[] bytearray = inputstring.getBytes("GBK");
			outputstring = new String(bytearray, "ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}
		return outputstring;
	}
	/**
	 * turn GBK encoding into ISO8859_1 encoding
	 * 
	 * @param inputstring
	 * @return null if there is any exception
	 */
	public static String gbk2Utf(String inputstring) {
		if (inputstring == null) {
			return null;
		}

		String outputstring = "";
		try {
			byte[] bytearray = inputstring.getBytes("GBK");
			outputstring = new String(bytearray, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}
		return outputstring;
	}
	/**
	 * �ַ�����Ϊ�շ���true
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	/**
	 * ����ַ���Ϊ�շ�??
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return (str == null || "".equals(str));
	}
	/**
	 * translate default character's code  to GBK
	 * @param inputstring
	 * @return
	 */
    public static String default2GBK(String inputstring){
    	if (inputstring == null) {
			return null;
		}
		String outputstring = "";
		try {
			byte[] bytearray = inputstring.getBytes();
			outputstring = new String(bytearray,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}
		return outputstring;
    }
	/**
	 * turn ISO8859_1 encoding into GBK encoding
	 * 
	 * @param inputstring
	 * @return null if there is any exception
	 */
	public static String e2gbk(String inputstring, boolean isDeCode) {
		if (inputstring == null) {
			return null;
		}

		String outputstring = "";
		if (isDeCode) {
			try {
				outputstring = new String(inputstring.getBytes("8859_1"), "GBK");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return outputstring;
	}

	/**
	 * replace substring with new string
	 * 
	 * @param inputstr
	 *            source string
	 * @param oldsub
	 *            sub string to be replaced
	 * @param newsub
	 *            string to be replaced with
	 * @return
	 */
	public static String replace(String inputstr, String oldsub, String newsub) {
		if (inputstr == null) {
			return null;
		}
		if (oldsub == null || oldsub.equals("")) {
			return inputstr;
		}
		if (newsub == null) {
			return inputstr;
		}

		String outputstr = "";
		int oldlen = oldsub.length();
		while (true) {
			int position = inputstr.indexOf(oldsub);
			if (position != -1) {
				outputstr += inputstr.substring(0, position) + newsub;
				inputstr = inputstr.substring(position + oldlen);
				continue;
			}
			outputstr += inputstr;
			break;
		}
		return outputstr;
	}

	/**
	 * get count number of index string
	 * 
	 * @param inputstr
	 *            source string
	 * @param indexstr
	 *            index string
	 * @param overlap
	 *            overlap index string counted
	 * @return -1 if inputstr is null
	 */
	public static int indexCount(String inputstr, String indexstr,
			boolean overlap) {
		if (inputstr == null) {
			return -1;
		}
		if (indexstr == null || indexstr == "") {
			return 0;
		}

		int no = 0;
		int indexlen = indexstr.length();
		while (true) {
			int position = inputstr.indexOf(indexstr);
			if (position != -1) {
				no++;
				if (overlap == true) {
					inputstr = inputstr.substring(position + 1);
				} else {
					inputstr = inputstr.substring(position + indexlen);
				}
				continue;
			}
			break;
		}
		return no;
	}

	/**
	 * split string with substring
	 * 
	 * @param inputstr
	 *            source string
	 * @param div
	 *            split string
	 * @return string array
	 */
	public static String[] split(String inputstr, String div) {
		if (inputstr == null) {
			return null;
		}

		String[] outputstr;
		int arraylength = StringUtils.indexCount(inputstr, div, false);
		if (arraylength == 0) {
			outputstr = new String[1];
			outputstr[0] = inputstr;
			return outputstr;
		}

		outputstr = new String[arraylength + 1];
		int divlength = div.length();
		for (int i = 0; i < arraylength; i++) {
			int position = inputstr.indexOf(div);
			outputstr[i] = inputstr.substring(0, position);
			inputstr = inputstr.substring(position + divlength);
		}
		outputstr[arraylength] = inputstr;
		return outputstr;
	}

	/**
	 * method: str2Array
	 * 
	 * @param input
	 * @param delim
	 * @return return type: String[]
	 */
	public static final String[] str2Array(String input, String delim) {
		if (input == null)
			throw new IllegalArgumentException(
					"StringUtil.str2Array(input,delim),input\u00CA\u00E4\u00C8\u00EB\u00CE\u00AA\u00BF\u00D5");
		ArrayList accountList = new ArrayList();
		StringTokenizer st = new StringTokenizer(input, delim);

		while (st.hasMoreTokens()) {
			String account = st.nextToken();

			accountList.add(account);
		}
		Object[] values = accountList.toArray();
		String[] returnValues = new String[values.length];
		for (int i = 0; i < returnValues.length; i++) {
			returnValues[i] = (String) values[i];
		}
		return returnValues;
	}

	/**
	 * html encode
	 * 
	 * @param str
	 *            source string
	 * @param newline
	 *            new line translate
	 * @param singleQuotes
	 *            singleQuote translate
	 * @return
	 */
	public static String htmlEncode(String str, boolean newline,
			boolean singleQuotes) {
		if (str == null) {
			return null;
		}

		str = doHTML(str);
		if (newline == true) {
			str = StringUtils.replace(str, "\n", "<br>");
		}
		if (singleQuotes == true) {
			str = StringUtils.replace(str, "'", "''");
		}
		return str;
	}

	/**
	 * get position of the substring of No.n
	 * 
	 * @param str
	 *            source string
	 * @param index
	 *            substring
	 * @param n
	 *            No.n
	 * @param caseSensitive
	 *            case sensitive
	 * @return -1 if any exception
	 */
	public static int indexOf(String str, String index, int n,
			boolean caseSensitive) {
		if (str == null || index == null || n <= 0) {
			return -1;
		}

		if (caseSensitive) {
			str = str.toUpperCase();
			index = index.toUpperCase();
		}

		int pos = -1;
		for (int i = 1; i <= n; i++) {
			pos += 1;
			pos = str.indexOf(index, pos);
			if (pos == -1)
				return pos;
		}
		return pos;
	}

	/**
	 * get position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index array
	 * @return -1 if any exception
	 */
	public static int indexOf(byte[] str, byte[] index) {
		if (str == null || index == null) {
			return -1;
		}

		int strlength = str.length;
		int indexlength = index.length;
		for (int i = 0; i < strlength; i++) {
			if (str[i] != index[0]) {
				continue;
			}
			for (int j = 0; j < indexlength; j++) {
				if (i + j >= strlength) {
					break;
				}
				if (str[i + j] != index[j]) {
					break;
				}
				if (j == indexlength - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * get position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index array
	 * @param from
	 *            from position
	 * @return -1 if any exception
	 */
	public static int indexOf(byte[] str, byte[] index, int from) {
		if (str == null || index == null) {
			return -1;
		}

		int strlength = str.length;
		int indexlength = index.length;
		if (from >= strlength) {
			return -1;
		}
		if (from < 0) {
			from = 0;
		}
		for (int i = from; i < strlength; i++) {
			if (str[i] != index[0]) {
				continue;
			}
			for (int j = 0; j < indexlength; j++) {
				if (i + j >= strlength) {
					break;
				}
				if (str[i + j] != index[j]) {
					break;
				}
				if (j == indexlength - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * get position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index string
	 * @return -1 if any exception
	 */
	public static int indexOf(byte[] str, String index) {
		if (str == null || index == null || index == "") {
			return -1;
		}

		byte[] indexbytes = null;
		indexbytes = index.getBytes();
		return StringUtils.indexOf(str, indexbytes);
	}

	/**
	 * get position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index string
	 * @param from
	 *            from position
	 * @return -1 if any exception
	 */
	public static int indexOf(byte[] str, String index, int from) {
		if (str == null || index == null || index == "") {
			return -1;
		}

		byte[] indexbytes = null;
		indexbytes = index.getBytes();
		return StringUtils.indexOf(str, indexbytes, from);
	}

	/**
	 * get position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index string
	 * @param enc
	 *            encoding of index string
	 * @param from
	 *            from position
	 * @return -1 if any exception
	 */
	public static int indexOf(byte[] str, String index, String enc, int from) {
		if (str == null || index == null || index == "") {
			return -1;
		}

		byte[] indexbytes = null;
		try {
			indexbytes = index.getBytes(enc);
		} catch (java.io.UnsupportedEncodingException e) {
			return -1;
		}
		return StringUtils.indexOf(str, indexbytes, from);
	}

	/**
	 * get last position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index string
	 * @return -1 if any exception
	 */
	public static int lastIndexOf(byte[] str, byte[] index) {
		if (str == null || index == null) {
			return -1;
		}

		int strlength = str.length;
		int indexlength = index.length;
		for (int i = strlength - 1; i >= 0; i--) {
			if (str[i] != index[0]) {
				continue;
			}
			for (int j = 0; j < indexlength; j++) {
				if (i + j >= strlength) {
					break;
				}
				if (str[i + j] != index[j]) {
					break;
				}
				if (j == indexlength - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * get last position of the substring
	 * 
	 * @param str
	 *            source array
	 * @param index
	 *            index string
	 * @param from
	 *            from position
	 * @return -1 if any exception
	 */
	public static int lastIndexOf(byte[] str, byte[] index, int from) {
		if (str == null || index == null) {
			return -1;
		}

		int strlength = str.length;
		int indexlength = index.length;
		if (from < 0) {
			return -1;
		}
		if (from > strlength - 1) {
			from = strlength - 1;
		}
		for (int i = from; i >= 0; i--) {
			if (str[i] != index[0]) {
				continue;
			}
			for (int j = 0; j < indexlength; j++) {
				if (i + j >= strlength) {
					break;
				}
				if (str[i + j] != index[j]) {
					break;
				}
				if (j == indexlength - 1) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * get last position of the substring
	 * 
	 * @param str
	 *            str source array
	 * @param index
	 *            index string
	 * @return -1 if any exception
	 */
	public static int lastIndexOf(byte[] str, String index) {
		if (str == null || index == null || index == "") {
			return -1;
		}

		byte[] indexbytes = null;
		indexbytes = index.getBytes();
		return StringUtils.lastIndexOf(str, indexbytes);
	}

	/**
	 * get last position of the substring
	 * 
	 * @param str
	 *            str source array
	 * @param index
	 *            index string
	 * @param from
	 *            from position
	 * @return -1 if any exception
	 */
	public static int lastIndexOf(byte[] str, String index, int from) {
		if (str == null || index == null || index == "") {
			return -1;
		}

		byte[] indexbytes = null;
		indexbytes = index.getBytes();
		return StringUtils.lastIndexOf(str, indexbytes, from);
	}

	/**
	 * get last position of the substring
	 * 
	 * @param str
	 *            str source array
	 * @param index
	 *            index string
	 * @param enc
	 *            encoding of index string
	 * @param from
	 *            from position
	 * @return -1 if any exception
	 */
	public static int lastIndexOf(byte[] str, String index, String enc, int from) {
		if (str == null || index == null || index == "") {
			return -1;
		}

		byte[] indexbytes = null;
		try {
			indexbytes = index.getBytes(enc);
		} catch (java.io.UnsupportedEncodingException e) {
			System.out.println(e);
		}
		return StringUtils.lastIndexOf(str, indexbytes, from);
	}

	/**
	 * check validility of string
	 * 
	 * @param str
	 * @return true if str is not null and str not equals ""
	 */
	public static boolean isValid(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * get an non exist file
	 * 
	 * @param path
	 *            path of file
	 * @param filename
	 *            default filename
	 * @return
	 */
	public static File getNonExistFile(File path, String filename) {
		if (!path.exists() || !path.isDirectory())
			return null;

		// variables
		int pos = -1;
		int posno = 0;
		String prefix = "";
		String postfix = "";
		String tempprefix = "";
		File newfile = null;

		// init
		pos = filename.lastIndexOf(".");
		if (pos == -1) {
			prefix = filename;
			postfix = "";
		} else {
			prefix = filename.substring(0, pos);
			postfix = filename.substring(pos + 1);
		}

		newfile = new File(path.getPath() + "/" + filename);
		while (newfile.exists()) {
			tempprefix = prefix + posno;
			if (postfix == "")
				filename = tempprefix;
			else
				filename = tempprefix + "." + postfix;
			newfile = new File(path.getPath() + "/" + filename);
			posno++;
		}
		return newfile;
	}

	/**
	 * get next letter with same capitalize
	 * 
	 * @param c
	 * @return a->b,A->B,z->a
	 */
	public static char getNextLetter(char c) {
		char nextLetter = (char) -1;

		if (Character.isLetter(c)) {
			nextLetter = (char) (c + 1);
			if (!Character.isLetter(nextLetter)) {
				nextLetter = (char) (nextLetter - 26);
			}
		}
		return nextLetter;
	}

	/**
	 * get a bigger String than str
	 * 
	 * @param str
	 * @return aa->ab,ZZZ->AAAA
	 */
	public static String getNextString(String str) {
		String nextString = null;

		char[] chars = new char[str.length()];
		str.getChars(0, str.length(), chars, 0);
		boolean add = false;
		char heada = 'a';
		char headA = 'A';

		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetter(chars[i]))
				return null;
		}

		for (int i = chars.length - 1; i >= 0; i--) {
			char oriChar = chars[i];
			chars[i] = getNextLetter(chars[i]);
			if (chars[i] > oriChar)
				break;
			if (i == 0)
				add = true;
		}

		nextString = new String(chars);
		if (add == true && Character.isLowerCase(chars[0]))
			nextString = heada + nextString;
		if (add == true && Character.isUpperCase(chars[0]))
			nextString = headA + nextString;

		return nextString;
	}

	/**
	 * get package name of the class
	 * 
	 * @param theClass
	 * @return eg:hyzou.tools<br>"" if the class with no package
	 */
	public static String getPackageName(Class theClass) {
		String packageName = "";

		String className = theClass.getName();
		if (className.lastIndexOf(".") != -1)
			packageName = className.substring(0, className.lastIndexOf("."));

		return packageName;
	}

	/**
	 * get length method: getLength
	 * 
	 * @param source
	 * @return return type: int
	 */
	public static int getLength(String source) {
		int len = 0;
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int highByte = c >>> 8;
			len += highByte == 0 ? 1 : 2;
		}
		return len;
	}

	/**
	 * get class name of the class
	 * 
	 * @param theClass
	 * @return eg:StringUtil
	 */
	public static String getClassName(Class theClass) {
		String className = theClass.getName();
		if (className.lastIndexOf(".") != -1)
			className = className.substring(className.lastIndexOf(".") + 1);

		return className;
	}

	/**
	 * get the absolute file path of the class
	 * 
	 * @param theClass
	 * @return
	 */
	public static String getClassPath(Class theClass) {
		return getClassPath(theClass.getName());
	}

	/**
	 * get the absolute file path of the class
	 * 
	 * @param theClass
	 * @return absolute path of class folder end with char '/'
	 */
	public static String getClassFolderPath(Class theClass) {
		return getClassFolderPath(theClass.getName());
	}

	/**
	 * get the absolute file path of the class
	 * 
	 * @param className
	 * @return
	 */
	public static String getClassPath(String className) {
		String classPath = null;

		if (!className.startsWith("/")) {
			className = "/" + className;
		}
		className = className.replace('.', '/');
		className = className + ".class";

		java.net.URL classUrl = new StringUtils().getClass().getResource(
				className);

		if (classUrl != null)
			classPath = classUrl.getFile().toString();

		return classPath;
	}

	/**
	 * get the absolute file path of the class folder
	 * 
	 * @param className
	 * @return path of class folder end with char '/'
	 */
	public static String getClassFolderPath(String className) {
		String classFolderPath = null;

		String classPath = getClassPath(className);
		if (classPath != null) {
			classFolderPath = classPath.substring(0,
					classPath.lastIndexOf("/") + 1);
		}

		return classFolderPath;
	}

	/**
	 * get next word of value from the index
	 * 
	 * @param value
	 * @param index
	 * @return a chinese word or a complete english word or a group of signs
	 *         without chinese word and space.<br>
	 *         null if value is null or value==""<br>
	 *         null if index<0 or index>=length of value.<br>
	 */
	public static String getNextWord(String value, int index, boolean wordSplit) {
		if (value == null || value.equals("") || index < 0
				|| index >= value.length())
			return null;

		if (wordSplit == true)
			return value.substring(index, index + 1);

		char firstChar = value.charAt(index);
		if (isChinese(firstChar))
			return value.substring(index, index + 1);
		else {
			int spacePos = value.indexOf(" ", index);
			int chinesePos = indexOfChinese(value, index);

			if (spacePos == -1 && chinesePos == -1)
				return value.substring(index);
			if (spacePos == -1)
				return value.substring(index, chinesePos);
			if (chinesePos == -1)
				return value.substring(index, spacePos + 1);

			if (chinesePos < spacePos)
				return value.substring(index, chinesePos);
			return value.substring(index, spacePos + 1);
		}
	}

	/**
	 * if is a chinese word, 255-65535
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		if (c > 255)
			return true;
		return false;
	}

	/**
	 * get the index of nearest chinese word
	 * 
	 * @param value
	 * @param index
	 * @return
	 */
	public static int indexOfChinese(String value, int index) {
		if (value == null || value.equals("") || index < 0
				|| index > value.length())
			return -1;

		for (int i = index; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c > 255)
				return i;
		}

		return -1;
	}

	/**
	 * get binary string of a byte array
	 * 
	 * @param data
	 * @return "" if data is null or length of data equals zero
	 */
	public static String getBinString(byte[] data) {
		if (data == null || data.length == 0)
			return "";

		StringBuffer sb = new StringBuffer();
		int eachData = 0;
		String eachByte;
		for (int i = 0; i < data.length; i++) {
			eachData = data[i];
			if (eachData < 0)
				eachData = eachData + 256;
			eachByte = Integer.toHexString(eachData);
			if (eachByte.length() == 1)
				eachByte = "0" + eachByte;
			sb.append(eachByte);
		}

		return sb.toString();
	}

	/**
	 * get binary data from a binary string
	 * 
	 * @param binStr
	 * @return byte[0] if data is null or length of data equals zero<br>
	 * @throws Exception
	 *             if length of binStr is odd
	 */
	public static byte[] getBinFromString(String binStr) throws Exception {
		if (binStr == null || binStr.length() == 0)
			return new byte[0];

		int length = binStr.length();
		if (length % 2 != 0)
			throw new Exception("invalid length of source string");

		byte[] data = new byte[length / 2];

		for (int i = 0; i < data.length; i++) {
			String s = binStr.substring(i * 2, i * 2 + 2);
			data[i] = (byte) Integer.parseInt(s, 16);
		}

		return data;
	}

	/**
	 * concat array to string, with string of split,null treat as ""
	 * 
	 * @param objs
	 * @param split
	 * @return null if objs is null
	 */
	public static String ArrayToStr(Object[] objs, String split) {
		if (objs == null)
			return null;

		if (split == null)
			split = "";

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < objs.length; i++) {
			if (i < objs.length - 1) {
				if (objs[i] == null)
					result.append(split);
				else
					result.append(objs[i]).append(split);
			} else if (objs[i] != null)
				result.append(objs[i]);
		}
		return result.toString();
	}

	/**
	 * print out rs
	 * 
	 * @param rs
	 * @throws Exception
	 */
	public static void printRS(ResultSet rs) throws Exception {
		ResultSetMetaData rsmd = rs.getMetaData();
		int numCols = rsmd.getColumnCount();

		while (rs.next()) {
			// System.out.println("-----------------------------------------");
			for (int i = 0; i < numCols; i++) {
				System.out.println("" + rsmd.getColumnLabel(i + 1) + "=: "
						+ rs.getString(i + 1));
			}
		}
	}

	// public static String ClassFormat(String str)
	// {
	// str.toLowerCase().c`
	// }

	public static String capitalize(String str) {
		if (!isValid(str))
			return str;
		StringBuffer sb = new StringBuffer(str.substring(0, 1).toUpperCase())
				.append(str.substring(1));
		return sb.toString();
	}

	/**
	 * Use to convert to url
	 * 
	 * @param location
	 * @return
	 */
	public static String location2Url(String location) {
		if (location == null)
			return null;
		String url = replace(location, "UNIEAP_URL_INTERROGATION", "?");
		url = replace(url, "UNIEAP_URL_SPLIT_MASK", "&");
		url = replace(url, "UNIEAP_URL_EQUAL_MASK", "=");
		url = replace(url, "UNIEAP_URL_BOOK_MASK", "#");
		url = replace(url, " ", "");
		return url;
	}

	/**
	 * Use to conver to location
	 * 
	 * @param url
	 * @return
	 */
	public static String url2Location(String url) {
		if (url == null)
			return null;
		String location = replace(url, "?", "UNIEAP_URL_INTERROGATION");
		location = replace(location, "&", "UNIEAP_URL_SPLIT_MASK");
		location = replace(location, "=", "UNIEAP_URL_EQUAL_MASK");
		location = replace(location, "#", "UNIEAP_URL_BOOK_MASK");
		return location;
	}

	/**
	 * Use to conver to location
	 * 
	 * @param url
	 * @return
	 */
	public static String getSingleString(String str, String divideFlag) {

		if (str.length() != 0) {
			String[] temp = StringUtils.split(str, divideFlag);
			str = "";
			for (int i = 0; i < temp.length; i++) {
				if (str.length() != 0) {
					String tempStr = str.substring(0, str.length() - 1);
					String[] tempStrArray = StringUtils.split(tempStr,
							divideFlag);
					int j = 0;
					for (; j < tempStrArray.length; j++) {
						if (temp[i].equals(tempStrArray[j])) {
							break;
						}
					}
					if (j == tempStrArray.length) {
						str = str + temp[i] + divideFlag;
					}

				} else {
					str = str + temp[i] + divideFlag;
				}

			}
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * <p>
	 * �ַ����д��е����ŵ���ǰ��������????�����ţ�Ϊ����װsql��ʱ������ת��
	 * </p>
	 * 
	 * @param orignstr
	 * @return
	 */
	public static String getESCSingleQuotes(String orignstr) {
		String oldstr = orignstr;
		if (oldstr == null || oldstr.equals("") || oldstr.trim().length() <= 0)
			return oldstr;

		String newstr = "";
		int singleQuotesInt = oldstr.indexOf("'");
		int endsite;

		while (singleQuotesInt >= 0) {
			newstr = newstr.concat(oldstr.substring(0, singleQuotesInt + 1))
					.concat("'");
			endsite = oldstr.length();
			oldstr = oldstr.substring(singleQuotesInt + 1, endsite);
			if (oldstr == null || oldstr.equals("")
					|| oldstr.trim().length() <= 0)
				singleQuotesInt = -1;
			else
				singleQuotesInt = oldstr.indexOf("'");
		}
		if (oldstr.length() > 0)
			newstr = newstr.concat(oldstr);

		return newstr;
	}

	/**
	 * <p>
	 * ��ҳ��content����ȡͼƬ��Ϣ����ȡͼƬ��·�����ļ�������Ҫ??.gif�ļ�??
	 * </p>
	 * 
	 * @param content
	 * @return
	 */
	public static String[] getImageUrlInfo(String content) {

		String extractString = "";

		int startPosition = 0;
		int endPosition = 0;
		String remainString = content;

		for (int i = 0; i < remainString.length() && startPosition != -1; i++) {
			startPosition = remainString.indexOf("images");
			if (startPosition != -1) {
				remainString = remainString.substring(startPosition);
				endPosition = remainString.indexOf("\"");
				extractString = extractString
						+ remainString.substring(0, endPosition) + ",";
				remainString = remainString.substring(endPosition);
			}
		}
		if (extractString.length() != 0)
			extractString = extractString.substring(0,
					extractString.length() - 1);
		// System.out.println("extractString===" + extractString);
		return str2Array(extractString, ",");
	}

	/**
	 * <p>
	 * html encode
	 * </p>
	 * 
	 * @param strSource
	 * @return
	 */
	public static String doHTML(String strSource) {
		String strDest = doReplace(strSource, "&", "&amp;");
		strDest = doReplace(strDest, "<", "&lt;");
		strDest = doReplace(strDest, ">", "&gt;");
		strDest = doReplace(strDest, "'", "&apos;");
		strDest = doReplace(strDest, "\"", "&quot;");

		return strDest;
	}

	/**
	 * <p>
	 * replace string
	 * </p>
	 * 
	 * @param strSource
	 * @param strFrom
	 * @param strTo
	 * @return
	 */
	public static String doReplace(String strSource, String strFrom,
			String strTo) {
		if (strSource == null) {
			return null;
		}

		String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;

		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;

		return strDest;
	}

	/**
	 * <p>
	 * ??0000000xx" ----> "xx"
	 * </p>
	 * 
	 * @param origStr
	 * @return
	 */
	public static String trimHeadZero(String origStr) {
		return replace(origStr, "0", "");
	}

	/**
	 * <p>
	 * �ı�תΪʮ������??
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String text2Hex(String str) {
		if (str == null || str.trim().length() == 0)
			return "";
		str = str.trim();
		int strlen = str.length();
		StringBuffer hexString = new StringBuffer((strlen * 3));// ����������UTF-8����

		for (int i = 0; i < strlen; ++i) {
			int decimal = str.charAt(i); // ȡ��ASCII??
			String hex = Integer.toHexString(decimal);
			if (decimal <= 255) {
				/**
				 * ��׼ASCII����չASCII�Լ�UTF-8��������????����
				 */
				int trailingZeros = 2 - hex.length();
				for (int j = 0; j < trailingZeros; ++j)
					hexString.append("0");
			} else {
				int trailingZeros = 4 - hex.length();
				for (int k = 0; k < trailingZeros; ++k)
					hexString.append("0");
			}
			hexString.append(hex);
			hexString.append(" ");
		}
		return hexString.toString();
	}

	/**
	 * 
	 * <p>
	 * ��javascript��var������??��html�����ж�textareaֵ����javabean��??javabean�е��ַ������л��з�<br>
	 * ���� var inhtml="<textarea name='txt1'></textarea>";<br>
	 * txt1.innerText='��� �ú�';<br>
	 * ��ʱ����Ҫ�ѻ��з��ŵ�ת��\r??
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String textareaHtml(String str) {
		if (str == null) {
			return null;
		}

		str = replace(str, "\"", "&quot;");
		str = replace(str, " ", "&nbsp;");
		str = replace(str, "<", "&lt;");
		str = replace(str, ">", "&gt;");

		// ////System.out.println("yyyyyyyy==="+str.indexOf("\r"));
		str = replace(str, "\r", "");
		str = replace(str, "\n", "\r");
		str = replace(str, "'", "''");
		return str;
	}
	
	public static String textareaToHtml(String str) {
		if (str == null) {
			return null;
		}
		str = replace(str, "\"", "&quot;");
		str = replace(str, " ", "&nbsp;");
		str = replace(str, "<", "&lt;");
		str = replace(str, ">", "&gt;");
		str = replace(str, "\r", "<br/>");
		str = replace(str, "\n", "<br/>");
		str = replace(str, "'", "''");
		str = replace(str, "\"", "\"\"");
		return str;
	}
	
	public static String htmlToText(String str) {
		if (str == null) {
			return null;
		}
		str = str.replaceAll("\\s+", "");// ����????�ո�;
		str = str.replaceAll("<\\/?[^>]*>", ""); // ȥ��HTML tag
		str = str.replaceAll("[ | ]*\n", ""); // ȥ����β�հ�
		str = str.replaceAll("\\n[\\s| | ]*\r", "\n"); // ȥ���������
		str = replace(str, "&quot;", "\"");
		str = replace(str, "&nbsp;", " ");// ȥ��&nbsp;
		str = replace(str, "&lt;", "<");
		str = replace(str, "&gt;", ">");
		
		return str;
	}

	/**
	 * <p>
	 * ��javascript��var������??��html�����ж�textareaֵ����javabean��??javabean�е��ַ������л��з�<br>
	 * ���� var inhtml="<textarea name='txt1'></textarea>";<br>
	 * txt1.innerText='��� �ú�';<br>
	 * ��ʱ����Ҫ�ѻ��з��ŵ�ת��\r??
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String textareaVar(String str) {
		if (str == null) {
			return null;
		}

		str = replace(str, "\"", "&quot;");
		str = replace(str, " ", "&nbsp;");
		str = replace(str, "<", "&lt;");
		str = replace(str, ">", "&gt;");
		// ////System.out.println("yyyyyyyy==="+str.indexOf("\r"));
		str = replace(str, "\r", "");
		str = replace(str, "\n", "\\r");
		str = replace(str, "'", "''");
		return str;
	}

	/**
	 * <p>
	 * �õ�title<>����??
	 * </p>
	 * 
	 * @param title
	 * @return
	 */
	public static String getTitleInfo(String title) {

		// String extractString = "";

		int startPosition = 0;
		int endPosition = 0;
		String remainString = title;

		for (int i = 0; i < remainString.length() && startPosition != -1
				&& endPosition != -1; i++) {
			startPosition = remainString.indexOf("<");
			endPosition = remainString.indexOf(">");
			if (startPosition != -1 && endPosition != -1) {
				remainString = remainString.substring(0, startPosition)
						+ remainString.substring(endPosition + 1);
			}
		}
		return remainString;
	}

	/**
	 * <p>
	 * �ϲ��ַ�??
	 * </p>
	 * 
	 * @param src
	 *            ԭ�ַ���
	 * @param length
	 *            Ҫ��ĳ�??
	 * @param mode
	 *            ģʽ 01=�ұ߲���??02=��߲���
	 * @param fill
	 *            ������ַ���
	 * @return
	 */
	public static String fill(String src, int length, String mode, String fill) {

		if (src == null || src.length() < 1) {
			return src;
		}

		if (mode == null || (!mode.equals("01") && !mode.equals("02"))) {
			return src;
		}

		if (length < 1) {
			return src;
		}

		if (fill == null) {
			return src;
		}

		StringBuffer buffer = null;

		if (mode.equals("01")) {

			buffer = new StringBuffer(src);

			for (int i = src.length(); i < length; i++) {
				buffer.append(fill);
			}
		} else {

			buffer = new StringBuffer("");

			for (int i = src.length(); i < length; i++) {
				buffer.append(fill);
			}

			buffer.append(src);
		}

		return buffer.toString();
	}
	
	/**
	 * sql ��ע���??
	 * @param str
	 * @return
	 */
	public static String sqlStrFilter(String str){
		if(str==null || "".equals(str))
			return str;
		
		String re = "";
		re = str.replaceAll("'", "''").trim();
		
		return re;
	}
	
	public static String tempEncoding(String src,String oldName,String newName) throws UnsupportedEncodingException
	{
		return new String(src.getBytes(oldName),newName);
	}
	
	public static String subString(String string,int begin,int end)
	{
		if(begin < 0)
				begin = 0;
		if(end > string.length())
			end = string.length();
		if(begin <= end)
			return string.substring(begin, end);
		else
			return "";
	}
	
	public String subString(String string,int begin)
	{
		if(begin < 0)
			begin = 0;
		if(begin >= string.length())
			return "";
		return string.substring(begin);
	}
	
	public static String parseToString(Object obj){
		if(obj==null){
			return null;
		}else{
			return String.valueOf(obj);
		}
	}
	
	public static long parseToLong(Object obj){
		if(obj==null){
			return 0;
		}else{
			return Long.parseLong(String.valueOf(obj));
		}
	}
	
	public static int parseToInt(Object obj){
		if(obj==null){
			return 0;
		}else{
			return Integer.parseInt(String.valueOf(obj));
		}		
	}
	
	public static Timestamp parseToTimestamp(Object obj){
		if(obj==null){
			return null;
		}else{
			return Timestamp.valueOf(String.valueOf(obj));
		}
	}
	
	public static String cutStrBufferSuffix(StringBuffer sb){
		if(sb == null || sb.length()<=0)
			return "";
		int pos = sb.length();
		if(pos>0 && sb.charAt(pos-1)== ','){
			sb.deleteCharAt(pos-1);
		}
		return sb.toString();
	}
	
		/**
		 * �滻ģ���ļ�����
		 * �滻��־Ϊ��${}
		 * @param template ģ��ԭ��
		 * @param data<String,String> ����???? 
		 * @return
		 * @throws Exception
		 */
	    public static String composeTemplate(String template, Map data)
	            throws Exception {
	        String regex = "\\$\\{(.+?)\\}";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(template);
	        /*
	         * sb�����洢�滻�������ݣ�����Ѷ�δ�������ַ�����Դ�ַ���??
	         * �洢����??
	         */
	        StringBuffer sb = new StringBuffer();
	        while (matcher.find()) {
	            String name = matcher.group(1);//����
	            String value = (String) data.get(name);//��??
	            if (value == null) {
	                value = "";
	            } else {
	                /*
	                 * ת�������е�$�ַ�
	                 * Ҫ�� $ �滻??\$ ����Ҫʹ??\\\\\\& ���滻����Ϊ???? \ Ҫʹ??\\\ ����
	                 * ���滻����һ??$ Ҫʹ??\\$ �������滻��??\ ?? $ ����Ϊ�滻����ʱ����??
	                 * �����ַ�?? �ַ���ʾ���������飬??\ �ַ���������ת�� $ �ַ���??
	                 */
	                value = value.replaceAll("\\$", "\\\\\\$");	                
	            }
	            /*
	             * ���⣬����������ʹ��Matcher�����appendReplacement()�����������滻������??
	             * ����ʹ��String�����replaceAll()��replaceFirst()�����������滻��������Ϊ
	             * ���Ƕ���ֻ�ܽ���????�Լ򵥵��滻������??��ֻ���滻��????�����ݣ�����������Ҫ��ÿ
	             * ????ƥ��ʽ���滻ֵ����ͬ�����Ծ�ֻ����ѭ����ʹ��appendReplacement��ʽ������??
	             * ���滻��??
	             */
	            matcher.appendReplacement(sb, value);
	        }
	        //????����Ҫ��β���ӵ����滻�����ݺ���ȥ������β��Ϊ??����ӭ�´ι��٣�??
	        matcher.appendTail(sb);
	        return sb.toString();
	    }
	    
	    /**
	     * ����ʽ���ı�ת����html��ʽ
	     * @param str
	     * @return
	     */
	    public static String textToHtml(String str) {
	    	str = "<p>" + str;
	    	//�Ƚ������滻��������??
	    	str = doReplace(str, "\n\r", "#@$"); // ����
	    	str = doReplace(str, "\r\n", "#@$"); // ����
	    	str = doReplace(str, "\r", "#@$"); // ����
	    	str = doReplace(str, "\n", "#@$"); // ����
	    	//�ٽ��������������ַ��滻��һ??
	    	str = doReplace(str, "#@$", "</p><p>"); // ����
	    	str = doReplace(str, "\\> ", "\\>&nbsp;"); // �հ׻���??
	    	str = doReplace(str, " \\<", "&nbsp;\\<"); // �հ׻���??
	    	str = doReplace(str, "  ", " &nbsp;"); // �հ׻���??
	    	str = str + "</p>";
	    	return str;
	    };
	    /**
	     * �ϲ�CNML��??��??<br/>
	     * "~"�ָ���????
	     * @param valueStrings
	     * @return
	     */
	    public static String mergeCnmlStringValue(String...valueStrings) {
			if(valueStrings == null) return null;
			Set<String> attrSet = new HashSet<String>();
			for(String valueString : valueStrings) {
				if(valueString!=null&&!"".equals(valueString)){
					for(String valueNode : valueString.split("~")) {
						attrSet.add(valueNode);
					}
				}
			}
			Iterator<String> it = attrSet.iterator();
			StringBuilder saveStringValue = new StringBuilder();
			while(it.hasNext()) {
				if(saveStringValue.length() > 0) {
					saveStringValue.append("~");
				}
				saveStringValue.append(it.next());
			}
			return saveStringValue.toString();
	    }
	    
	    /**
	     * DOC_NAME conert docName
	     * @param colum
	     * @return
	     */
	    public static String creatProperty(String colum){
			String property = "";
			if(colum.indexOf("_")== -1){
				property = colum.toLowerCase();
			}else{
				String[] letters = colum.split("_");
				for (int i = 0; i < letters.length; i++) {
					 if(i==0){
						 property += letters[i].toLowerCase();
					 }else{
						 String fristLetter =  letters[i].substring(0, 1).toUpperCase();
						 String outFristLetter = letters[i].substring(1, letters[i].length()).toLowerCase();
						 property+=(fristLetter+outFristLetter);
					 }
				}
				
			}
			return property;
		}
	    
	    /**
	     * DOC_NAME conert getDocName
	     * @param colum
	     * @return
	     */
		public static String creatGetProperty(String colum){
			String property = "";
			if(colum.indexOf("_")== -1){
				property = colum.toLowerCase();
			}else{
				String[] letters = colum.split("_");
				for (int i = 0; i < letters.length; i++) {
					 if(i==0){
						 property += letters[i].toLowerCase();
					 }else{
						 String fristLetter =  letters[i].substring(0, 1).toUpperCase();
						 String outFristLetter = letters[i].substring(1, letters[i].length()).toLowerCase();
						 property+=(fristLetter+outFristLetter);
					 }
				}
				
			}
			String fristLetter = property.substring(0, 1).toUpperCase();
			property ="get"+fristLetter+property.substring(1, property.length());
			return property;
		}
		
		/**
	     * DOC_NAME conert setDocName
	     * @param colum
	     * @return
	     */
		public static String creatSetProperty(String colum){
			String property = "";
			if(colum.indexOf("_")== -1){
				property = colum.toLowerCase();
			}else{
				String[] letters = colum.split("_");
				for (int i = 0; i < letters.length; i++) {
					 if(i==0){
						 property += letters[i].toLowerCase();
					 }else{
						 String fristLetter =  letters[i].substring(0, 1).toUpperCase();
						 String outFristLetter = letters[i].substring(1, letters[i].length()).toLowerCase();
						 property+=(fristLetter+outFristLetter);
					 }
				}
				
			}
			String fristLetter = property.substring(0, 1).toUpperCase();
			property ="set"+fristLetter+property.substring(1, property.length());
			return property;
		}
				
		/**
		 * �Ƿ�����ͬ�ַ���,���ִ�С??
		 * @param testStr
		 * @param anObject
		 * @return
		 */
		public static boolean equals(String testStr, String...anObject) {
			for (String string : anObject) {
				if(testStr.equals(string)) return true;
			}
			return false;
		}
		/**
		 * �Ƿ�����ͬ�ַ���,�����ִ�Сд.
		 * @param testStr
		 * @param anObject
		 * @return
		 */
		public static boolean equalsIgnoreCase(String testStr, String...anObject) {
			for (String string : anObject) {
				if(testStr.equalsIgnoreCase(string)) return true;
			}
			return false;
		}
		
		/**
		 * ƴװvido��ǩhtml>
		 * @param imageName
		 * @return
		 */
		public static String getVideoHtmlTag(String videoName) {
			return "<div><video src = \"" + videoName+ "\" autoplay=\"autoplay\"> </video></div>";
		}
		
		/**
		 * ƴװimg��ǩ??html>??
		 * @param imageName
		 * @return
		 */
		public static String getImageHtmlTag(String imageName) {
			return "<div><img alt=\"\" src=\"" + imageName + "\" /></div>";
		}
		
		/**
		 * �ж��ַ������Ƿ�������ӡ�����ͼƬ
		 * @param content
		 * @return
		 */
		public static boolean hasHtmlTage(String htmlContent) {
			boolean itWas = false;
			Pattern pattern = Pattern.compile("<\\s*(img|table|a)\\s+([^>]*)\\s*>", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(htmlContent);
			if(matcher.find()) {
				itWas = true;
			}
			return itWas;
		}
	
		/**
		 * ����??
		 * @param object
		 * @return
		 */
		public static byte[] serialize(Object object) {
	        ObjectOutputStream oos = null;
	        ByteArrayOutputStream baos = null;
	        try {
	            baos = new ByteArrayOutputStream();
	            oos = new ObjectOutputStream(baos);
	            oos.writeObject(object);
	            byte[] bytes = baos.toByteArray();
	            return bytes;
	        } catch (Exception e) {
	        	
	        }
	        return null;
	    }
	
		/**
		 * �����л�
		 * @param bytes
		 * @return
		 */
		public static Object unserialize(byte[] bytes) {
	        ByteArrayInputStream bais = null;
	        try {
	            bais = new ByteArrayInputStream(bytes);
	            ObjectInputStream ois = new ObjectInputStream(bais);
	            return ois.readObject();
	        } catch (Exception e) {
	
	        }
	        return null;
	    }
		
		/**
		 * ��֤������??
		 * @param regex
		 * @param str
		 * @return
		 */
		public static boolean match(String regex, String str) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(str);
			return matcher.matches();
		}
		
		/**
		 * �ַ�����??
		 * @param str1
		 * @param str2
		 * @param linkVal
		 * @return
		 */
		public static String addTwoValue (String str1, String str2, String linkVal) {
			String uStr = "";
			if(linkVal == null) {
				linkVal = "";
			}
			if(isEmpty(str1)) {
				uStr = "";
			} else {
				uStr = str1;
			}
			if(isEmpty(str2)) {
				return uStr;
			} else {
				if(isEmpty(uStr)) {
					uStr = str2;
				} else {
					uStr = str1 + linkVal + str2;
				}
			}
			return uStr;
		}
		
		/**
		 * �ַ�����??
		 * @param str1
		 * @param str2
		 * @param linkVal
		 * @return
		 */
		public static String addTwoValueIfNotExist (String str1, String str2, String linkVal) {
			String uStr = "";
			if(linkVal == null) {
				linkVal = "";
			}
			if(isEmpty(str1)) {
				uStr = "";
			} else {
				uStr = str1;
			}
			if(isEmpty(str2)) {
				return uStr;
			} else {
				if(isEmpty(uStr)) {
					uStr = str2;
				} else if(str1.indexOf(str2) == -1) {
					uStr = str1 + linkVal + str2;
				}
			}
			return uStr;
		}
		
		/**
		 * �ַ�����??
		 * @param str1
		 * @param str2
		 * @param linkVal
		 * @return
		 */
		public static String addTwoValueIfNotEqual (String str1, String str2) {
			if(isEmpty(str2)) {
				return str1;
			} else {
				if(isEmpty(str1)) {
					return str2;
				} else if(str2.equals(str1)) {
					return str2;
				}
			}
			return null;
		}
		
}
