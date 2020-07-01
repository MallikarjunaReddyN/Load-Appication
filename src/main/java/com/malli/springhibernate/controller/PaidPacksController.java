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

import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
import com.malli.springhibernate.service.PaidPackService;

@Controller
public class PaidPacksController {
	@Autowired
	private PaidPackService paidPackService;
	@RequestMapping("/paid")
	public String packSold(HttpServletRequest request, Model theModel) 
	{
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("uname");
		long ptotal=0;
		int ppacks=0;
		List<PaidPacksInfo> loads = paidPackService.getPaidPacks();
		ArrayList<PaidPacksInfo> malli = new ArrayList<PaidPacksInfo>();
		for(PaidPacksInfo i:loads) {
			if(i.getUsername().equals(uname)) {
				malli.add(i);
				ptotal+=i.getPaidCost();
				ppacks+=i.getPacks();
			}
		}
		session.setAttribute("ptotal", ptotal);
		session.setAttribute("ppacks", ppacks);
		theModel.addAttribute("loads", malli);
		return "paidpacks";
	}
	
	@GetMapping("/psearch")
	public String searchByName(@RequestParam("theSearchName") String theName,HttpServletRequest request, Model theModel) 
	{
		HttpSession session = request.getSession();
		long ptotal=0;
		int ppacks=0;
		String uname = (String)session.getAttribute("uname");
		List<PaidPacksInfo> loads = paidPackService.getPaidPacksByName(theName);
		ArrayList<PaidPacksInfo> spacks = new ArrayList<PaidPacksInfo>();
		for(PaidPacksInfo i:loads) {
			if(i.getUsername().equals(uname)) {
				spacks.add(i);
				ptotal+=i.getPaidCost();
				ppacks+=i.getPacks();
			}
		}
		session.setAttribute("ptotal", ptotal);
		session.setAttribute("ppacks", ppacks);
		theModel.addAttribute("loads", spacks);
		return "paidpacks";
	}
}
