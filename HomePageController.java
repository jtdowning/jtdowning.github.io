package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;

@SessionAttributes("isCelsius")
@Controller
public class HomePageController {
	
	private ParkDao dao;
	
	@Autowired
	public HomePageController(ParkDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(path ="/", method = RequestMethod.GET)
		public String handleInput(HttpServletRequest request, ModelMap model) {
		List<Park> allParks = dao.getAllParks();
		request.setAttribute("allParks",allParks);
		if (!model.containsAttribute("isCelsius")) {
			model.addAttribute("isCelsius", false);
		}
		return "home";
	}

}
