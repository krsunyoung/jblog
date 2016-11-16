package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.Service.BlogService;

@Controller
@RequestMapping("/blog/{userId}")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("")
	public String index(@PathVariable String userId, Model model){
		if(!blogService.getByNo(userId)){
			return "redirect:/";
		}
		
		model.addAttribute("userId", userId);
		return "blog/blog-main";
	}
	
	
	
}
