package com.techelevator.npgeek.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Survey {
	private String email;
	private String state;
	private String activityLevel;
	private String parkCode;
	
//	@Autowired
//	public Survey(String email, String state, String activityLevel, String parkCode) {
//		this.email = email;
//		this.state = state;
//		this.activityLevel = activityLevel;
//		this.parkCode = parkCode;
//	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
}
