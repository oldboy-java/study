package com.liuli.event.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.SerializationUtils;

import com.liuli.event.pojo.Email;
import com.liuli.event.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(Email email) {
		try {
			FileCopyUtils.copy(SerializationUtils.serialize(email), new File("d:/email1/"+email.getTitle()));
		} catch (IOException e) {
			throw new RuntimeException("发生了IO异常,异常信息:"+e.getMessage());
			
		}
	}

}
