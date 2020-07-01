package com.malli.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malli.springhibernate.model.SoldPacksInfo;
import com.malli.springhibernate.service.LoadService;

@Controller
public class AddSoldPacksController {
	
	@Autowired
	private LoadService loadService;
	@RequestMapping("/addsold")
	public String addLoad(Model theModel) {
		theModel.addAttribute("addsold", new SoldPacksInfo());
		return "addsoldpacks";
	}
	
	@PostMapping("/addsoldprocess")
	public String addLoadProcess(HttpServletRequest request, @ModelAttribute("addsold") SoldPacksInfo addSold) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("uname");
		addSold.setUsername(username);
		loadService.addSoldpack(addSold);
		return "redirect:/sold";
	}

}
