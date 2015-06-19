package com.idg.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idg.web.bean.User;
import com.idg.web.service.UserService;
import com.idg.web.untils.CookieEncryption;
import com.idg.web.untils.MD5;

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
		queryMap.put("password", MD5.EncoderByMd5(request.getParameter("enterPass")));
		queryMap.put("isActive", "1");
		
		List <User> userList = userService.findUser(queryMap);
		
		try {

			if(userList.size() > 0) {

				response.getWriter().write("success");
				
				Cookie cookie = new Cookie("idgUser", CookieEncryption.setCookie(userList.get(0).toCookie()));
				cookie.setMaxAge(Integer.MAX_VALUE);

				response.addCookie(cookie);
			}else{

				response.getWriter().write("fail");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

