package com.idg.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.idg.web.bean.Menu;
import com.idg.web.service.MenuService;

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
		
		getRequest();
	}
	
	  public static String getRequest() {
		  
		  	String requestUrl = "http://huaban.com/favorite/design/?iaxpuyr7&max=402757847&limit=20&wfl=1";
	        
		  	StringBuffer sb = new StringBuffer();
	        InputStream ips = getInputStream(requestUrl);
	        InputStreamReader isreader = null;
	        try {
	            isreader = new InputStreamReader(ips, "utf-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        BufferedReader bufferedReader = new BufferedReader(isreader);
	        String temp = null;
	        try {
	            while ((temp = bufferedReader.readLine()) != null) {
	                sb.append(temp);
	            }
	            bufferedReader.close();
	            isreader.close();
	            ips.close();
	            ips = null;
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	        return sb.toString();
	    }
	 
	    /**
	     * 从请求的URL中获取返回的流数据
	     * @param requestUrl
	     * @return InputStream
	     */
	    private static InputStream getInputStream(String requestUrl) {
	        URL url = null;
	        HttpURLConnection conn = null;
	        InputStream in = null;
	        try {
	            url = new URL(requestUrl);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	        try {
	            conn = (HttpURLConnection) url.openConnection();
	            conn.setDoInput(true);
	            conn.setRequestMethod("GET");
	            conn.connect();
	 
	            in = conn.getInputStream();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return in;
	    }
}
