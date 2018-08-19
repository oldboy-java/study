package com.liuli.ssm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuli.ssm.mapper.TFlightMapper;
import com.liuli.ssm.pojo.TFlight;
import com.liuli.ssm.pojo.TFlightExample;


@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private TFlightMapper flightMapper;
	
	public void addFlight(TFlight flight) {
		flightMapper.insert(flight);
	}

	public List<TFlight> getTFlights() {
		TFlightExample example = new TFlightExample();
		return flightMapper.selectByExample(example);
	}

}
