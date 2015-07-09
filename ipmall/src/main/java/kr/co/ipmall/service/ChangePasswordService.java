package kr.co.ipmall.service;

import kr.co.ipmall.dao.UserDAO;


public interface ChangePasswordService {
	
	public void setUserDao(UserDAO userDao);
	
	public void changePassword(String email, String oldPwd, String newPwd);
}
