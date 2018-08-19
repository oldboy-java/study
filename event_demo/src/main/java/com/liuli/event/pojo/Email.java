package com.liuli.event.pojo;

import java.io.Serializable;

public class Email implements Serializable {

	private String sender;
	private String receiver;
	private String title;
	private String content;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Email(String sender, String receiver, String title, String content) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.content = content;
	}
	public Email() {
		super();
	}
	
	
}
