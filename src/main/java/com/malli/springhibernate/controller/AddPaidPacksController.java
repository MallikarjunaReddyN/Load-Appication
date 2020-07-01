package com.malli.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.service.LoadService;

@Controller
public class AddPaidPacksController {
	
	@Autowired
	private LoadService loadService;
	@RequestMapping("/addpaid")
	public String addLoad(Model theModel) {
		theModel.addAttribute("addPaid", new PaidPacksInfo());
		return "addpaidpacks";
	}
	
	@PostMapping("/addpaidprocess")
	public String addLoadProcess(HttpServletRequest request, @ModelAttribute("addPaid") PaidPacksInfo addPaid) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("uname");
		addPaid.setUsername(username);
		loadService.addPaid(addPaid);
		return "redirect:/paid";
	}

}
