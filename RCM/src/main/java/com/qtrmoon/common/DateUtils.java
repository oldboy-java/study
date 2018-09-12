package com.qtrmoon.common;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateUtils {

	/***
	 * 将日期格式化成指定格式的字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String  formatDate(Date date,String pattern){
		DateTime dateTime = Date2DateTime(date);
		return dateTime.toString(pattern);
	}
	
	/**
	 * 日期字符串格式化指定格式
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String  formatDate(String date,String pattern){
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(pattern);
	}
	
	/***
	 * 将Date转换成joda-time的DateTime
	 * @param date
	 * @return
	 */
	public static DateTime Date2DateTime(Date date){
		return new DateTime(date);
	}
	
	
	/***
	 * 将joda-time的DateTime转成Date
	 * @param dateTime
	 * @return
	 */
	public Date DateTime2Date(DateTime dateTime){
		return dateTime.toDate();
	}
	
	/***
	 * 将字符串转成Date
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String date,String pattern){
		DateTime dateTime = new DateTime(date);
		DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);  
		return dateTime.parse(date, formatter).toDate();
	}
	
	
	
	/**
	 * 计算年份差值
	 * @param date
	 * @param csnf
	 * @return
	 */
	public static  int yearSubtraction(Date date,Integer csnf){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR) - csnf;
	}
	
	public static void main(String[] args) {
		System.err.println(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
	}
	
	
}
