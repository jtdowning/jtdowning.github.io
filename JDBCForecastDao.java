package com.techelevator.npgeek.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCForecastDao implements ForecastDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCForecastDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Forecast> getAllForecasts() {
		String sqlSelectAllForecasts = "SELECT * FROM weather";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllForecasts);
		return createForecastsFromSqlRowSet(results);
	}

	@Override
	public List<Forecast> getForecastsForPark(String parkCode) {
		String sqlSelectAllForecasts = "SELECT * FROM weather " +
									  "WHERE parkCode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllForecasts, parkCode.toUpperCase());
		List<Forecast> forecastByParkCode = createForecastsFromSqlRowSet(results);
		return forecastByParkCode;
	}

	private List<Forecast> createForecastsFromSqlRowSet(SqlRowSet results) {
		List<Forecast> allForecasts = new ArrayList<>();
		while(results.next()) {
			Forecast forecast = new Forecast();
			forecast.setParkCode(results.getString("parkCode"));
			int forecastDay = results.getInt("fiveDayForecastValue");
			LocalDate date = LocalDate.now().plus(forecastDay - 1, ChronoUnit.DAYS);
			forecast.setDate(date);
			forecast.setHigh(results.getInt("high"));
			forecast.setLow(results.getInt("low"));
			forecast.setForecastDescription(results.getString("forecast"));
			forecast.setRecommendation();
			forecast.setImgSrc(forecast.getForecastDescription());
			allForecasts.add(forecast);
		}
		return allForecasts;	
	}

}
