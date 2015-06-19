package com.idg.web.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.idg.web.bean.User;

@Repository 
public class UserRepository extends ParentRepository {
	
	@SuppressWarnings("unchecked")
	public List<User> findUser(Map<String, String> queryMap){
		
		String hql = " from User ";
		StringBuffer querySb = new StringBuffer();
		boolean hasQuery = false;
		
		Iterator< Map.Entry<String, String> > queryMapit = queryMap.entrySet().iterator();
		
		while (queryMapit.hasNext()) {
			
			hasQuery = true;
			String key = queryMapit.next().getKey();
			querySb.append( key + " = '" + queryMap.get(key) + "' and ");
		}
		
		if(hasQuery){
			
			hql = hql + " Where " + StringUtils.removeEnd(querySb.toString(), " and ");
		}
		
		return ( List<User> )getHibernateTemplate().find(hql);
	}
	
	public User saveUser(User user){
		
		getHibernateTemplate().save(user);
		return user;
	}
}
