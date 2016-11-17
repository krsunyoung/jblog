package com.bit2016.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.Service.UserService;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
//	@Autowired
//	private BlogService blogService;
	
	//로그인 폼 이동 
	@RequestMapping("/loginform")
	public String login(){
		return "user/login";
	}
	//회원가입 jsp이동
	@RequestMapping("/joinform")
	public String join(@ModelAttribute UserVo userVo){
		return "user/join";
	}
	//회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, 
			@ModelAttribute CategoryVo categoryVo,
			BindingResult result, Model model){ 
		if(result.hasErrors()){
			model.addAllAttributes(result.getModel());
			return "user/join";
		}
		Long no = userService.join(userVo);
		userService.insert(no);
		userService.cainsert(no);
		return "redirect:/user/joinsuccess";
	}
	
	//로그인 폼 이동 
	@RequestMapping("/joinsuccess")
	public String joinsuccess(){
		return "user/joinsuccess";
	}


	
}
