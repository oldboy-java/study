package com.imooc.jsm.broker;

import java.net.URI;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class InnerBroker {

	public static void main(String[] args) throws Exception{
		start1();
		
		
		
		
		
	}
	
	
	public static void start1() throws Exception{
		BrokerService broker = new BrokerService();
		broker.setUseJmx(true);
		broker.setPersistent(false);
		broker.addConnector("tcp://localhost:61616");
		broker.start();
	}
	
	
}
