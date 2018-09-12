package com.qtrmoon.util;

import java.util.UUID;

import org.apache.log4j.Logger;

public class UuidUtil {
	
	protected static Logger logger = Logger.getLogger(UuidUtil.class);

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "").toLowerCase();
		return uuid;
	}
	
	public static void main(String[] args) {
		logger.info(get32UUID());
	}
}

