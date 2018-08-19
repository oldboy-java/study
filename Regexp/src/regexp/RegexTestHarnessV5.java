package regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarnessV5 {   
	   
    public static void main(String[] args) {   
    	reg();
    }
    
    public static void reg2(){
    	 String s = "2014-09-23";
	    	
 	    // 反向引用(\\d{4})\\1-\\d{2}-\\d{2}，其中\\1是转义了，是引用匹配到的第一个分组即2014
 	    //20142014-09-23,返回true
 	   // System.out.println(s.matches("(\\d{4})\\1-\\d{2}-\\d{2}"));
 	    
 	   Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
 	   Matcher matcher = pattern.matcher(s);
 	   while (matcher.find()) {
 		System.out.println(matcher.group(1)+"&&"+matcher.group(2)+"&&"+matcher.group(3));
 	   }
 	   
 	   //字符串替换
 	   System.out.println(s.replaceAll("(\\d{4})-(\\d{2})-(\\d{2})","$1*$2*$3"));
    }
    
    public static void reg(){
    	Scanner scanner = new Scanner(System.in);   
        while (true) {   
            System.out.printf("%nEnter your regex: "); 
            //1. 编译正则表达式
            Pattern pattern = Pattern.compile(scanner.nextLine(),Pattern.CASE_INSENSITIVE);   
            System.out.printf("Enter input string to search: ");   
            
            // 2. 根据输入字符串，获取匹配器Matcher
            Matcher matcher = pattern.matcher(scanner.nextLine());   
            boolean found = false;   
            
            // 3. 循环匹配结果
            while (matcher.find()) {   
                System.out.printf(   
                        "I found the text \"%s\" starting at index %d and ending at index %d.%n",   
                        matcher.group(), matcher.start(), matcher.end()   
                    );   
                found = true;   
            }   
            if (!found) {   
                System.out.printf("No match found.%n");   
            }   
        }   
    }   
    
} 