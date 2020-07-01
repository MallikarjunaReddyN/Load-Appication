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

import com.malli.springhibernate.model.SoldPacksInfo;
import com.malli.springhibernate.service.SoldPacksService;

@Controller
public class SoldPacksController {

	@Autowired
	private SoldPacksService soldPacksService;
	@RequestMapping("/sold")
	public String packSold(HttpServletRequest request, Model theModel) 
	{
		HttpSession session = request.getSession();
		long total=0;
		int packs=0;
		String uname = (String)session.getAttribute("uname");
		List<SoldPacksInfo> loads = soldPacksService.getSoldPacks();
		ArrayList<SoldPacksInfo> malli = new ArrayList<SoldPacksInfo>();
		for(SoldPacksInfo i:loads) {
			if(i.getUsername().equals(uname)) {
				malli.add(i);
				total+=i.getCost();
				packs+=i.getPacks();
			}
		}
		session.setAttribute("total", total);
		session.setAttribute("packs", packs);
		theModel.addAttribute("loads", malli);
		return "soldpacks";
	}
	
	@GetMapping("/search")
	public String searchByName(@RequestParam("theSearchName") String theName,HttpServletRequest request, Model theModel) 
	{
		HttpSession session = request.getSession();
		long total=0;
		int packs=0;
		String uname = (String)session.getAttribute("uname");
		List<SoldPacksInfo> loads = soldPacksService.getSoldPacksByName(theName);
		ArrayList<SoldPacksInfo> spacks = new ArrayList<SoldPacksInfo>();
		for(SoldPacksInfo i:loads) {
			if(i.getUsername().equals(uname)) {
				spacks.add(i);
				total+=i.getCost();
				packs+=i.getPacks();
			}
		}
		session.setAttribute("total", total);
		session.setAttribute("packs", packs);
		theModel.addAttribute("loads", spacks);
		return "soldpacks";
	}
}
