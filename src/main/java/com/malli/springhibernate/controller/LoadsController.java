package com.malli.springhibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
import com.malli.springhibernate.service.LoadService;

@Controller
public class LoadsController {
	@Autowired
	private LoadService loadService;
	@RequestMapping("/loads")
	public String showForm(HttpServletRequest request, Model theModel) 
	{
		HttpSession session = request.getSession();
		long ltotal=0;
		int lpacks=0;
		String uname = (String)session.getAttribute("uname");
		List<LoadInfo> loads = loadService.getLoads();
		ArrayList<LoadInfo> malli = new ArrayList<LoadInfo>();
		for(LoadInfo i:loads) {
			if(i.getUsername().equals(uname)) {
				malli.add(i);
				ltotal+=i.getLoadCost();
				lpacks+=i.getPacks();
			}
		}
		session.setAttribute("ltotal", ltotal);
		session.setAttribute("lpacks", lpacks);
		theModel.addAttribute("loads", malli);
		return "loads";
	}

	@GetMapping("/lsearch")
	public String searchByName(@RequestParam("theSearchName") String theName,HttpServletRequest request, Model theModel) 
	{
		HttpSession session = request.getSession();
		long ltotal=0;
		int lpacks=0;
		String uname = (String)session.getAttribute("uname");
		List<LoadInfo> loads = loadService.getLoadsByName(theName);
		ArrayList<LoadInfo> loadss = new ArrayList<LoadInfo>();
		for(LoadInfo i:loads) {
			if(i.getUsername().equals(uname)) {
				loadss.add(i);
				ltotal+=i.getLoadCost();
				lpacks+=i.getPacks();
			}
		}
		session.setAttribute("ltotal", ltotal);
		session.setAttribute("lpacks", lpacks);
		theModel.addAttribute("loads", loadss);
		return "loads";
	}
}
