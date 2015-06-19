package com.idg.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idg.web.bean.User;
import com.idg.web.service.UserService;

@Controller
public class RegisterController extends ParentController {

	@Autowired UserService userService;
	
	@RequestMapping(value="register")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		return "register";
	}
	
	@RequestMapping(value="submitRegister",method = RequestMethod.POST)
	public void registerForm(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			User user = new User();
			
			user.setName(request.getParameter("enterName"));
			user.setEmail(request.getParameter("enterEmail"));
			user.setPassword(request.getParameter("enterPassword"));
			user.setAlias(request.getParameter("enterAlias"));
			user.setAge(Integer.parseInt(request.getParameter("enterAge")));
			user.setAddress(request.getParameter("enterAddress"));
			user.setImageUrl(request.getParameter("imageUrl"));
			user.setIsActive(1);
			
			userService.saveUser(user);
			
			response.getWriter().write("success");
			
		}catch (Exception e){
			
			e.printStackTrace();
		}
	}
}
