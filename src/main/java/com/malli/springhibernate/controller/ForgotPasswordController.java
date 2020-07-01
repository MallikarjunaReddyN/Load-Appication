package com.malli.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malli.springhibernate.model.ForgotInfo;
import com.malli.springhibernate.service.LoginService;

@Controller
public class ForgotPasswordController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/forgotpassword")
	public String forgotPassword(Model theModel)
	{
		theModel.addAttribute("forgotData", new ForgotInfo());
		return "forgotpassword";
	}
	
	@PostMapping("/forgotpasswordprocess")
	public String login(HttpServletRequest request, @ModelAttribute("forgotData") ForgotInfo forgotInfo)
	{
		if(forgotInfo.getUsername()==null || forgotInfo.getUsername()==""||
				forgotInfo.getPassword()==null || forgotInfo.getPassword()=="" ||
						forgotInfo.getConfirm()==null || forgotInfo.getConfirm()=="") {
            return "redirect:/forgotpassword";  
        }  
		else if(forgotInfo.getPassword().equals(forgotInfo.getConfirm())) {
			HttpSession session = request.getSession();
			session.setAttribute("forgotInfo", forgotInfo);
			loginService.updatepassword(forgotInfo);
			return "redirect:/login";
		}
		else {
			return "redirect:/forgotpassword";
		}
		
	}

}
