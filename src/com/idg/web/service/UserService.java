package com.idg.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idg.web.bean.User;
import com.idg.web.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired UserRepository userRepository;
	
	public List<User> findUser(Map<String, String> queryMap){
		
		return userRepository.findUser(queryMap);
	}
}
