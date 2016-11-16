package com.bit2016.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.jblog.Service.UserService;
import com.bit2016.jblog.dto.JSONResult;

@Controller("userApiController")
@RequestMapping("/user/api")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkid( // Map<String, Object> 대신 Object로 써줘도 됨
			@RequestParam(value = "id", required = true, defaultValue = "") String id) {
		
		boolean result = userService.idExist(id);

		return JSONResult.success(result ? "exist" : "not exist");
	}

}
