package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;
	private ParkDao parkDao;
	
	@Autowired
	public JDBCSurveyDao(DataSource dataSource, ParkDao parkDao) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.parkDao = parkDao;
	}

	@Override
	public void addSurveyResult(Survey survey) {
		String sqlGetNextId = "SELECT nextval ('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetNextId);
		results.next();
		long id = results.getLong(1);
		String sqlCreateSurveyResult = "INSERT INTO survey_result (surveyId, parkCode, emailAddress, state, activityLevel) " +
									  "VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlCreateSurveyResult, id, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
	}
	
}
