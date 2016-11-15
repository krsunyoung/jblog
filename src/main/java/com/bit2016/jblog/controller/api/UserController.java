package com.bit2016.jblog.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.jblog.Service.UserService;

@Controller("userApiController")
@RequestMapping("/user/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkid")
	public Object checkEmail(  //Map<String, Object>  대신 Object로 써줘도 됨
			@RequestParam(value="id",required=true, defaultValue="" ) String id
			){
	//	SingletonClass sc = SingletonClass.getInstance();
		
		boolean result = userService.idExist(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		
		if(result){
			map.put("data", "exist");
		}else{
			map.put("data", "not exist");
		}
		
		return map; 
	}
}
