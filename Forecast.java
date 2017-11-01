package com.techelevator.npgeek.model;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Forecast {
	
	private String parkCode;
	private LocalDate date;
	private int low;
	private int high;
	private String forecastDescription;
	private String recommendation;
	private String imgSrc;
	NumberFormat tempFormat = NumberFormat.getNumberInstance(Locale.US);
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLowString() {
		tempFormat.setMinimumFractionDigits(1);
		String lowString = tempFormat.format(low);
		return lowString;
	}
	
	public int getLow() {
		return low;
	}
	
	public void setLow(int low) {
		this.low = low;
	}
	
	public int getHigh() {
		return high;
	}
	
	public String getHighString() {
		tempFormat.setMinimumFractionDigits(1);
		String highString = tempFormat.format(high);
		return highString;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecastDescription() {
		return forecastDescription;
	}
	public void setForecastDescription(String forecastDescription) {
		this.forecastDescription = forecastDescription;
	}
	
	public void setRecommendation() {
		if(this.forecastDescription.equals("snow")) {
			this.recommendation = "Make sure to pack snowshoes!";
		} else if (this.forecastDescription.equals("rain")) {
			this.recommendation = "Pack your rain gear and wear waterproof shoes!";
		} else if (this.forecastDescription.equals("thunderstorms")) {
			this.recommendation = "Seek shelter and avoid hiking on exposed ridges!";
		} else if (this.forecastDescription.equals("sun")) {
			this.recommendation = "Make sure to pack sunblock!";
		} else if (this.getHigh() >= 75) {
			this.recommendation = "Bring an extra gallon of water!";
		} else if (this.getHigh() - this.getLow() > 20) {
			this.recommendation =  "Wear breathable layers!";
		} else if (this.getLow() < 20) {
			this.recommendation =  "Be careful of exposure to frigid temperatures!";
		}
	}
	
	public String getRecommendation() {
		return recommendation;
	}
	
	public void setImgSrc(String forecastDescription) {
		if (forecastDescription.equals("partly cloudy")) {
			this.imgSrc = "img/weather/partlyCloudy.png";
		} else {
			this.imgSrc = "img/weather/" + forecastDescription + ".png";
		}
	}
	
	public String getImgSrc() {
		return imgSrc;
	}

}
