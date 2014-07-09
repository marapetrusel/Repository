package com.evozon.usermanagement.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evozon.usermanagement.HomeController;
import com.evozon.usermanagement.data.LoginData;
import com.evozon.usermanagement.service.DefaultLoginService;
import com.evozon.usermanagement.service.ILoginService;

@Controller //ca sa fie instantiat cand porneste aplicatia
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	private String[] tokens = new String[]{"Razvan","Sami","Mara","Cristina","Ale"};
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view(Model model, Locale locale){
		LoginData ld = new LoginData();
		model.addAttribute("logindata",ld);
		return "view";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST) //po
	public String submitHandler(@ModelAttribute LoginData logindata, Model model){ //logindata de aici e cel din model.addAttirbute(...) iar daca vrem
		String userName = logindata.getUsername();											 //alt nume punem @ModelAttribute(logindata) LoginData logdata
		model.addAttribute("currentuser", userName);
		String pass = logindata.getPassword();
		model.addAttribute("currentpassword", pass);
		
		if(loginService.validateLoginData(userName, pass)){
			return "success";
		}
		
		return "fail";
	}
}
