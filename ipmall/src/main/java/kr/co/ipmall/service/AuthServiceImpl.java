package kr.co.ipmall.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.model.exception.IdPasswordNotMatchingException;
import kr.co.ipmall.model.exception.UserNotFoundException;
import kr.co.ipmall.vo.AuthInfo;
import kr.co.ipmall.vo.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service("authService")
public class AuthServiceImpl implements AuthService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userDAO")
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	// 이메일과 비밀번호를 통해 로그인 여부 판단
	@SuppressWarnings("unused")
	public AuthInfo authenticate(String email, String password) throws Exception{

		// User 객체로 곧바로 받을 수 없기 때문에 user 초기화를 통해 객체 생성
		Map<String, Object> map = userDao.selectByEmail(email);
		User user = new User((String)map.get("email"), (String)map.get("pw"), (String)map.get("name"), (String)map.get("phone"), (int)map.get("level"),(Date)map.get("create_time"), (Date)map.get("update_time"),
				(String)map.get("account_num"), (String)map.get("account_name"), (int)map.get("status"));
		
		// 각 로그인 exception 처리
		if(user == null){
			throw new IdPasswordNotMatchingException();
		}
		if(!user.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		
		// 이메일, 이름 반환
		return new AuthInfo(user.getEmail(),user.getName());
	}
}
