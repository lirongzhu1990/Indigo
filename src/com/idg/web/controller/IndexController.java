package com.idg.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.idg.web.bean.Menu;
import com.idg.web.service.MenuService;
import com.idg.web.untils.ConstantEnum;

@Controller
public class IndexController extends ParentController {

	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		return "index";
	}
	
	@RequestMapping(value="getMenu")
	public void getMenu(HttpServletRequest request, HttpServletResponse response) {
		
		List<Menu> listMenu = menuService.findMenuByUser("1", Integer.parseInt(request.getParameter("currentPage")));
		
		String jsonString = JSON.toJSONString(listMenu, SerializerFeature.PrettyFormat); 
			
		try {
			
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
