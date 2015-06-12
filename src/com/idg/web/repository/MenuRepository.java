package com.idg.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.idg.web.bean.Menu;
import com.idg.web.bean.UserMenu;

@Repository
public class MenuRepository extends ParentRepository {

	@SuppressWarnings("unchecked")
	public List<Menu> findMenuByUser(String userId, int currentPage){
		
		List<Menu> returnMenu = new ArrayList <Menu>();
		
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(" from UserMenu where userId =" + userId );
		
		query.setFirstResult((currentPage - 1) * 20);
		query.setMaxResults(20);
		
		List <UserMenu> userMenuList = (List <UserMenu>) query.list();
		
		for (UserMenu userMenu : userMenuList) {
			
			Menu menu = (Menu) getHibernateTemplate(). find("from Menu where id = " + userMenu.getMenuId()).get(0);
			returnMenu.add(menu);
		}
		
		return returnMenu;
	}
}
