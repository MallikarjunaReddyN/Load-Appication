package com.malli.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malli.springhibernate.model.LoginInfo;
import com.malli.springhibernate.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String showForm(Model theModel) {
		theModel.addAttribute("loginData", new LoginInfo());
		return "login";
	}
	
	@RequestMapping("/loginprocess")
	public String login(HttpServletRequest request, @ModelAttribute("loginData") LoginInfo loginInfo)
	{ 
		if(loginService.findUser(loginInfo.getUsrname(), loginInfo.getPassword()))
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname", loginInfo.getUsrname());
			String username = loginInfo.getUsrname().toUpperCase();
			session.setAttribute("username", username);
			return "user";
		}
		return "redirect:/login";
	}
}
