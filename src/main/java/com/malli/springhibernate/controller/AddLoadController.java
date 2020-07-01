package com.malli.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.service.LoadService;

@Controller
public class AddLoadController {
	
	@Autowired
	private LoadService loadService;
	@RequestMapping("/addload")
	public String addLoad(Model theModel) {
		theModel.addAttribute("addLoad", new LoadInfo());
		return "addload";
	}
	
	@PostMapping("/addloadprocess")
	public String addLoadProcess(HttpServletRequest request, @ModelAttribute("addLoad") LoadInfo addLoad) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("uname");
		addLoad.setUsername(username);
		loadService.addLoad(addLoad);
		return "redirect:/loads";
	}

}
