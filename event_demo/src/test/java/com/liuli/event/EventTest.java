package com.liuli.event;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuli.event.service.FlightService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class EventTest {

	
	@Resource
	private FlightService flightService;
	
	@Test
	public void test() {
		flightService.orderFlight(12, "HN006");
	}

}
