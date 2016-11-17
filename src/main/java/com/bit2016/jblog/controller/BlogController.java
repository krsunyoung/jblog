package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.Service.BlogService;
import com.bit2016.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/{userId}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping("")
	public String index(@PathVariable String userId, Model model) {
		if (!blogService.getByNo(userId)) {
			return "redirect:/";
		}
		List<CategoryVo> list = blogService.getList(userId);
		model.addAttribute("list", list);
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

}
