package kr.co.ipmall.service;

import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.vo.AuthInfo;


public interface AuthService {
	
	public void setUserDao(UserDAO userDao);
	public AuthInfo authenticate(String email, String password) throws Exception;

}
