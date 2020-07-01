package com.malli.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String showForm(HttpServletRequest request, Model theModel) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		return "redirect:/login";
	}
}
