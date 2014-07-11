package com.evozon.usermanagement.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evozon.usermanagement.HomeController;
import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.service.ILoginService;
import com.evozon.usermanagement.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired 
	private ILoginService iloginservice; 
			
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {	
		Date date = new Date();	
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		User user= new User();
		model.addAttribute("user", user);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "login";	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute User user, Model model){
		String username = user.getUsername();
		String password = user.getPassword();
		if(!iloginservice.verifyInput(username, password)) {
			return "fail";
		}
		return "success";	
	}
	
	/*@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String fct(@RequestParam String bla, Model model) {
		model.addAttribute("bla", bla);
		return "home";
	}
	
	@RequestMapping(value = "/test/{str}", method = RequestMethod.GET)
	public String path(@PathVariable String str, Model model) {
		model.addAttribute("bla", str);
		return "home";	
	}
	*/
	
}
