package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.Service.BlogService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
@RequestMapping("/{userId:(?!assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping("")
	public String index(@PathVariable String userId, Model model) {
		if (!blogService.getByNo(userId)) {
			return "redirect:/";
		}
		
		BlogVo blogVo= blogService.getID(userId);
		List<CategoryVo> list = blogService.getList(userId);
		
		model.addAttribute("list", list);
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("userId", userId);
		
		return "blog/blog-main";
	}

	@RequestMapping("/admin/basic")
	public String admin() {
		return "blog/blog-admin-basic";
	}

	@RequestMapping("/admin/category")
	public String category() {
		return "blog/blog-admin-category";
	}
	
	@Auth
	@RequestMapping(value="/admin/upload",method=RequestMethod.POST)
	public String adminUpdate(@PathVariable String userId,
			Model model,
			@AuthUser UserVo authUser,
			@ModelAttribute BlogVo blogVo,
			@RequestParam( "file" ) MultipartFile multipartFile){
		
		blogVo.setUsers_no(authUser.getNo());
		blogService.basicUpdate(blogVo, userId);
		System.out.println("-------");
		blogService.restore(blogVo, multipartFile, userId);
		
		model.addAttribute("userId", userId);
		
		return "redirect:/{userId}";
		
	}
	
	

}
