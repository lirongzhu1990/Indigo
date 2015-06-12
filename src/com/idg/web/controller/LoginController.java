package com.idg.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idg.web.service.UserService;

@Controller
public class LoginController extends ParentController{

	@Autowired UserService userService;
	
	@RequestMapping(value="initLogin")
	public String initLogin(HttpServletRequest request, HttpServletResponse response){
		
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, String> queryMap = new HashMap<String, String>();
		
		queryMap.put("name", request.getParameter("enterName"));
		queryMap.put("password", request.getParameter("enterPass"));
		queryMap.put("isActive", "1");
		
		try {

			if(userService.findUser(queryMap).size() > 0) {

				response.getWriter().write("success");
			}else{

				response.getWriter().write("fail");
			}

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

