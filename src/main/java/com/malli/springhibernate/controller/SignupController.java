package com.malli.springhibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malli.springhibernate.model.LoginInfo;
import com.malli.springhibernate.model.SignupInfo;
import com.malli.springhibernate.service.SignupService;

@Controller
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	@RequestMapping("/signup")
	public String signup(Model theModel)
	{
		theModel.addAttribute("signupData", new SignupInfo());
		return "signup";
	}
	
	@PostMapping(path="/signupprocess")
	public String signup(@ModelAttribute("signupData") SignupInfo signupInfo, Model theModel)
	{
		if(signupInfo.getUsername()==null || signupInfo.getUsername()==""||
				signupInfo.getPassword()==null || signupInfo.getPassword()=="" ||
				signupInfo.getEmail()==null || signupInfo.getEmail()=="")  
        {  
            return "redirect:/signup";  
        }  
   else  
        { 
		signupService.addUser(signupInfo);
		theModel.addAttribute("loginData", new LoginInfo());
		return "redirect:/login";
        }
	}
}
