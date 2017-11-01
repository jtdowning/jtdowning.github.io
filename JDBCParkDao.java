package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDao implements ParkDao{
	
	private  JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		allParks = createParkFromSqlRowSet(results);
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		String sqlSelectAllParks = "SELECT * FROM park " +
								  "WHERE parkCode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks, parkCode.toUpperCase());
		List<Park> parkByParkCode = createParkFromSqlRowSet(results);
		return parkByParkCode.get(0);
	}
	
	@Override
	public List<Park> getTopFiveParks() {
		List<Park> topFiveParks = new ArrayList<Park>();
		String sqlSelectAllSurveys = "SELECT park.* " + 
									"FROM survey_result " + 
									"JOIN park ON park.parkCode = survey_result.parkCode " + 
									"GROUP BY park.parkCode " + 
									"ORDER BY COUNT(*) DESC " + 
									"LIMIT 5;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		return createParkFromSqlRowSet(results);
	}
	
	public List<Park> createParkFromSqlRowSet(SqlRowSet results) {
		List<Park> allParks = new ArrayList<>();
		while(results.next()) {
			Park park = new Park();
			park.setName(results.getString("parkName"));
			park.setState(results.getString("state"));
			park.setDescription(results.getString("parkDescription"));
			park.setParkCode(results.getString("parkCode").toLowerCase());
			park.setAcreage(results.getInt("acreage"));
			park.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
			park.setClimate(results.getString("climate"));
			park.setElevationInFeet(results.getInt("elevationInFeet"));
			park.setEntryFee(results.getInt("entryFee"));
			park.setInspirationalQuote(results.getString("inspirationalQuote"));
			park.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
			park.setMilesOfTrail(results.getFloat("milesOfTrail"));
			park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
			park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
			park.setYearFounded(results.getInt("yearFounded"));
			allParks.add(park);
		}
		return allParks;
	}
}
