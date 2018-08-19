package com.liuli.ssm.test;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuli.ssm.pojo.TFlight;
import com.liuli.ssm.service.FlightService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class FlightServiceTest {

	
	@Resource
	private FlightService flightService;
	
	@Test
	public void test() {
		Page page = PageHelper.startPage(2, 4);
		List<TFlight> flights = flightService.getTFlights();
		for(TFlight flight:flights) {
			System.out.println(flight);
		}
		
		System.err.println(page.getPages() + "--"+page.getTotal());
	}

	@Test
	public void testSaveFlight() {
		TFlight flight = new TFlight();
		flight.setFlightCode("MH001");
		flight.setUser(12);
		flight.setOrderTime(new Date());
		flightService.addFlight(flight);
	}
}
