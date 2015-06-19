package com.idg.web.untils;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.idg.web.bean.User;
import com.idg.web.service.UserService;

public class IndigoRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		
		Map<String, String> queryMap = new HashMap<String, String>();
		
		queryMap.put("name", token.getPrincipal().toString());
		queryMap.put("isActive", "1");
		
		User user = new User();
		
		if(userService.findUser(queryMap).size() > 0) {

			user = userService.findUser(queryMap).get(0);
		}else{
			
			throw new UnknownAccountException("没有找到该账号");
		}
		
		return new SimpleAuthenticationInfo(user.getId(),user.getName(),getClass().getName());
	}

}
