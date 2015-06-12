package com.idg.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.idg.web.untils.ConstantEnum;

@Controller
public class FileUploadController extends ParentController{

	@RequestMapping(value = "fileUpload.idg")
	public void fileUpload(@RequestParam(value = "fileContent") MultipartFile fileContent,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String imgPath = request.getServletContext().getRealPath("/" + ConstantEnum.COVER_IMAGE_FOLDER);
			String imgName = UUID.randomUUID().toString().replaceAll("-", "") + fileContent.getOriginalFilename();
			
			File source = new File(imgPath + imgName);
			fileContent.transferTo(source);
			
			Map <String, String> map = new HashMap<String, String>();
			
			map.put("imgUrl", "./" + ConstantEnum.COVER_IMAGE_FOLDER + imgName);
			map.put("imgName", fileContent.getOriginalFilename());
			
			String jsonString = JSON.toJSONString(map, SerializerFeature.PrettyFormat); 
			response.getWriter().write(jsonString);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
