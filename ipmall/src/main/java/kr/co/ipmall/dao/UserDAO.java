package kr.co.ipmall.dao;

import org.springframework.stereotype.Repository;

import kr.co.ipmall.model.exception.UserNotFoundException;
import kr.co.ipmall.vo.User;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
		// user 공통의 기본 정보 insert
		insert("user.insertUser",user);
		
		// 각각의 추가 정보 insert 
		if(user.getLevel() == User.CUSTOMER) {
			insert("user.insertCustomer",user);
		} else if(user.getLevel() == User.SELLER) {
			insert("user.insertSeller",user);
		} else {
			insert("user.insertManager",user);
		}
	}
	
	@SuppressWarnings("unchecked")
	public User selectUser(User user) {
		return (User)selectOne("user.selectUser",user);
	}
	
	@SuppressWarnings("unchecked")
	public User selectByEmail(String email) {
		try{
			return (User)selectOne("user.selectUser",email);
		} catch(UserNotFoundException ex) {
			return null;
		}
		
	}
	
	public void changePwd(User user) {
		update("user.updatePwd",user);
	}
	
	public void deleteUser(String email) {
		delete("user.deleteUser",email);
	}
	
	public void updateUser(User user) {
		update("updateUser",user);
	}

}
