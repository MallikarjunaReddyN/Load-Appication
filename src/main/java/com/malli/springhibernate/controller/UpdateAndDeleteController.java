package com.malli.springhibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
import com.malli.springhibernate.service.UpdateAndDeleteService;

@Controller
public class UpdateAndDeleteController {

	@Autowired
	private UpdateAndDeleteService updateAndDeleteService;
	@RequestMapping("/updateload")
	public String updateLoad(@RequestParam("loadId") int loadId, Model theModel) 
	{
		LoadInfo load = updateAndDeleteService.updateLoad(loadId);
		theModel.addAttribute("addLoad", load);
		return "addload";
	}
	
	@RequestMapping("/deleteload")
	public String deleteLoad(@RequestParam("loadId") int loadId, Model theModel) 
	{
		updateAndDeleteService.deleteLoad(loadId);
		return "redirect:/loads";
	}
	
	//sold
	@RequestMapping("/updatesold")
	public String updateSold(@RequestParam("id") int soldId, Model theModel) 
	{
		SoldPacksInfo load = updateAndDeleteService.updateSold(soldId);
		theModel.addAttribute("addsold", load);
		return "addsoldpacks";
	}
	
	@RequestMapping("/deletesold")
	public String deleteSold(@RequestParam("id") int soldId, Model theModel) 
	{
		updateAndDeleteService.deleteSold(soldId);
		return "redirect:/sold";
	}
	
	//paid
	@RequestMapping("/updatepaid")
	public String updatePaid(@RequestParam("id") int paidId, Model theModel) 
	{
		PaidPacksInfo load = updateAndDeleteService.updatePaid(paidId);
		theModel.addAttribute("addPaid", load);
		return "addpaidpacks";
	}
	
	@RequestMapping("/deletepaid")
	public String deletePaid(@RequestParam("id") int paidId, Model theModel) 
	{
		updateAndDeleteService.deletePaid(paidId);
		return "redirect:/paid";
	}
}
