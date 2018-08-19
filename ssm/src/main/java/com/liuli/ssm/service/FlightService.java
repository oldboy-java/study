package com.liuli.ssm.service;

import java.util.List;

import com.liuli.ssm.annotation.DataSource;
import com.liuli.ssm.pojo.TFlight;
import com.liuli.ssm.util.datasource.Source;

public interface FlightService {

	@DataSource(Source.master)
	public void addFlight(TFlight flight);
	
	@DataSource(Source.slave)
	public List<TFlight> getTFlights();
}
