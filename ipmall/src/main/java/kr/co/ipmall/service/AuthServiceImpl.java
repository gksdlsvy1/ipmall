package kr.co.ipmall.service;

import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.dao.vo.AuthInfo;
import kr.co.ipmall.dao.vo.User;
import kr.co.ipmall.model.exception.IdPasswordNotMatchingException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service("authService")
public class AuthServiceImpl implements AuthService{
	Logger log = Logger.getLogger(this.getClass());
	
	private UserDAO userDao;
	
	public void setMemberDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		User user = userDao.selectByEmail(email);
		
		if(user == null){
			throw new IdPasswordNotMatchingException();
		}
		if(!user.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(user.getEmail(),user.getName());
	}
}
