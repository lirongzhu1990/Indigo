package com.idg.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idg.web.bean.Menu;
import com.idg.web.repository.MenuRepository;

@Service
@Transactional
public class MenuService {

	@Autowired 
	MenuRepository menuRepository;
	
	public List<Menu> findMenuByUser(String userId, int currentPage){
		
		return menuRepository.findMenuByUser(userId, currentPage);
	}
}
