package kr.co.ipmall.service.userService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.model.exception.UserNotFoundException;
import kr.co.ipmall.vo.User;

@Service("changePasswordService")
public class ChangePasswordServiceImpl implements ChangePasswordService  {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userDAO")
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	// 패스워드 변경
	@SuppressWarnings("unused")
	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		User user = userDao.selectByEmail(email);
		
		/*
		User user = new User((String)map.get("email"), (String)map.get("pw"), (String)map.get("name"), (String)map.get("phone"), (int)map.get("level"),(Date)map.get("create_time"), (Date)map.get("update_time"),
				(String)map.get("account_num"), (String)map.get("account_name"), (int)map.get("status"));
				*/
		
		if (user == null)
			throw new UserNotFoundException();
		
		user.changePassword(oldPwd, newPwd);
		
		userDao.changePwd(user);
	}
}
