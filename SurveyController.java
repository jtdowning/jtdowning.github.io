package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;

@Controller
public class SurveyController {

	@Autowired
	private ParkDao parkDao;
	private SurveyDao surveyDao;
	
	public SurveyController(ParkDao parkDao, SurveyDao surveyDao) {
		this.parkDao = parkDao;
		this.surveyDao = surveyDao;
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET) 
	public String showSurvey(HttpServletRequest request) {
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST) 
	public String postSurveyResults (HttpServletRequest request, Survey survey) {
		surveyDao.addSurveyResult(survey);
		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String showSurveyResults (HttpServletRequest request) {
		List<Park> topFiveParks = parkDao.getTopFiveParks();
		request.setAttribute("topFiveParks", topFiveParks);
		return "surveyResults";
	}
}
