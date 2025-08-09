package com.hasnat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hasnat.alien.Alien;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String hello() {
		return "welcome";
	}
	
//	@RequestMapping("/add")
//	public ModelAndView addition(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
//		ModelAndView mv = new ModelAndView() ;
//		
//		mv.setViewName("result");
//		
//		int res= num1 + num2;
//		mv.addObject("res",res);
//		
//		return mv ;
//	}
	
	
	@RequestMapping("/add")
	public String addition(@RequestParam("num1") int num1,@RequestParam("num2") int num2, ModelMap map) {
		
		
		int res= num1 + num2;
		map.addAttribute("res",res);
		
		return "result" ;
	}
	
//	@RequestMapping("/alien")
//	public String addAlien(@RequestParam("aId") int aid,@RequestParam("aname") String aName, ModelMap map) {
//		
//		Alien alien = new Alien();
//		alien.setAId(aid);
//		alien.setAName(aname);
//		
//		map.addAttribute("alien",alien);
//		
//		return"alien";
//	}
	
	
//	
//	@RequestMapping("/alien")
//	public String addAlien(@ModelAttribute("a") Alien alien) {
//		return"alien";
//	}
	
	@RequestMapping("/alien")
	public String addAlien(Alien alien) {
		return"alien";
	}
	
	
}





