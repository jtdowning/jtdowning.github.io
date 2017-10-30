package com.techelevator.npgeek.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Park {

	private String name;
	private String state;
	private String description;
	private String parkCode;
	private int acreage;
	private int elevationInFeet;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private int entryFee;
	private int numberOfAnimalSpecies;
	private float milesOfTrail;
	private List<Forecast> parkForecasts = new ArrayList<>();
	private int count;
	NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
	
	public String getParkCode() {
		return parkCode;
	}
	public String getAcreage() {
		String acreageString = numberFormat.format(acreage);
		return acreageString;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public String getElevationInFeet() {
		String elevationString = numberFormat.format(elevationInFeet);
		return elevationString;
	}
	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public String getAnnualVisitorCount() {
		String visitorString = numberFormat.format(annualVisitorCount);
		return visitorString;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}
	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}
	public String getEntryFee() {
		String entryFeeString = moneyFormat.format(entryFee);
		return entryFeeString;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	public String getMilesOfTrail() {
		String trailString = numberFormat.format(milesOfTrail);
		return trailString;
	}
	public void setMilesOfTrail(float milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String location) {
		this.state = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Forecast> getParkForecasts() {
		return parkForecasts;
	}
	public void setParkForecasts(List<Forecast> parkForecasts) {
		this.parkForecasts = parkForecasts;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
