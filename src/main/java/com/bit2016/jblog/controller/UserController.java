package com.bit2016.jblog.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.jblog.Service.BlogService;
import com.bit2016.jblog.Service.UserService;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
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
			BindingResult result,
			Model model){ 
		if(result.hasErrors()){
			model.addAllAttributes(result.getModel());
			return "user/join";
		}
		Long no = userService.join(userVo);
		blogService.insert(no);
		return "redirect:/user/joinsuccess";
	}
	
	//로그인 폼 이동 
	@RequestMapping("/joinsuccess")
	public String joinsuccess(){
		return "user/joinsuccess";
	}

//	@RequestMapping("/login")
//	public String login(
//			@RequestParam(value="id", required=true, defaultValue=" ") String id,
//			@RequestParam(value="password", required=true, defaultValue=" ") String password,
//			HttpSession session){
//		UserVo userVo = userService.login(id, password);
//		if(userVo == null){
//			return "redirect:/user/loginform?result=fail";
//		}
//		System.out.println(userVo.getId());
//		//인증성공 (처리)
//		session.setAttribute("authUser", userVo);
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session){
//		session.removeAttribute("authUser");
//		session.invalidate();
//		return "redirect:/";
//	}
	
	
}
