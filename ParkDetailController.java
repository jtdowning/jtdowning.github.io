package com.techelevator.npgeek;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Forecast;
import com.techelevator.npgeek.model.ForecastDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;

@SessionAttributes("isCelsius")
@Controller
public class ParkDetailController {
	
	@Autowired
	private ParkDao dao;	
	@Autowired
	private ForecastDao forecastDao;
	private DateTimeFormatter formatter;
	
	public ParkDetailController (ParkDao dao) {
		this.dao = dao;
		this.formatter = DateTimeFormatter.ofPattern("E, MMM d");
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String showParkDetails(HttpServletRequest request) {	
		String parkCode = request.getParameter("parkCode");
		Park park = dao.getParkByParkCode(parkCode);
		request.setAttribute("park", park);
		List<Forecast> parkForecast = forecastDao.getForecastsForPark(parkCode);		
		request.setAttribute("parkForecast", parkForecast);
		request.setAttribute("formatter", formatter);
		return "parkDetails";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.POST)
	public String showParkDetails(@RequestParam String parkCode, ModelMap model, RedirectAttributes attrs) {	
		model.replace("isCelsius", !(Boolean)model.get("isCelsius"));
		attrs.addAttribute("parkCode", parkCode);
		return "redirect:/parkDetails";
	}
}
