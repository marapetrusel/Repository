package com.evozon.usermanagement.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evozon.usermanagement.data.LoginData;
import com.evozon.usermanagement.service.LoginService;

@Controller //ca sa fie instantiat cand porneste aplicatia
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view(Model model, Locale locale) {
		LoginData ld = new LoginData();
		model.addAttribute("logindata",ld);
		return "view";
	}
	
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String submitHandler(@ModelAttribute LoginData logindata, Model model) { //logindata de aici e cel din model.addAttirbute(...) iar daca vrem
		String viewName = "fail";
		
		String userName = logindata.getUsername();
		String pass = logindata.getPassword();
		
		if(loginService.validateLoginData(userName, pass)){
			viewName = "success";
		}
		
		return viewName;
	}
}
