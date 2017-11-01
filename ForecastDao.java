package com.techelevator.npgeek.model;

import java.util.List;

public interface ForecastDao {

	public List<Forecast> getAllForecasts();
	public List<Forecast> getForecastsForPark(String parkCode);
	
	
}
